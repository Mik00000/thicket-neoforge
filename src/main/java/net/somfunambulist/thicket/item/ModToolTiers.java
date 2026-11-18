package net.somfunambulist.thicket.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CRUXWOOD = new SimpleTier(
        BlockTags.INCORRECT_FOR_WOODEN_TOOL,
        59,
        2.0f,
        0.0f,
        26,
        () -> Ingredient.of(ModItems.ENCHANTED_MISTLETOE.get())
    );
}
