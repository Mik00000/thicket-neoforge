/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.block.custom.ModFlammableRotatedPillarBlock;

public class HazelLogBlock
extends ModFlammableRotatedPillarBlock {
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        pState = ((Block)ModBlocks.FIREMILK_MUSHROOM.get()).defaultBlockState();
        if (pRandom.nextInt(18) == 0) {
            int i = 3;
            int j = 4;
            for (BlockPos blockpos : BlockPos.betweenClosed((BlockPos)pPos.offset(-4, -3, -4), (BlockPos)pPos.offset(4, 1, 4))) {
                if (!pLevel.getBlockState(blockpos).is((Block)ModBlocks.FIREMILK_MUSHROOM.get()) || --i > 0) continue;
                return;
            }
            BlockPos blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
            for (int k = 0; k < 4; ++k) {
                if (pLevel.isEmptyBlock(blockpos1) && pState.canSurvive((LevelReader)pLevel, blockpos1)) {
                    pPos = blockpos1;
                }
                blockpos1 = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
            }
            if (pLevel.isEmptyBlock(blockpos1) && pState.canSurvive((LevelReader)pLevel, blockpos1)) {
                pLevel.setBlock(blockpos1, pState, 2);
            }
        }
    }

    public HazelLogBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }
}

