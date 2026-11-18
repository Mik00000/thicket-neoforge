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

public class ModSignBlockEntity
extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super((BlockEntityType)ModBlockEntities.MOD_SIGN.get(), pPos, pBlockState);
    }

    public BlockEntityType<?> getType() {
        return (BlockEntityType)ModBlockEntities.MOD_SIGN.get();
    }
}

