package net.somfunambulist.thicket.painting;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.bus.api.IEventBus;

public class ModPaintings {
    public static final ResourceKey<PaintingVariant> RITUAL = ResourceKey.create(Registries.PAINTING_VARIANT, ResourceLocation.fromNamespaceAndPath("thicket", "ritual"));

    public static void register(IEventBus eventBus) {
    }
}
