package net.somfunambulist.thicket.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.entity.custom.MistletoeArrow;
import net.somfunambulist.thicket.entity.custom.ModBoatEntity;
import net.somfunambulist.thicket.entity.custom.ModChestBoatEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, "thicket");
    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> MOD_BOAT = ENTITY_TYPES.register("boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT = ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_chest_boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<MistletoeArrow>> MISTLETOE_ARROW = ENTITY_TYPES.register("mistletoe_arrow", () -> EntityType.Builder.<MistletoeArrow>of(MistletoeArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).build("mistletoe_arrow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
