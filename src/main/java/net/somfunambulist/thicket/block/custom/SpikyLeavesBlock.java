/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.npc.Villager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.somfunambulist.thicket.block.custom.ModLeavesBlock;

public class SpikyLeavesBlock
extends ModLeavesBlock {
    private static final VoxelShape AABB = SpikyLeavesBlock.box((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)15.0, (double)15.0);

    public SpikyLeavesBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        SpikyLeavesBlock.entityInside(1.2f, entity, level);
    }

    @OnlyIn(value=Dist.CLIENT)
    public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
        return 0.2f;
    }

    public static void entityInside(float damage, Entity entity, Level level) {
        Player player;
        if (!level.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ()) && (entity instanceof Player && !(player = (Player)entity).isCrouching() || entity instanceof Villager)) {
            double d0 = Math.abs(entity.getX() - entity.xOld);
            double d1 = Math.abs(entity.getZ() - entity.zOld);
            if (d0 >= 0.003 || d1 >= 0.003) {
                entity.hurt(entity.damageSources().cactus(), damage);
            }
        }
    }
}

