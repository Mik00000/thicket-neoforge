package net.somfunambulist.thicket;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.block.compat.DecorativeBlocksBlocks;
import net.somfunambulist.thicket.block.compat.EcologicsBlocks;
import net.somfunambulist.thicket.block.compat.WindsweptBlocks;
import net.somfunambulist.thicket.block.entity.ModBlockEntities;
import net.somfunambulist.thicket.client.ClientProxy;
import net.somfunambulist.thicket.effect.ModEffects;
import net.somfunambulist.thicket.enchantment.ModEnchantments;
import net.somfunambulist.thicket.entity.ModEntities;
import net.somfunambulist.thicket.entity.client.MistletoeArrowRenderer;
import net.somfunambulist.thicket.entity.client.ModBoatRenderer;
import net.somfunambulist.thicket.item.ModCreativeModeTabs;
import net.somfunambulist.thicket.item.ModItemProperties;
import net.somfunambulist.thicket.item.ModItems;
import net.somfunambulist.thicket.painting.ModPaintings;
import net.somfunambulist.thicket.util.CommonProxy;
import net.somfunambulist.thicket.util.ModWoodTypes;
import net.somfunambulist.thicket.worldgen.ModFeatures;
import org.slf4j.Logger;

@Mod(Thicket.MOD_ID)
public class Thicket {
    public static final String MOD_ID = "thicket";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CommonProxy Proxy = FMLEnvironment.dist == Dist.CLIENT ? new ClientProxy() : new CommonProxy();

    public Thicket(IEventBus modEventBus) {
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntities.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModEffects.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.addListener(this::onBrewingRecipes);
        modEventBus.addListener(this::addCreative);
        if (ModList.get().isLoaded("decorative_blocks")) {
            DecorativeBlocksBlocks.register(modEventBus);
        }
        if (ModList.get().isLoaded("ecologics")) {
            EcologicsBlocks.register(modEventBus);
        }
        if (ModList.get().isLoaded("windswept")) {
            WindsweptBlocks.register(modEventBus);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.HAZELNUT.get(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.HAZEL_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.HAZEL_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MYRRH_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MYRRH_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BOSWELLIA_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BOSWELLIA_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.HELIOTROPE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.SASSAFRAS_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.SASSAFRAS_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.FIREMILK_MUSHROOM.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MISTLETOE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MISTLETOE_LEAVES.get().asItem(), 0.3f);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.HAZEL_SAPLING.getId(), ModBlocks.POTTED_HAZEL_SAPLING);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.MYRRH_SAPLING.getId(), ModBlocks.POTTED_MYRRH_SAPLING);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.BOSWELLIA_SAPLING.getId(), ModBlocks.POTTED_BOSWELLIA_SAPLING);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.FIREMILK_MUSHROOM.getId(), ModBlocks.POTTED_FIREMILK_MUSHROOM);
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.HELIOTROPE.getId(), ModBlocks.POTTED_HELIOTROPE);
        });
    }

    private void onBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.WATER, ModBlocks.FIREMILK_MUSHROOM.get().asItem(), Potions.AWKWARD);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    public static ResourceLocation modPrefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ModItemProperties.addCustomItemProperties();
                Sheets.addWoodType(ModWoodTypes.HAZEL);
                Sheets.addWoodType(ModWoodTypes.MYRRH);
                Sheets.addWoodType(ModWoodTypes.BOSWELLIA);
            });
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            event.registerEntityRenderer(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
            event.registerEntityRenderer(ModEntities.MISTLETOE_ARROW.get(), MistletoeArrowRenderer::new);
        }
    }
}
