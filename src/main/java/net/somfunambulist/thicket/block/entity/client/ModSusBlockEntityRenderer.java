/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockAndTintGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.somfunambulist.thicket.block.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.somfunambulist.thicket.block.entity.ModSusBlockEntity;

public class ModSusBlockEntityRenderer
implements BlockEntityRenderer<ModSusBlockEntity> {
    private final ItemRenderer itemRenderer;

    public ModSusBlockEntityRenderer(BlockEntityRendererProvider.Context p_277899_) {
        this.itemRenderer = p_277899_.getItemRenderer();
    }

    public void render(ModSusBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemStack itemstack;
        Direction direction;
        int i;
        if (pBlockEntity.getLevel() != null && (i = ((Integer)pBlockEntity.getBlockState().getValue((Property)BlockStateProperties.DUSTED)).intValue()) > 0 && (direction = pBlockEntity.getHitDirection()) != null && !(itemstack = pBlockEntity.getItem()).isEmpty()) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.0f, 0.5f, 0.0f);
            float[] afloat = this.translations(direction, i);
            pPoseStack.translate(afloat[0], afloat[1], afloat[2]);
            pPoseStack.mulPose(Axis.YP.rotationDegrees(75.0f));
            boolean flag = direction == Direction.EAST || direction == Direction.WEST;
            pPoseStack.mulPose(Axis.YP.rotationDegrees((float)((flag ? 90 : 0) + 11)));
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
            int j = LevelRenderer.getLightColor((BlockAndTintGetter)pBlockEntity.getLevel(), (BlockState)pBlockEntity.getBlockState(), (BlockPos)pBlockEntity.getBlockPos().relative(direction));
            this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, j, OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 0);
            pPoseStack.popPose();
        }
    }

    private float[] translations(Direction p_278030_, int p_277997_) {
        float[] afloat = new float[]{0.5f, 0.0f, 0.5f};
        float f = (float)p_277997_ / 10.0f * 0.75f;
        switch (p_278030_) {
            case EAST: {
                afloat[0] = 0.73f + f;
                break;
            }
            case WEST: {
                afloat[0] = 0.25f - f;
                break;
            }
            case UP: {
                afloat[1] = 0.25f + f;
                break;
            }
            case DOWN: {
                afloat[1] = -0.23f - f;
                break;
            }
            case NORTH: {
                afloat[2] = 0.25f - f;
                break;
            }
            case SOUTH: {
                afloat[2] = 0.73f + f;
            }
        }
        return afloat;
    }
}

