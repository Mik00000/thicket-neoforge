/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 */
package net.somfunambulist.thicket.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.somfunambulist.thicket.entity.custom.MistletoeArrow;
import net.somfunambulist.thicket.item.custom.ArrowBlockItem;

public class MistletoeItem
extends ArrowBlockItem {
    public MistletoeItem(Item.Properties pProperties, Block block) {
        super(pProperties, block);
    }

    public AbstractArrow createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
        return new MistletoeArrow(worldIn, shooter);
    }
}

