package net.somfunambulist.thicket.effect;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, "thicket");
    public static final DeferredHolder<MobEffect, MobEffect> ANOINTED_EFFECT = MOB_EFFECTS.register("anointed", () -> new AnointedEffect(MobEffectCategory.BENEFICIAL, 16370287));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
