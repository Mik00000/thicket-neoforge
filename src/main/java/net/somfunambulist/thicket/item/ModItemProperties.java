package net.somfunambulist.thicket.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.somfunambulist.thicket.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.GOLD_SICKLE.get(), ResourceLocation.fromNamespaceAndPath("thicket", "phase"), (pStack, pLevel, pEntity, pSeed) -> pLevel == null ? 0.0f : (float)pLevel.getMoonPhase() / 8.0f);
        ModItemProperties.makeBow(ModItems.CRUXWOOD_BOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0f;
            }
            return p_174637_.getUseItem() != p_174635_ ? 0.0f : (float)(p_174635_.getUseDuration(p_174637_) - p_174637_.getUseItemRemainingTicks()) / 20.0f;
        });
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0f : 0.0f);
    }
}
