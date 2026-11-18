/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.BowItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 */
package net.somfunambulist.thicket.item.custom;

import java.util.function.Predicate;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.somfunambulist.thicket.item.ModItems;

public class CruxwoodBowItem
extends BowItem {
    public static final Predicate<ItemStack> ARROW_OR_MISTLETOE = ARROW_ONLY.or(MISTLETOE -> MISTLETOE.is((Item)ModItems.MISTLETOE.get()));

    public CruxwoodBowItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_MISTLETOE;
    }
}

