/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.ArrowRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 */
package net.somfunambulist.thicket.entity.client;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.somfunambulist.thicket.entity.custom.MistletoeArrow;

public class MistletoeArrowRenderer
extends ArrowRenderer<MistletoeArrow> {
    private static final ResourceLocation MISTLETOE_ARROW = ResourceLocation.fromNamespaceAndPath("thicket", "textures/entity/projectiles/mistletoe_arrow.png");

    public MistletoeArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(MistletoeArrow entity) {
        return MISTLETOE_ARROW;
    }
}

