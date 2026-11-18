/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.biome.Biomes
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraftforge.common.Tags$Biomes
 */
package net.somfunambulist.thicket.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.Tags;

public class EnchantedMistletoeItem
extends Item {
    public EnchantedMistletoeItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    private InteractionResult replaceBlock(UseOnContext context, BlockState to, boolean particles) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState from = level.getBlockState(pos);
        level.setBlockAndUpdate(pos, to);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of((Entity)context.getPlayer(), (BlockState)from));
        if (particles) {
            level.addDestroyBlockEffect(pos, from);
        }
        if (context.getPlayer() != null) {
            context.getPlayer().playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 0.8f, 2.0f);
            context.getPlayer().playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 0.4f, 0.8f);
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), LivingEntity.getSlotForHand(context.getHand()));
        }
        return InteractionResult.sidedSuccess((boolean)level.isClientSide);
    }

    private InteractionResult replaceBlockAbove(UseOnContext context, BlockState to, boolean particles) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().above();
        BlockState from = level.getBlockState(pos);
        level.setBlockAndUpdate(pos, to);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of((Entity)context.getPlayer(), (BlockState)from));
        if (particles) {
            level.addDestroyBlockEffect(pos, from);
        }
        if (context.getPlayer() != null) {
            context.getPlayer().playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 0.8f, 2.0f);
            context.getPlayer().playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 0.4f, 0.8f);
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), LivingEntity.getSlotForHand(context.getHand()));
        }
        return InteractionResult.sidedSuccess((boolean)level.isClientSide);
    }

    public InteractionResult useOn(UseOnContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.getBlock() == Blocks.DIRT) {
            if (context.getLevel().isClientSide) {
                EnchantedMistletoeItem.addGrowthParticles((LevelAccessor)context.getLevel(), context.getClickedPos(), 8);
            }
            if (context.getLevel().getBiome(context.getClickedPos()).is(Tags.Biomes.IS_MUSHROOM)) {
                return this.replaceBlock(context, Blocks.MYCELIUM.defaultBlockState(), false);
            }
            return this.replaceBlock(context, Blocks.GRASS_BLOCK.defaultBlockState(), false);
        }
        if (state.getBlock() == Blocks.NETHERRACK) {
            if (context.getLevel().isClientSide) {
                EnchantedMistletoeItem.addGrowthParticles((LevelAccessor)context.getLevel(), context.getClickedPos(), 15);
            }
            if (context.getLevel().getBiome(context.getClickedPos()).is(Biomes.CRIMSON_FOREST)) {
                return this.replaceBlock(context, Blocks.CRIMSON_NYLIUM.defaultBlockState(), false);
            }
            if (context.getLevel().getBiome(context.getClickedPos()).is(Biomes.WARPED_FOREST)) {
                return this.replaceBlock(context, Blocks.WARPED_NYLIUM.defaultBlockState(), false);
            }
            if (Math.random() < 0.5) {
                return this.replaceBlock(context, Blocks.CRIMSON_NYLIUM.defaultBlockState(), false);
            }
            return this.replaceBlock(context, Blocks.WARPED_NYLIUM.defaultBlockState(), false);
        }
        return super.useOn(context);
    }

    public static void addGrowthParticles(LevelAccessor pLevel, BlockPos pPos, int pData) {
        BlockState blockstate;
        if (pData == 0) {
            pData = 15;
        }
        if (!(blockstate = pLevel.getBlockState(pPos)).isAir()) {
            double d1;
            double d0 = 0.5;
            if (blockstate.is(Blocks.WATER)) {
                pData *= 3;
                d1 = 1.0;
                d0 = 1.0;
            } else if (blockstate.isSolidRender((BlockGetter)pLevel, pPos)) {
                pPos = pPos.above();
                pData *= 3;
                d0 = 1.0;
                d1 = 1.0;
            } else {
                d1 = blockstate.getShape((BlockGetter)pLevel, pPos).max(Direction.Axis.Y);
            }
            pLevel.addParticle((ParticleOptions)ParticleTypes.HAPPY_VILLAGER, (double)pPos.getX() + 0.5, (double)pPos.getY() + 0.5, (double)pPos.getZ() + 0.5, 0.0, 0.0, 0.0);
            RandomSource randomsource = pLevel.getRandom();
            for (int i = 0; i < pData; ++i) {
                double d8;
                double d7;
                double d2 = randomsource.nextGaussian() * 0.02;
                double d3 = randomsource.nextGaussian() * 0.02;
                double d4 = randomsource.nextGaussian() * 0.02;
                double d5 = 0.5 - d0;
                double d6 = (double)pPos.getX() + d5 + randomsource.nextDouble() * d0 * 2.0;
                if (pLevel.getBlockState(BlockPos.containing((double)d6, (double)(d7 = (double)pPos.getY() + randomsource.nextDouble() * d1), (double)(d8 = (double)pPos.getZ() + d5 + randomsource.nextDouble() * d0 * 2.0)).below()).isAir()) continue;
                pLevel.addParticle((ParticleOptions)ParticleTypes.HAPPY_VILLAGER, d6, d7, d8, d2, d3, d4);
            }
        }
    }
}

