package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SpikySaplingBlock extends SaplingBlock {
    public SpikySaplingBlock(TreeGrower pTreeGrower, BlockBehaviour.Properties pProperties) {
        super(pTreeGrower, pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity) {
            pEntity.makeStuckInBlock(pState, new Vec3(0.8, 0.75, 0.8));
            if (!(pLevel.isClientSide || (pEntity.xOld == pEntity.getX() && pEntity.zOld == pEntity.getZ()))) {
                double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
                double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
                if (d0 >= 0.003 || d1 >= 0.003) {
                    pEntity.hurt(pLevel.damageSources().cactus(), 1.0f);
                }
            }
        }
    }
}
