/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.block.custom.ModLeavesBlock;
import net.somfunambulist.thicket.tags.ModBlockTags;

public class MistletoeLeavesBlock
extends ModLeavesBlock {
    public MistletoeLeavesBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)DISTANCE, (Comparable)Integer.valueOf(7))).setValue((Property)PERSISTENT, (Comparable)Boolean.valueOf(false))).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (this.decaying(pState)) {
            MistletoeLeavesBlock.dropResources((BlockState)pState, (Level)pLevel, (BlockPos)pPos);
            pLevel.removeBlock(pPos, false);
        }
        if (!pLevel.isAreaLoaded(pPos, 3)) {
            return;
        }
        if (pRandom.nextInt(500) == 0) {
            BlockState blockstate = this.defaultBlockState();
            for (int i = 0; i < 4; ++i) {
                int j = 24;
                for (BlockPos blockpos0 : BlockPos.betweenClosed((BlockPos)pPos.offset(-4, -4, -4), (BlockPos)pPos.offset(4, 4, 4))) {
                    if (!pLevel.getBlockState(blockpos0).is(ModBlockTags.MISTLETOE_BLOCK) || --j > 0) continue;
                    return;
                }
                BlockPos blockpos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
                if (!pLevel.getBlockState(blockpos).is(BlockTags.LEAVES) || pLevel.getBlockState(blockpos).is(ModBlockTags.MISTLETOE_BLOCK)) continue;
                BlockState bstate = pLevel.getBlockState(blockpos);
                if (pRandom.nextInt(3) == 0) {
                    blockstate = ((MistletoeLeavesBlock)((Object)ModBlocks.BLOOMING_MISTLETOE_LEAVES.get())).defaultBlockState();
                    pLevel.setBlockAndUpdate(blockpos, (BlockState)((BlockState)((BlockState)blockstate.setValue((Property)PERSISTENT, (Comparable)((Boolean)bstate.getValue((Property)PERSISTENT)))).setValue((Property)WATERLOGGED, (Comparable)((Boolean)bstate.getValue((Property)WATERLOGGED)))).setValue((Property)DISTANCE, (Comparable)((Integer)bstate.getValue((Property)DISTANCE))));
                    continue;
                }
                blockstate = ((MistletoeLeavesBlock)((Object)ModBlocks.MISTLETOE_LEAVES.get())).defaultBlockState();
                pLevel.setBlockAndUpdate(blockpos, (BlockState)((BlockState)((BlockState)blockstate.setValue((Property)PERSISTENT, (Comparable)((Boolean)bstate.getValue((Property)PERSISTENT)))).setValue((Property)WATERLOGGED, (Comparable)((Boolean)bstate.getValue((Property)WATERLOGGED)))).setValue((Property)DISTANCE, (Comparable)((Integer)bstate.getValue((Property)DISTANCE))));
            }
        }
    }
}

