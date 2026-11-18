/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.Level
 */
package net.somfunambulist.thicket.item.custom;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.somfunambulist.thicket.effect.ModEffects;

public class AnointingOilItem
extends Item {
    public AnointingOilItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult doInteract(ItemStack stack, Player player, Entity entity, InteractionHand hand) {
        LivingEntity le;
        if (entity.level().isClientSide) {
            return InteractionResult.PASS;
        }
        if (entity instanceof LivingEntity && (le = (LivingEntity)entity).isBaby() && !le.hasEffect(ModEffects.ANOINTED_EFFECT)) {
            le.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0, true, false));
            MobEffectInstance effect = new MobEffectInstance(ModEffects.ANOINTED_EFFECT, -1, 0, false, false);
            effect.getCures().clear();
            le.addEffect(effect);
            if (entity instanceof Mob) {
                ((Mob)entity).setPersistenceRequired();
            }
            Level level = player.level();
            level.playSound((Player)null, BlockPos.containing((Position)entity.position()), SoundEvents.BOTTLE_EMPTY, SoundSource.PLAYERS, 0.3f, 0.7f);
            level.playSound((Player)null, BlockPos.containing((Position)entity.position()), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.5f, 0.2f);
            player.setItemInHand(hand, Items.GLASS_BOTTLE.getDefaultInstance());
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}

