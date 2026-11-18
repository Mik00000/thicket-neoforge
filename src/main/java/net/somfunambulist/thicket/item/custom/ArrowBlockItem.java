package net.somfunambulist.thicket.item.custom;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;




public class ArrowBlockItem
extends ArrowItem {
    private final Block block;

    public ArrowBlockItem(Item.Properties pProperties, Block block) {
        super(pProperties);
        this.block = block;
    }

    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult interactionresult = this.place(new BlockPlaceContext(pContext));
        if (!interactionresult.consumesAction() && pContext.getItemInHand().has(DataComponents.FOOD)) {
            InteractionResult interactionresult1 = this.use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand()).getResult();
            return interactionresult1 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionresult1;
        }
        return interactionresult;
    }

    public InteractionResult place(BlockPlaceContext pContext) {
        if (!this.getBlock().isEnabled(pContext.getLevel().enabledFeatures())) {
            return InteractionResult.FAIL;
        }
        if (!pContext.canPlace()) {
            return InteractionResult.FAIL;
        }
        BlockPlaceContext blockplacecontext = this.updatePlacementContext(pContext);
        if (blockplacecontext == null) {
            return InteractionResult.FAIL;
        }
        BlockState blockstate = this.getPlacementState(blockplacecontext);
        if (blockstate == null) {
            return InteractionResult.FAIL;
        }
        if (!this.placeBlock(blockplacecontext, blockstate)) {
            return InteractionResult.FAIL;
        }
        BlockPos blockpos = blockplacecontext.getClickedPos();
        Level level = blockplacecontext.getLevel();
        Player player = blockplacecontext.getPlayer();
        ItemStack itemstack = blockplacecontext.getItemInHand();
        BlockState blockstate1 = level.getBlockState(blockpos);
        if (blockstate1.is(blockstate.getBlock())) {
            blockstate1 = this.updateBlockStateFromTag(blockpos, level, itemstack, blockstate1);
            blockstate1.getBlock().setPlacedBy(level, blockpos, blockstate1, (LivingEntity)player, itemstack);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }
        }
        SoundType soundtype = blockstate1.getSoundType((LevelReader)level, blockpos, (Entity)pContext.getPlayer());
        level.playSound(player, blockpos, this.getPlaceSound(blockstate1, level, blockpos, pContext.getPlayer()), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0f) / 2.0f, soundtype.getPitch() * 0.8f);
        level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of((Entity)player, (BlockState)blockstate1));
        if (player == null || !player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        return InteractionResult.sidedSuccess((boolean)level.isClientSide);
    }

    @Deprecated
    protected SoundEvent getPlaceSound(BlockState pState) {
        return pState.getSoundType().getPlaceSound();
    }

    protected SoundEvent getPlaceSound(BlockState state, Level world, BlockPos pos, Player entity) {
        return state.getSoundType((LevelReader)world, pos, (Entity)entity).getPlaceSound();
    }

    @Nullable
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext pContext) {
        return pContext;
    }

    @Nullable
    protected BlockState getPlacementState(BlockPlaceContext pContext) {
        BlockState blockstate = this.getBlock().getStateForPlacement(pContext);
        return blockstate != null && this.canPlace(pContext, blockstate) ? blockstate : null;
    }

    private BlockState updateBlockStateFromTag(BlockPos pPos, Level pLevel, ItemStack pStack, BlockState pState) {
        net.minecraft.world.item.component.BlockItemStateProperties blockItemStateProperties = pStack.getOrDefault(DataComponents.BLOCK_STATE, net.minecraft.world.item.component.BlockItemStateProperties.EMPTY);
        if (blockItemStateProperties.isEmpty()) {
            return pState;
        }
        BlockState blockState = blockItemStateProperties.apply(pState);
        if (blockState != pState) {
            pLevel.setBlock(pPos, blockState, 2);
        }
        return blockState;
    }

    private static <T extends Comparable<T>> BlockState updateState(BlockState pState, Property<T> pProperty, String pValueIdentifier) {
        return pProperty.getValue(pValueIdentifier).map(p_40592_ -> (BlockState)pState.setValue(pProperty, p_40592_)).orElse(pState);
    }

    protected boolean canPlace(BlockPlaceContext pContext, BlockState pState) {
        Player player = pContext.getPlayer();
        CollisionContext collisioncontext = player == null ? CollisionContext.empty() : CollisionContext.of((Entity)player);
        return (!this.mustSurvive() || pState.canSurvive((LevelReader)pContext.getLevel(), pContext.getClickedPos())) && pContext.getLevel().isUnobstructed(pState, pContext.getClickedPos(), collisioncontext);
    }

    protected boolean mustSurvive() {
        return true;
    }

    protected boolean placeBlock(BlockPlaceContext pContext, BlockState pState) {
        return pContext.getLevel().setBlock(pContext.getClickedPos(), pState, 11);
    }

    public String getDescriptionId() {
        return this.getBlock().getDescriptionId();
    }

    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pContext, pTooltip, pFlag);
        this.getBlock().appendHoverText(pStack, pContext, pTooltip, pFlag);
    }

    public Block getBlock() {
        return this.block;
    }

    private Block getBlockRaw() {
        return this.block;
    }

    public void registerBlocks(Map<Block, Item> pBlockToItemMap, Item pItem) {
        pBlockToItemMap.put(this.getBlock(), pItem);
    }

    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        blockToItemMap.remove(this.getBlock());
    }

    public boolean canFitInsideContainerItems() {
        return !(this.block instanceof ShulkerBoxBlock);
    }

    public FeatureFlagSet requiredFeatures() {
        return this.getBlock().requiredFeatures();
    }
}

