/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.AmethystClusterBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.BrushableBlock
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.FenceGateBlock
 *  net.minecraft.world.level.block.FlowerBlock
 *  net.minecraft.world.level.block.FlowerPotBlock
 *  net.minecraft.world.level.block.GlowLichenBlock
 *  net.minecraft.world.level.block.HugeMushroomBlock
 *  net.minecraft.world.level.block.PressurePlateBlock
 *  net.minecraft.world.level.block.PressurePlateBlock$Sensitivity
 *  net.minecraft.world.level.block.SaplingBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.grower.AbstractTreeGrower
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.somfunambulist.thicket.block;

import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import java.util.Optional;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.block.custom.FiremilkMushroomBlock;
import net.somfunambulist.thicket.block.custom.HangingMistletoeBlock;
import net.somfunambulist.thicket.block.custom.HazelLogBlock;
import net.somfunambulist.thicket.block.custom.MistletoeLeavesBlock;
import net.somfunambulist.thicket.block.custom.ModFlammableRotatedPillarBlock;
import net.somfunambulist.thicket.block.custom.ModHangingSignBlock;
import net.somfunambulist.thicket.block.custom.ModLeavesBlock;
import net.somfunambulist.thicket.block.custom.ModPlanksBlock;
import net.somfunambulist.thicket.block.custom.ModRotatedPillarBlock;
import net.somfunambulist.thicket.block.custom.ModStandingSignBlock;
import net.somfunambulist.thicket.block.custom.ModSusBlock;
import net.somfunambulist.thicket.block.custom.ModWallHangingSignBlock;
import net.somfunambulist.thicket.block.custom.ModWallSignBlock;
import net.somfunambulist.thicket.block.custom.ResinousBlock;
import net.somfunambulist.thicket.block.custom.SpikyLeavesBlock;
import net.somfunambulist.thicket.block.custom.SpikySaplingBlock;
import net.somfunambulist.thicket.item.ModItems;
import net.somfunambulist.thicket.util.ModWoodTypes;
import net.somfunambulist.thicket.worldgen.ModFeatures;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("thicket");
    public static final DeferredBlock<Block> OAK_CARVING = ModBlocks.registerBlock("oak_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BIRCH_CARVING = ModBlocks.registerBlock("birch_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> SPRUCE_CARVING = ModBlocks.registerBlock("spruce_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final DeferredBlock<Block> JUNGLE_CARVING = ModBlocks.registerBlock("jungle_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final DeferredBlock<Block> ACACIA_CARVING = ModBlocks.registerBlock("acacia_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> DARK_OAK_CARVING = ModBlocks.registerBlock("dark_oak_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final DeferredBlock<Block> MANGROVE_CARVING = ModBlocks.registerBlock("mangrove_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_WOOD)));
    public static final DeferredBlock<Block> CHERRY_CARVING = ModBlocks.registerBlock("cherry_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final DeferredBlock<Block> CRIMSON_CARVING = ModBlocks.registerBlock("crimson_carving", () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE)));
    public static final DeferredBlock<Block> WARPED_CARVING = ModBlocks.registerBlock("warped_carving", () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));
    public static final DeferredBlock<Block> HAZEL_SAPLING = ModBlocks.registerBlock("hazel_sapling", () -> new SaplingBlock(new TreeGrower("hazel", Optional.empty(), Optional.of(ModFeatures.HAZEL_KEY), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_HAZEL_SAPLING = BLOCKS.register("potted_hazel_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, HAZEL_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING)));
    public static final DeferredBlock<ModLeavesBlock> HAZEL_LEAVES = ModBlocks.registerBlock("hazel_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> HAZEL_LOG = ModBlocks.registerBlock("hazel_log", () -> new HazelLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> HAZEL_WOOD = ModBlocks.registerBlock("hazel_wood", () -> new HazelLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_HAZEL_LOG = ModBlocks.registerBlock("stripped_hazel_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_HAZEL_WOOD = ModBlocks.registerBlock("stripped_hazel_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<ModPlanksBlock> HAZEL_PLANKS = ModBlocks.registerBlock("hazel_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> HAZEL_CARVING = ModBlocks.registerBlock("hazel_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> HAZEL_STAIRS = ModBlocks.registerBlock("hazel_stairs", () -> new StairBlock(HAZEL_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> HAZEL_SLAB = ModBlocks.registerBlock("hazel_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> HAZEL_PRESSURE_PLATE = ModBlocks.registerBlock("hazel_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> HAZEL_BUTTON = ModBlocks.registerBlock("hazel_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<Block> HAZEL_FENCE = ModBlocks.registerBlock("hazel_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> HAZEL_FENCE_GATE = ModBlocks.registerBlock("hazel_fence_gate", () -> new FenceGateBlock(ModWoodTypes.HAZEL, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> HAZEL_DOOR = ModBlocks.registerBlock("hazel_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<Block> HAZEL_TRAPDOOR = ModBlocks.registerBlock("hazel_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<Block> HAZEL_SIGN = BLOCKS.register("hazel_sign", () -> new ModStandingSignBlock(ModWoodTypes.HAZEL, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<Block> HAZEL_WALL_SIGN = BLOCKS.register("hazel_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.HAZEL, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<Block> HAZEL_HANGING_SIGN = BLOCKS.register("hazel_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.HAZEL, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<Block> HAZEL_WALL_HANGING_SIGN = BLOCKS.register("hazel_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.HAZEL, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<Block> HAZELNUT_BUNDLE = ModBlocks.registerBlock("hazelnut_bundle", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> MYRRH_SAPLING = ModBlocks.registerBlock("myrrh_sapling", () -> new SpikySaplingBlock(new TreeGrower("myrrh", Optional.empty(), Optional.of(ModFeatures.MYRRH_KEY), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_MYRRH_SAPLING = BLOCKS.register("potted_myrrh_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, MYRRH_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING)));
    public static final DeferredBlock<ModLeavesBlock> MYRRH_LEAVES = ModBlocks.registerBlock("myrrh_leaves", () -> new SpikyLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MYRRH_LOG = ModBlocks.registerBlock("myrrh_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> GREEN_MYRRH_LOG = ModBlocks.registerBlock("green_myrrh_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> MYRRH_WOOD = ModBlocks.registerBlock("myrrh_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> GREEN_MYRRH_WOOD = ModBlocks.registerBlock("green_myrrh_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MYRRH_LOG = ModBlocks.registerBlock("stripped_myrrh_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_MYRRH_LOG = ModBlocks.registerBlock("stripped_green_myrrh_log", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_MYRRH_WOOD = ModBlocks.registerBlock("stripped_myrrh_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_GREEN_MYRRH_WOOD = ModBlocks.registerBlock("stripped_green_myrrh_wood", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<ModPlanksBlock> MYRRH_PLANKS = ModBlocks.registerBlock("myrrh_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> MYRRH_CARVING = ModBlocks.registerBlock("myrrh_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> GREEN_MYRRH_CARVING = ModBlocks.registerBlock("green_myrrh_carving", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MYRRH_STAIRS = ModBlocks.registerBlock("myrrh_stairs", () -> new StairBlock(MYRRH_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> MYRRH_SLAB = ModBlocks.registerBlock("myrrh_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> MYRRH_PRESSURE_PLATE = ModBlocks.registerBlock("myrrh_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> MYRRH_BUTTON = ModBlocks.registerBlock("myrrh_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<Block> MYRRH_FENCE = ModBlocks.registerBlock("myrrh_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> MYRRH_FENCE_GATE = ModBlocks.registerBlock("myrrh_fence_gate", () -> new FenceGateBlock(ModWoodTypes.MYRRH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> MYRRH_DOOR = ModBlocks.registerBlock("myrrh_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<Block> MYRRH_TRAPDOOR = ModBlocks.registerBlock("myrrh_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<Block> MYRRH_SIGN = BLOCKS.register("myrrh_sign", () -> new ModStandingSignBlock(ModWoodTypes.MYRRH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<Block> MYRRH_WALL_SIGN = BLOCKS.register("myrrh_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.MYRRH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<Block> MYRRH_HANGING_SIGN = BLOCKS.register("myrrh_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.MYRRH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<Block> MYRRH_WALL_HANGING_SIGN = BLOCKS.register("myrrh_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.MYRRH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<Block> MYRRH_RESIN = BLOCKS.register("myrrh_resin", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.2f).sound(SoundType.WOOD).lightLevel(GlowLichenBlock.emission((int)0))));
    public static final DeferredBlock<Block> MYRRH_BUNDLE = ModBlocks.registerBlock("myrrh_bundle", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> BOSWELLIA_SAPLING = ModBlocks.registerBlock("boswellia_sapling", () -> new SaplingBlock(new TreeGrower("boswellia", Optional.empty(), Optional.of(ModFeatures.BOSWELLIA_KEY), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_BOSWELLIA_SAPLING = BLOCKS.register("potted_boswellia_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, BOSWELLIA_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING)));
    public static final DeferredBlock<ModLeavesBlock> BOSWELLIA_LEAVES = ModBlocks.registerBlock("boswellia_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> BOSWELLIA_LOG = ModBlocks.registerBlock("boswellia_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> RED_BOSWELLIA_LOG = ModBlocks.registerBlock("red_boswellia_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> BOSWELLIA_WOOD = ModBlocks.registerBlock("boswellia_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> RED_BOSWELLIA_WOOD = ModBlocks.registerBlock("red_boswellia_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_BOSWELLIA_LOG = ModBlocks.registerBlock("stripped_boswellia_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_RED_BOSWELLIA_LOG = ModBlocks.registerBlock("stripped_red_boswellia_log", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_BOSWELLIA_WOOD = ModBlocks.registerBlock("stripped_boswellia_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RED_BOSWELLIA_WOOD = ModBlocks.registerBlock("stripped_red_boswellia_wood", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<ModPlanksBlock> BOSWELLIA_PLANKS = ModBlocks.registerBlock("boswellia_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> BOSWELLIA_CARVING = ModBlocks.registerBlock("boswellia_carving", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RED_BOSWELLIA_CARVING = ModBlocks.registerBlock("red_boswellia_carving", () -> new ResinousBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> BOSWELLIA_STAIRS = ModBlocks.registerBlock("boswellia_stairs", () -> new StairBlock(BOSWELLIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> BOSWELLIA_SLAB = ModBlocks.registerBlock("boswellia_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> BOSWELLIA_PRESSURE_PLATE = ModBlocks.registerBlock("boswellia_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> BOSWELLIA_BUTTON = ModBlocks.registerBlock("boswellia_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final DeferredBlock<Block> BOSWELLIA_FENCE = ModBlocks.registerBlock("boswellia_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block> BOSWELLIA_FENCE_GATE = ModBlocks.registerBlock("boswellia_fence_gate", () -> new FenceGateBlock(ModWoodTypes.BOSWELLIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final DeferredBlock<Block> BOSWELLIA_DOOR = ModBlocks.registerBlock("boswellia_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<Block> BOSWELLIA_TRAPDOOR = ModBlocks.registerBlock("boswellia_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<Block> BOSWELLIA_SIGN = BLOCKS.register("boswellia_sign", () -> new ModStandingSignBlock(ModWoodTypes.BOSWELLIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<Block> BOSWELLIA_WALL_SIGN = BLOCKS.register("boswellia_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.BOSWELLIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<Block> BOSWELLIA_HANGING_SIGN = BLOCKS.register("boswellia_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.BOSWELLIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<Block> BOSWELLIA_WALL_HANGING_SIGN = BLOCKS.register("boswellia_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.BOSWELLIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<Block> FRANKINCENSE_RESIN = BLOCKS.register("frankincense_resin", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().strength(0.2f).sound(SoundType.WOOD).lightLevel(GlowLichenBlock.emission((int)0))));
    public static final DeferredBlock<Block> FRANKINCENSE_BUNDLE = ModBlocks.registerBlock("frankincense_bundle", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> SASSAFRAS_SAPLING = ModBlocks.registerBlock("sassafras_sapling", () -> new SaplingBlock(new TreeGrower("sassafras", Optional.empty(), Optional.of(ModFeatures.SASSAFRAS_KEY), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<ModLeavesBlock> SASSAFRAS_LEAVES = ModBlocks.registerBlock("sassafras_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> SASSAFRAS_LOG = ModBlocks.registerBlock("sassafras_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> SASSAFRAS_WOOD = ModBlocks.registerBlock("sassafras_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_SASSAFRAS_LOG = ModBlocks.registerBlock("stripped_sassafras_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_SASSAFRAS_WOOD = ModBlocks.registerBlock("stripped_sassafras_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<ModPlanksBlock> SASSAFRAS_PLANKS = ModBlocks.registerBlock("sassafras_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FIREMILK_MUSHROOM = ModBlocks.registerBlock("firemilk_mushroom", () -> new FiremilkMushroomBlock(ModFeatures.HUGE_FIREMILK_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)));
    public static final DeferredBlock<Block> POTTED_FIREMILK_MUSHROOM = BLOCKS.register("potted_firemilk_mushroom", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, FIREMILK_MUSHROOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM)));
    public static final DeferredBlock<HugeMushroomBlock> FIREMILK_MUSHROOM_BLOCK = ModBlocks.registerBlock("firemilk_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)));
    public static final DeferredBlock<HugeMushroomBlock> DARK_FIREMILK_MUSHROOM_BLOCK = ModBlocks.registerBlock("dark_firemilk_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK)));
    public static final DeferredBlock<MistletoeLeavesBlock> BLOOMING_MISTLETOE_LEAVES = ModBlocks.registerBlock("blooming_mistletoe_leaves", () -> new MistletoeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<MistletoeLeavesBlock> MISTLETOE_LEAVES = ModBlocks.registerBlock("mistletoe_leaves", () -> new MistletoeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<HangingMistletoeBlock> HANGING_MISTLETOE = ModBlocks.registerBlock("hanging_mistletoe", () -> new HangingMistletoeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> HELIOTROPE = ModBlocks.registerBlock("heliotrope", () -> new FlowerBlock(MobEffects.POISON, 7.0f, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> POTTED_HELIOTROPE = BLOCKS.register("potted_heliotrope", () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, HELIOTROPE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final DeferredBlock<BrushableBlock> SUSPICIOUS_ROOTS = ModBlocks.registerBlock("suspicious_roots", () -> new ModSusBlock(Blocks.ROOTED_DIRT, SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED, BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBLockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> net.neoforged.neoforge.registries.DeferredItem<BlockItem> registerBLockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

