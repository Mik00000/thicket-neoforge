package net.somfunambulist.thicket.event;

import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.somfunambulist.thicket.block.entity.ModBlockEntities;
import net.somfunambulist.thicket.block.entity.client.ModSusBlockEntityRenderer;

@EventBusSubscriber(modid = "thicket", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SUS_BLOCK.get(), ModSusBlockEntityRenderer::new);
    }
}
