package net.somfunambulist.thicket.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties HAZELNUT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).fast().build();
    public static final FoodProperties HAZELBUTTER = new FoodProperties.Builder().nutrition(4).saturationModifier(0.2f).build();
    public static final FoodProperties HAZELBUTTER_TREAT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).build();
}
