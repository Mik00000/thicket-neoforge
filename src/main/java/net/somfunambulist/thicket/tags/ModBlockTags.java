/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 */
package net.somfunambulist.thicket.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.somfunambulist.thicket.Thicket;

public class ModBlockTags {
    public static final TagKey<Block> CARVING_BLOCKS = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("carving_blocks"));
    public static final TagKey<Block> CARVEABLE = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("carveable"));
    public static final TagKey<Block> HAZEL_LOGS = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("hazel_logs"));
    public static final TagKey<Block> MYRRH_LOGS = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("myrrh_logs"));
    public static final TagKey<Block> BOSWELLIA_LOGS = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("boswellia_logs"));
    public static final TagKey<Block> SASSAFRAS_LOGS = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("sassafras_logs"));
    public static final TagKey<Block> FIREMILK_GROW_BLOCK = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("firemilk_grow_block"));
    public static final TagKey<Block> MISTLETOE_BLOCK = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("mistletoe_block"));
    public static final TagKey<Block> NEEDS_CRUXWOOD_TOOL = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)Thicket.modPrefix("needs_cruxwood_tool"));
}

