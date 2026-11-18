package net.somfunambulist.thicket.event;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.somfunambulist.thicket.entity.custom.ModBoatEntity;

@EventBusSubscriber(modid = "thicket", bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (ModBoatEntity.Type type : ModBoatEntity.Type.values()) {
            event.registerLayerDefinition(new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("thicket", type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("thicket", type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
        }
    }
}
