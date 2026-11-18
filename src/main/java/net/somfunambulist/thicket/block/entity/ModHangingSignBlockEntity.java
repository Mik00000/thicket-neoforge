/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.SignBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.somfunambulist.thicket.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.somfunambulist.thicket.block.entity.ModBlockEntities;

public class ModHangingSignBlockEntity
extends SignBlockEntity {
    public ModHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType)ModBlockEntities.MOD_HANGING_SIGN.get(), blockPos, blockState);
    }

    public BlockEntityType<?> getType() {
        return (BlockEntityType)ModBlockEntities.MOD_HANGING_SIGN.get();
    }
}

