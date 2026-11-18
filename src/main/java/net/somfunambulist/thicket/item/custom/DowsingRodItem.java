package net.somfunambulist.thicket.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slotIndex, boolean selectedIndex) {
        if (entity instanceof Player player) {
            if (player.getMainHandItem() == stack || player.getOffhandItem() == stack) {
                BlockPos blockpos = player.blockPosition();
                boolean foundWater = false;
                for (int i = 0; i < 48; ++i) {
                    if (!level.getFluidState(blockpos.below(i)).is(Fluids.WATER) && !level.getFluidState(blockpos.below(i)).is(Fluids.FLOWING_WATER)) continue;
                    foundWater = true;
                    break;
                }
                if (foundWater) {
                    CompoundTag tag = new CompoundTag();
                    tag.putBoolean("foundWater", true);
                    stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
                } else {
                    stack.remove(DataComponents.CUSTOM_DATA);
                }
            } else {
                stack.remove(DataComponents.CUSTOM_DATA);
            }
        }
        super.inventoryTick(stack, level, entity, slotIndex, selectedIndex);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        item.remove(DataComponents.CUSTOM_DATA);
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.has(DataComponents.CUSTOM_DATA);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
