/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.datafixers.util.Pair
 *  com.mojang.math.Axis
 *  net.minecraft.client.model.BoatModel
 *  net.minecraft.client.model.ChestBoatModel
 *  net.minecraft.client.model.ListModel
 *  net.minecraft.client.model.WaterPatchModel
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.vehicle.Boat
 *  org.joml.Quaternionf
 */
package net.somfunambulist.thicket.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.WaterPatchModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import net.somfunambulist.thicket.entity.custom.ModBoatEntity;
import org.joml.Quaternionf;

public class ModBoatRenderer<T extends ModBoatEntity>
extends EntityRenderer<T> {
    private final Map<ModBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context);
        this.shadowRadius = 0.8f;
        this.boatResources = (Map)Stream.of(ModBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type, type -> Pair.of(type.getTexture(hasChest), this.createBoatModel(context, type, hasChest))));
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, ModBoatEntity.Type type, boolean hasChest) {
        ModelLayerLocation modelLayerLocation = hasChest ? new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("thicket", type.getChestModelLocation()), "main") : new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("thicket", type.getModelLocation()), "main");
        ModelPart modelPart = context.bakeLayer(modelLayerLocation);
        return hasChest ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
    }

    public void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        float h;
        matrixStack.pushPose();
        matrixStack.translate(0.0f, 0.375f, 0.0f);
        matrixStack.mulPose(Axis.YP.rotationDegrees(180.0f - entityYaw));
        float f = (float)entity.getHurtTime() - partialTicks;
        float g = entity.getDamage() - partialTicks;
        if (g < 0.0f) {
            g = 0.0f;
        }
        if (f > 0.0f) {
            matrixStack.mulPose(Axis.XP.rotationDegrees(Mth.sin((float)f) * f * g / 10.0f * (float)entity.getHurtDir()));
        }
        if (!Mth.equal((float)(h = entity.getBubbleAngle(partialTicks)), (float)0.0f)) {
            matrixStack.mulPose(new Quaternionf().setAngleAxis(entity.getBubbleAngle(partialTicks) * ((float)Math.PI / 180), 1.0f, 0.0f, 1.0f));
        }
        Pair<ResourceLocation, ListModel<Boat>> pair = this.boatResources.get(entity.getWoodType());
        ResourceLocation resourceLocation = (ResourceLocation)pair.getFirst();
        ListModel listModel = (ListModel)pair.getSecond();
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        matrixStack.mulPose(Axis.YP.rotationDegrees(90.0f));
        listModel.setupAnim(entity, partialTicks, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = buffer.getBuffer(listModel.renderType(resourceLocation));
        listModel.renderToBuffer(matrixStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        if (!entity.isUnderWater()) {
            VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.waterMask());
            if (listModel instanceof WaterPatchModel) {
                WaterPatchModel waterPatchModel = (WaterPatchModel)listModel;
                waterPatchModel.waterPatch().render(matrixStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }
        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    public ResourceLocation getTextureLocation(ModBoatEntity boat) {
        return (ResourceLocation)this.boatResources.get(boat.getWoodType()).getFirst();
    }
}

