/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.EntityType
 */
package net.somfunambulist.thicket.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.somfunambulist.thicket.Thicket;

public class ModEntityTags {
    public static final TagKey<EntityType<?>> OCCULT_TARGET = TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (ResourceLocation)Thicket.modPrefix("occult_target"));
}

