/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BrushableBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.Nullable
 */
package net.somfunambulist.thicket.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.somfunambulist.thicket.block.entity.ModSusBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ModSusBlock
extends BrushableBlock {
    public ModSusBlock(Block baseBlock, SoundEvent brushingSound, SoundEvent brushingCompleteSound, BlockBehaviour.Properties settings) { super(baseBlock, brushingSound, brushingCompleteSound, settings); }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModSusBlockEntity(pos, state);
    }
}

