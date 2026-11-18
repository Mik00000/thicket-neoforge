package net.somfunambulist.thicket.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;



public class HangingMistletoeBlock
extends HorizontalDirectionalBlock {
    private static final VoxelShape EAST_AABB = Block.box((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)16.0, (double)16.0);
    private static final VoxelShape WEST_AABB = Block.box((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    private static final VoxelShape SOUTH_AABB = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)1.0);
    private static final VoxelShape NORTH_AABB = Block.box((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0, (double)16.0);
    private static final VoxelShape HANGING_AABB = Block.box((double)4.0, (double)2.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);

    
    public static final MapCodec<HangingMistletoeBlock> CODEC = simpleCodec(HangingMistletoeBlock::new);

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    public HangingMistletoeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (!((Boolean)pState.getValue((Property)BlockStateProperties.HANGING)).booleanValue()) {
            return switch ((Direction)pState.getValue((Property)FACING)) {
                case Direction.NORTH -> NORTH_AABB;
                case Direction.SOUTH -> SOUTH_AABB;
                case Direction.EAST -> EAST_AABB;
                case Direction.WEST -> WEST_AABB;
                default -> NORTH_AABB;
            };
        }
        return HANGING_AABB;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(new Property[]{FACING, BlockStateProperties.HANGING});
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        if (direction.getOpposite() != Direction.UP) {
            if (direction.getAxis().isVertical()) {
                for (Direction d : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate = (BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)d)).setValue((Property)BlockStateProperties.HANGING, (Comparable)Boolean.valueOf(false));
                    if (!blockstate.canSurvive((LevelReader)pContext.getLevel(), pContext.getClickedPos())) continue;
                    return blockstate;
                }
            } else {
                BlockState blockstate = (BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)direction)).setValue((Property)BlockStateProperties.HANGING, (Comparable)Boolean.valueOf(false));
                if (blockstate.canSurvive((LevelReader)pContext.getLevel(), pContext.getClickedPos())) {
                    return blockstate;
                }
            }
        } else {
            return (BlockState)this.defaultBlockState().setValue((Property)BlockStateProperties.HANGING, (Comparable)Boolean.valueOf(true));
        }
        return null;
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        if (!((Boolean)pState.getValue((Property)BlockStateProperties.HANGING)).booleanValue()) {
            Direction direction = (Direction)pState.getValue((Property)FACING);
            BlockPos blockpos = pPos.relative(direction.getOpposite());
            BlockState blockstate = pLevel.getBlockState(blockpos);
            return blockstate.isFaceSturdy((BlockGetter)pLevel, blockpos, direction);
        }
        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        return blockstate.isFaceSturdy((BlockGetter)pLevel, blockpos, Direction.DOWN);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!((Boolean)pState.getValue((Property)BlockStateProperties.HANGING)).booleanValue()) {
            return ((Direction)pState.getValue((Property)FACING)).getOpposite() == pFacing && !pState.canSurvive((LevelReader)pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
        return !pState.canSurvive((LevelReader)pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }
}

