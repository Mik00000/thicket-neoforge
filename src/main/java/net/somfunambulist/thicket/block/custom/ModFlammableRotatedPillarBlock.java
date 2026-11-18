/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraftforge.common.ToolAction
 *  org.jetbrains.annotations.Nullable
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.common.ItemAbility;
import net.somfunambulist.thicket.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock
extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is((Block)ModBlocks.HAZEL_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_HAZEL_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.HAZEL_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_HAZEL_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.MYRRH_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_MYRRH_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.GREEN_MYRRH_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_GREEN_MYRRH_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.MYRRH_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_MYRRH_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.GREEN_MYRRH_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_GREEN_MYRRH_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.BOSWELLIA_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_BOSWELLIA_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.RED_BOSWELLIA_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_RED_BOSWELLIA_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.BOSWELLIA_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_BOSWELLIA_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.RED_BOSWELLIA_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_RED_BOSWELLIA_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.SASSAFRAS_LOG.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_SASSAFRAS_LOG.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
            if (state.is((Block)ModBlocks.SASSAFRAS_WOOD.get())) {
                return (BlockState)((Block)ModBlocks.STRIPPED_SASSAFRAS_WOOD.get()).defaultBlockState().setValue((Property)AXIS, (Comparable)((Direction.Axis)state.getValue((Property)AXIS)));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}

