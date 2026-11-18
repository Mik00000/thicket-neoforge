/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.BrushableBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.somfunambulist.thicket.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.somfunambulist.thicket.block.entity.ModBlockEntities;

public class ModSusBlockEntity
extends BrushableBlockEntity {
    public ModSusBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public BlockEntityType<?> getType() {
        return (BlockEntityType)ModBlockEntities.MOD_SUS_BLOCK.get();
    }
}

