package net.somfunambulist.thicket.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, "thicket");
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITIES.register("mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.HAZEL_SIGN.get(), ModBlocks.HAZEL_WALL_SIGN.get(), ModBlocks.MYRRH_SIGN.get(), ModBlocks.MYRRH_WALL_SIGN.get(), ModBlocks.BOSWELLIA_SIGN.get(), ModBlocks.BOSWELLIA_WALL_SIGN.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITIES.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.HAZEL_HANGING_SIGN.get(), ModBlocks.HAZEL_WALL_HANGING_SIGN.get(), ModBlocks.MYRRH_HANGING_SIGN.get(), ModBlocks.MYRRH_WALL_HANGING_SIGN.get(), ModBlocks.BOSWELLIA_HANGING_SIGN.get(), ModBlocks.BOSWELLIA_WALL_HANGING_SIGN.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSusBlockEntity>> MOD_SUS_BLOCK = BLOCK_ENTITIES.register("mod_sus_block", () -> BlockEntityType.Builder.of(ModSusBlockEntity::new, ModBlocks.SUSPICIOUS_ROOTS.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
