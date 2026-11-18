/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelWriter
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.HugeMushroomBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 */
package net.somfunambulist.thicket.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.somfunambulist.thicket.worldgen.feature.HugeFiremilkConfiguration;

public class HugeFiremilkFeature
extends Feature<HugeFiremilkConfiguration> {
    public HugeFiremilkFeature(Codec<HugeFiremilkConfiguration> configurationCodec) {
        super(configurationCodec);
    }

    public boolean place(FeaturePlaceContext<HugeFiremilkConfiguration> context) {
        BlockPos.MutableBlockPos mutablePos;
        WorldGenLevel worldGenLevel = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        HugeFiremilkConfiguration config = (HugeFiremilkConfiguration)context.config();
        int height = this.getHeight(random);
        if (!this.isValidPosition((LevelAccessor)worldGenLevel, pos, height, mutablePos = new BlockPos.MutableBlockPos(), config)) {
            return false;
        }
        this.placeCapAndGills((LevelAccessor)worldGenLevel, random, pos, height, mutablePos, config);
        this.placeTrunk((LevelAccessor)worldGenLevel, random, pos, config, height, mutablePos);
        return true;
    }

    protected boolean isValidPosition(LevelAccessor level, BlockPos pos, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeFiremilkConfiguration config) {
        int i = pos.getY();
        if (i >= level.getMinBuildHeight() + 1 && i + height + 1 < level.getMaxBuildHeight()) {
            BlockState blockstate = level.getBlockState(pos.below());
            if (!HugeFiremilkFeature.isDirt((BlockState)blockstate) && !blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
                return false;
            }
            for (int j = 0; j <= height; ++j) {
                int k = this.getRadiusForHeight(config.foliageRadius, j);
                for (int l = -k; l <= k; ++l) {
                    for (int i1 = -k; i1 <= k; ++i1) {
                        BlockState state = level.getBlockState((BlockPos)mutableBlockPos.setWithOffset((Vec3i)pos, l, j, i1));
                        if (state.isAir() || state.is(BlockTags.LEAVES)) continue;
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    protected void placeTrunk(LevelAccessor level, RandomSource random, BlockPos pos, HugeFiremilkConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutablePos) {
        for (int y = 0; y < maxHeight; ++y) {
            mutablePos.set((Vec3i)pos).move(Direction.UP, y);
            if (level.getBlockState((BlockPos)mutablePos).isSolidRender((BlockGetter)level, (BlockPos)mutablePos)) continue;
            this.setBlock((LevelWriter)level, (BlockPos)mutablePos, config.stemProvider.getState(random, pos));
        }
    }

    protected void placeCapAndGills(LevelAccessor level, RandomSource random, BlockPos pos, int height, BlockPos.MutableBlockPos mutablePos, HugeFiremilkConfiguration config) {
        int folRad = config.foliageRadius;
        int gillRadius = folRad / 2;
        for (int x = -folRad; x <= folRad; ++x) {
            for (int z = -folRad; z <= folRad; ++z) {
                boolean isZAtStartOrEnd;
                if (x >= -gillRadius && x <= gillRadius && z >= -gillRadius && z <= gillRadius) {
                    BlockState state = config.gillProvider.getState(random, pos);
                    if (state.hasProperty((Property)HugeMushroomBlock.UP)) {
                        state = (BlockState)state.setValue((Property)HugeMushroomBlock.UP, (Comparable)Boolean.valueOf(true));
                    }
                    mutablePos.setWithOffset((Vec3i)pos, x, height, z);
                    mutablePos.move(Direction.DOWN);
                    this.setBlock((LevelWriter)level, (BlockPos)mutablePos, state);
                    mutablePos.move(Direction.UP);
                    continue;
                }
                boolean isXAtStart = x == -folRad;
                boolean isXAtEnd = x == folRad;
                boolean isZAtStart = z == -folRad;
                boolean isZAtEnd = z == folRad;
                boolean isXAtStartOrEnd = isXAtStart || isXAtEnd;
                boolean bl = isZAtStartOrEnd = isZAtStart || isZAtEnd;
                if (isXAtStartOrEnd && isZAtStartOrEnd) continue;
                mutablePos.setWithOffset((Vec3i)pos, x, height, z);
                if (level.getBlockState((BlockPos)mutablePos).isSolidRender((BlockGetter)level, (BlockPos)mutablePos)) continue;
                BlockState state = config.capProvider.getState(random, pos);
                this.setBlock((LevelWriter)level, (BlockPos)mutablePos, state);
            }
        }
    }

    private int getHeight(RandomSource rand) {
        int i = rand.nextInt(3) + 4;
        if (rand.nextInt(12) == 0) {
            i *= 2;
        }
        return i;
    }

    private int getRadiusForHeight(int fallbackRadius, int height) {
        return height <= 3 ? 0 : fallbackRadius;
    }
}

