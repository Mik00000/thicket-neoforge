/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.RecipeType
 *  org.jetbrains.annotations.Nullable
 */
package net.somfunambulist.thicket.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem
extends Item {
    private int burnTime;

    public FuelItem(Item.Properties pProperties) {
        super(pProperties);
        this.burnTime = this.burnTime = 0;
    }

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}

