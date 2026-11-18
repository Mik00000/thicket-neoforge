package net.somfunambulist.thicket.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.somfunambulist.thicket.Thicket;

public class SickleItem extends ShearsItem {
    public static final String FULL_MOON_TAG_KEY = "fullMoon";

    public SickleItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
        return repairStack.is(Items.GOLD_INGOT);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        if (Thicket.Proxy.getClientLevel() != null) {
            return this.isFullMoon(Thicket.Proxy.getClientLevel());
        }
        CustomData customData = pStack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            return tag.contains(FULL_MOON_TAG_KEY) && tag.getBoolean(FULL_MOON_TAG_KEY);
        }
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slotIndex, boolean selectedIndex) {
        this.tryUpdateFullMoonTag(stack, level);
        super.inventoryTick(stack, level, entity, slotIndex, selectedIndex);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        this.tryUpdateFullMoonTag(stack, entity.level());
        return super.onEntityItemUpdate(stack, entity);
    }

    private void tryUpdateFullMoonTag(ItemStack stack, Level level) {
        CustomData customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = customData.copyTag();
        boolean newValue = this.isFullMoon(level);
        if (!tag.contains(FULL_MOON_TAG_KEY) || tag.getBoolean(FULL_MOON_TAG_KEY) != newValue) {
            tag.putBoolean(FULL_MOON_TAG_KEY, newValue);
            stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        }
    }

    private boolean isFullMoon(Level level) {
        int phase = level.getMoonPhase();
        if (phase != 0) {
            return false;
        }
        float currentTimeScale = level.getTimeOfDay(0.0f);
        return (double)currentTimeScale >= 0.25 && (double)currentTimeScale <= 0.75;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 22;
    }
}
