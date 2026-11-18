/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.Util
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.HangingSignItem
 *  net.minecraft.world.item.HoeItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemNameBlockItem
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.item.ShovelItem
 *  net.minecraft.world.item.SignItem
 *  net.minecraft.world.item.SwordItem
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.somfunambulist.thicket.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.DiggerItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.block.ModBlocks;
import net.somfunambulist.thicket.entity.custom.ModBoatEntity;
import net.somfunambulist.thicket.item.ModFoodProperties;
import net.somfunambulist.thicket.item.ModToolTiers;
import net.somfunambulist.thicket.item.custom.AnointingOilItem;
import net.somfunambulist.thicket.item.custom.CruxwoodBowItem;
import net.somfunambulist.thicket.item.custom.DowsingRodItem;
import net.somfunambulist.thicket.item.custom.EnchantedMistletoeItem;
import net.somfunambulist.thicket.item.custom.HazelbutterItem;
import net.somfunambulist.thicket.item.custom.MistletoeItem;
import net.somfunambulist.thicket.item.custom.ModBoatItem;
import net.somfunambulist.thicket.item.custom.PocketKnifeItem;
import net.somfunambulist.thicket.item.custom.SickleItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("thicket");
    public static final DeferredItem<Item> POCKET_KNIFE = ITEMS.register("pocket_knife", () -> new PocketKnifeItem(new Item.Properties().stacksTo(1).durability(238)));
    public static final DeferredItem<Item> DOWSING_ROD = ITEMS.register("dowsing_rod", () -> new DowsingRodItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HAZELNUT = ITEMS.register("hazelnut", () -> new Item(new Item.Properties().food(ModFoodProperties.HAZELNUT)));
    public static final DeferredItem<Item> HAZELBUTTER = ITEMS.register("hazelbutter", () -> new HazelbutterItem(new Item.Properties().food(ModFoodProperties.HAZELBUTTER)));
    public static final DeferredItem<Item> HAZELBUTTER_TREAT = ITEMS.register("hazelbutter_treat", () -> new Item(new Item.Properties().food(ModFoodProperties.HAZELBUTTER_TREAT)));
    public static final DeferredItem<Item> HAZEL_SIGN = ITEMS.register("hazel_sign", () -> new SignItem(new Item.Properties().stacksTo(16), (Block)ModBlocks.HAZEL_SIGN.get(), (Block)ModBlocks.HAZEL_WALL_SIGN.get()));
    public static final DeferredItem<Item> HAZEL_HANGING_SIGN = ITEMS.register("hazel_hanging_sign", () -> new HangingSignItem((Block)ModBlocks.HAZEL_HANGING_SIGN.get(), (Block)ModBlocks.HAZEL_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> HAZEL_BOAT = ITEMS.register("hazel_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.HAZEL, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HAZEL_CHEST_BOAT = ITEMS.register("hazel_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.HAZEL, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MISTLETOE = ITEMS.register("mistletoe", () -> new MistletoeItem(new Item.Properties(), (Block)ModBlocks.HANGING_MISTLETOE.get()));
    public static final DeferredItem<Item> ENCHANTED_MISTLETOE = ITEMS.register("enchanted_mistletoe", () -> new EnchantedMistletoeItem(new Item.Properties().stacksTo(1).durability(24)));
    public static final DeferredItem<Item> CRUXWOOD_SWORD = ITEMS.register("cruxwood_sword", () -> new SwordItem(ModToolTiers.CRUXWOOD, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.CRUXWOOD, 3, -2.4f))));
    public static final DeferredItem<Item> CRUXWOOD_PICKAXE = ITEMS.register("cruxwood_pickaxe", () -> new PickaxeItem(ModToolTiers.CRUXWOOD, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.CRUXWOOD, 1.0f, -2.8f))));
    public static final DeferredItem<Item> CRUXWOOD_SHOVEL = ITEMS.register("cruxwood_shovel", () -> new ShovelItem(ModToolTiers.CRUXWOOD, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.CRUXWOOD, 1.5f, -3.0f))));
    public static final DeferredItem<Item> CRUXWOOD_AXE = ITEMS.register("cruxwood_axe", () -> new AxeItem(ModToolTiers.CRUXWOOD, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.CRUXWOOD, 6.0f, -3.2f))));
    public static final DeferredItem<Item> CRUXWOOD_HOE = ITEMS.register("cruxwood_hoe", () -> new HoeItem(ModToolTiers.CRUXWOOD, new Item.Properties().attributes(DiggerItem.createAttributes(ModToolTiers.CRUXWOOD, 0.0f, -3.0f))));
    public static final DeferredItem<Item> CRUXWOOD_BOW = ITEMS.register("cruxwood_bow", () -> new CruxwoodBowItem(new Item.Properties().durability(40)));
    public static final DeferredItem<Item> GOLD_SICKLE = ITEMS.register("gold_sickle", () -> new SickleItem(new Item.Properties().stacksTo(1).durability(32)));
    public static final DeferredItem<Item> MYRRH_SIGN = ITEMS.register("myrrh_sign", () -> new SignItem(new Item.Properties().stacksTo(16), (Block)ModBlocks.MYRRH_SIGN.get(), (Block)ModBlocks.MYRRH_WALL_SIGN.get()));
    public static final DeferredItem<Item> MYRRH_HANGING_SIGN = ITEMS.register("myrrh_hanging_sign", () -> new HangingSignItem((Block)ModBlocks.MYRRH_HANGING_SIGN.get(), (Block)ModBlocks.MYRRH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> MYRRH_BOAT = ITEMS.register("myrrh_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.MYRRH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MYRRH_CHEST_BOAT = ITEMS.register("myrrh_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.MYRRH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MYRRH_RESIN = ITEMS.register("myrrh_resin", () -> new ItemNameBlockItem((Block)ModBlocks.MYRRH_RESIN.get(), new Item.Properties()));
    public static final DeferredItem<Item> BOSWELLIA_SIGN = ITEMS.register("boswellia_sign", () -> new SignItem(new Item.Properties().stacksTo(16), (Block)ModBlocks.BOSWELLIA_SIGN.get(), (Block)ModBlocks.BOSWELLIA_WALL_SIGN.get()));
    public static final DeferredItem<Item> BOSWELLIA_HANGING_SIGN = ITEMS.register("boswellia_hanging_sign", () -> new HangingSignItem((Block)ModBlocks.BOSWELLIA_HANGING_SIGN.get(), (Block)ModBlocks.BOSWELLIA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> BOSWELLIA_BOAT = ITEMS.register("boswellia_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.BOSWELLIA, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BOSWELLIA_CHEST_BOAT = ITEMS.register("boswellia_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.BOSWELLIA, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> FRANKINCENSE_RESIN = ITEMS.register("frankincense_resin", () -> new ItemNameBlockItem((Block)ModBlocks.FRANKINCENSE_RESIN.get(), new Item.Properties()));
    public static final DeferredItem<Item> SUNFLOWER_OIL = ITEMS.register("sunflower_oil", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ANOINTING_OIL = ITEMS.register("anointing_oil", () -> new AnointingOilItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component APOCRYPHAL_WEAPON_UPGRADE = Component.translatable((String)Util.makeDescriptionId((String)"upgrade", (ResourceLocation)ResourceLocation.fromNamespaceAndPath("thicket", "apocryphal_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component APOCRYPHAL_WEAPON_APPLIES_TO = Component.translatable((String)Util.makeDescriptionId((String)"item", (ResourceLocation)ResourceLocation.fromNamespaceAndPath("thicket", "smithing_template.apocryphal_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component APOCRYPHAL_WEAPON_INGREDIENTS = Component.translatable((String)Util.makeDescriptionId((String)"item", (ResourceLocation)ResourceLocation.fromNamespaceAndPath("thicket", "smithing_template.apocryphal_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component APOCRYPHAL_WEAPON_BASE_SLOT_DESCRIPTION = Component.translatable((String)Util.makeDescriptionId((String)"item", (ResourceLocation)ResourceLocation.fromNamespaceAndPath("thicket", "smithing_template.apocryphal_upgrade.base_slot_description")));
    private static final Component APOCRYPHAL_WEAPON_ADDITIONS_SLOT_DESCRIPTION = Component.translatable((String)Util.makeDescriptionId((String)"item", (ResourceLocation)ResourceLocation.fromNamespaceAndPath("thicket", "smithing_template.apocryphal_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_MISTLETOE = ResourceLocation.fromNamespaceAndPath("thicket", "item/empty_slot_mistletoe");
    private static final ResourceLocation EMPTY_SLOT_BOW = ResourceLocation.fromNamespaceAndPath("thicket", "item/empty_slot_bow");
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    public static final DeferredItem<Item> APOCRYPHAL_SMITHING_TEMPLATE = ITEMS.register("apocryphal_smithing_template", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

