/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.ShearsItem
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseFireBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.CampfireBlock
 *  net.minecraft.world.level.block.CandleBlock
 *  net.minecraft.world.level.block.CandleCakeBlock
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraftforge.fml.ModList
 */
package net.somfunambulist.thicket.item.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.fml.ModList;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.block.compat.WindsweptBlocks;

public class PocketKnifeItem
extends ShearsItem {
    private static final Map<Block, Supplier<Block>> CARVING_BLOCKS = new HashMap<Block, Supplier<Block>>();

    public static void registerCarvingBlock(Block from, Supplier<Block> to) {
        CARVING_BLOCKS.put(from, to);
    }

    public static Set<Map.Entry<Block, Supplier<Block>>> getCarvingBlocks() {
        return CARVING_BLOCKS.entrySet();
    }

    public PocketKnifeItem(Item.Properties properties) {
        super(properties);
    }

    public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
        return repairStack.is(Items.IRON_INGOT);
    }

    private InteractionResult replaceBlock(UseOnContext context, BlockState to, boolean particles) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState from = level.getBlockState(pos);
        level.setBlockAndUpdate(pos, (BlockState)to.setValue((Property)RotatedPillarBlock.AXIS, (Comparable)((Direction.Axis)from.getValue((Property)RotatedPillarBlock.AXIS))));
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of((Entity)context.getPlayer(), (BlockState)from));
        if (particles) {
            level.addDestroyBlockEffect(pos, from);
        }
        if (context.getPlayer() != null) {
            context.getPlayer().playSound(SoundEvents.AXE_STRIP, 1.0f, 1.5f);
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), LivingEntity.getSlotForHand(context.getHand()));
        }
        return InteractionResult.sidedSuccess((boolean)level.isClientSide);
    }

    public InteractionResult useOn(UseOnContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        Supplier<Block> carving = CARVING_BLOCKS.get(state.getBlock());
        if (carving != null) {
            return this.replaceBlock(context, carving.get().defaultBlockState(), true);
        }
        if (context.getPlayer().getOffhandItem().is(Items.FLINT)) {
            BlockPos blockpos;
            Player player = context.getPlayer();
            Level level = context.getLevel();
            BlockState blockstate = level.getBlockState(blockpos = context.getClickedPos());
            if (!(CampfireBlock.canLight((BlockState)blockstate) || CandleBlock.canLight((BlockState)blockstate) || CandleCakeBlock.canLight((BlockState)blockstate))) {
                BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
                if (BaseFireBlock.canBePlacedAt((Level)level, (BlockPos)blockpos1, (Direction)context.getHorizontalDirection())) {
                    level.playSound(player, blockpos1, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0f, level.getRandom().nextFloat() * 0.4f + 0.8f);
                    BlockState blockstate1 = BaseFireBlock.getState((BlockGetter)level, (BlockPos)blockpos1);
                    level.setBlock(blockpos1, blockstate1, 11);
                    level.gameEvent((Entity)player, GameEvent.BLOCK_PLACE, blockpos);
                    ItemStack itemstack = context.getItemInHand();
                    if (player instanceof ServerPlayer) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos1, itemstack);
                        itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }
                    return InteractionResult.sidedSuccess((boolean)level.isClientSide());
                }
                return InteractionResult.FAIL;
            }
            level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0f, level.getRandom().nextFloat() * 0.4f + 0.8f);
            level.setBlock(blockpos, (BlockState)blockstate.setValue((Property)BlockStateProperties.LIT, (Comparable)Boolean.valueOf(true)), 11);
            level.gameEvent((Entity)player, GameEvent.BLOCK_CHANGE, blockpos);
            if (player != null) {
                context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }
            return InteractionResult.sidedSuccess((boolean)level.isClientSide());
        }
        return super.useOn(context);
    }

    static {
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_OAK_LOG, ModBlocks.OAK_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_BIRCH_LOG, ModBlocks.BIRCH_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.SPRUCE_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.JUNGLE_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_ACACIA_LOG, ModBlocks.ACACIA_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.DARK_OAK_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.MANGROVE_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_CHERRY_LOG, ModBlocks.CHERRY_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_CRIMSON_STEM, ModBlocks.CRIMSON_CARVING);
        PocketKnifeItem.registerCarvingBlock(Blocks.STRIPPED_WARPED_STEM, ModBlocks.WARPED_CARVING);
        PocketKnifeItem.registerCarvingBlock((Block)ModBlocks.STRIPPED_HAZEL_LOG.get(), ModBlocks.HAZEL_CARVING);
        PocketKnifeItem.registerCarvingBlock((Block)ModBlocks.STRIPPED_MYRRH_LOG.get(), ModBlocks.MYRRH_CARVING);
        PocketKnifeItem.registerCarvingBlock((Block)ModBlocks.STRIPPED_GREEN_MYRRH_LOG.get(), ModBlocks.GREEN_MYRRH_CARVING);
        PocketKnifeItem.registerCarvingBlock((Block)ModBlocks.STRIPPED_BOSWELLIA_LOG.get(), ModBlocks.BOSWELLIA_CARVING);
        PocketKnifeItem.registerCarvingBlock((Block)ModBlocks.STRIPPED_RED_BOSWELLIA_LOG.get(), ModBlocks.RED_BOSWELLIA_CARVING);
        if (ModList.get().isLoaded("windswept")) {
            Block block = (Block)BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("windswept", "stripped_chestnut_log"));
            if (block != null) {
                PocketKnifeItem.registerCarvingBlock(block, WindsweptBlocks.CHESTNUT_CARVING);
            }
            if ((block = (Block)BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("windswept", "stripped_holly_log"))) != null) {
                PocketKnifeItem.registerCarvingBlock(block, WindsweptBlocks.HOLLY_CARVING);
            }
            if ((block = (Block)BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("windswept", "stripped_pine_log"))) != null) {
                PocketKnifeItem.registerCarvingBlock(block, WindsweptBlocks.PINE_CARVING);
            }
        }
    }
}

