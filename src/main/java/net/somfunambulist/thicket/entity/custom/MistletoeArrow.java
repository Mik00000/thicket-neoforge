package net.somfunambulist.thicket.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.somfunambulist.thicket.entity.ModEntities;
import net.somfunambulist.thicket.item.ModItems;

public class MistletoeArrow extends AbstractArrow {
    public MistletoeArrow(EntityType<? extends MistletoeArrow> type, Level worldIn) {
        super(type, worldIn);
    }

    public MistletoeArrow(Level worldIn, double x, double y, double z) {
        super(ModEntities.MISTLETOE_ARROW.get(), x, y, z, worldIn, new ItemStack(ModItems.MISTLETOE.get()), null);
    }

    public MistletoeArrow(Level worldIn, LivingEntity shooter) {
        super(ModEntities.MISTLETOE_ARROW.get(), shooter, worldIn, new ItemStack(ModItems.MISTLETOE.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.MISTLETOE.get());
    }
}
