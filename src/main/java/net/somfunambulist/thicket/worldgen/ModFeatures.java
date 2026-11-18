package net.somfunambulist.thicket.worldgen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.worldgen.feature.HugeFiremilkConfiguration;
import net.somfunambulist.thicket.worldgen.feature.HugeFiremilkFeature;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FeatureRegistry = DeferredRegister.create(BuiltInRegistries.FEATURE, "thicket");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZEL_KEY = ModFeatures.registerKey("hazel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYRRH_KEY = ModFeatures.registerKey("myrrh");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOSWELLIA_KEY = ModFeatures.registerKey("boswellia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SASSAFRAS_KEY = ModFeatures.registerKey("sassafras");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_FIREMILK_KEY = ModFeatures.registerKey("huge_firemilk_mushroom");
    public static final DeferredHolder<Feature<?>, Feature<HugeFiremilkConfiguration>> HUGE_FIREMILK_PLACED = FeatureRegistry.register("huge_firemilk_mushroom", () -> new HugeFiremilkFeature(HugeFiremilkConfiguration.CODEC));

    public static void register(IEventBus modEventBus) {
        FeatureRegistry.register(modEventBus);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath("thicket", name));
    }
}
