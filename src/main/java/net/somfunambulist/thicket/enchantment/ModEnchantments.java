package net.somfunambulist.thicket.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> OCCULT = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath("thicket", "occult"));

    public static void register(IEventBus eventBus) {
    }
}
