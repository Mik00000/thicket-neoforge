/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.item.Item
 */
package net.somfunambulist.thicket.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.somfunambulist.thicket.Thicket;

public class ModItemTags {
    public static final TagKey<Item> POCKET_KNIVES = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)Thicket.modPrefix("pocket_knives"));
    public static final TagKey<Item> HAZEL_LOGS = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)Thicket.modPrefix("hazel_logs"));
    public static final TagKey<Item> MYRRH_LOGS = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)Thicket.modPrefix("myrrh_logs"));
    public static final TagKey<Item> BOSWELLIA_LOGS = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)Thicket.modPrefix("boswellia_logs"));
    public static final TagKey<Item> SASSAFRAS_LOGS = TagKey.create((ResourceKey)Registries.ITEM, (ResourceLocation)Thicket.modPrefix("sassafras_logs"));
}

