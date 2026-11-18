/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.AmethystClusterBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.block.custom.ModFlammableRotatedPillarBlock;

public class ResinousBlock
extends ModFlammableRotatedPillarBlock {
    public static final int GROWTH_CHANCE = 5;
    public static final Direction[] DIRECTIONS = Direction.values();

    public ResinousBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = (Block)ModBlocks.MYRRH_RESIN.get();
            if (pState.is((Block)ModBlocks.STRIPPED_GREEN_MYRRH_LOG.get()) || pState.is((Block)ModBlocks.STRIPPED_GREEN_MYRRH_WOOD.get()) || pState.is((Block)ModBlocks.GREEN_MYRRH_CARVING.get())) {
                block = (Block)ModBlocks.MYRRH_RESIN.get();
            }
            if (pState.is((Block)ModBlocks.STRIPPED_RED_BOSWELLIA_LOG.get()) || pState.is((Block)ModBlocks.STRIPPED_RED_BOSWELLIA_WOOD.get()) || pState.is((Block)ModBlocks.RED_BOSWELLIA_CARVING.get())) {
                block = (Block)ModBlocks.FRANKINCENSE_RESIN.get();
            }
            if (blockstate.isAir()) {
                BlockState blockstate1 = (BlockState)block.defaultBlockState().setValue((Property)AmethystClusterBlock.FACING, (Comparable)direction);
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }
}

