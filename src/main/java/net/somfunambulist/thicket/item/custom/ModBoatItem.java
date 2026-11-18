/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package net.somfunambulist.thicket.item.custom;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.somfunambulist.thicket.entity.custom.ModBoatEntity;
import net.somfunambulist.thicket.entity.custom.ModChestBoatEntity;

public class ModBoatItem
extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final ModBoatEntity.Type type;
    private final boolean hasChest;

    public ModBoatItem(boolean pHasChest, ModBoatEntity.Type pType, Item.Properties pProperties) {
        super(pProperties);
        this.hasChest = pHasChest;
        this.type = pType;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        BlockHitResult hitresult = ModBoatItem.getPlayerPOVHitResult((Level)pLevel, (Player)pPlayer, (ClipContext.Fluid)ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        }
        Vec3 vec3 = pPlayer.getViewVector(1.0f);
        List<Entity> list = pLevel.getEntities((Entity)pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0)).inflate(1.0), ENTITY_PREDICATE);
        if (!list.isEmpty()) {
            Vec3 vec31 = pPlayer.getEyePosition();
            for (Entity entity : list) {
                AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                if (!aabb.contains(vec31)) continue;
                return InteractionResultHolder.pass(itemstack);
            }
        }
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            ModBoatEntity boat = this.getBoat(pLevel, (HitResult)hitresult);
            if (boat instanceof ModChestBoatEntity) {
                ModChestBoatEntity chestBoat = (ModChestBoatEntity)boat;
                chestBoat.setWoodType(this.type);
            } else if (boat instanceof ModBoatEntity) {
                boat.setWoodType(this.type);
            }
            boat.setYRot(pPlayer.getYRot());
            if (!pLevel.noCollision((Entity)boat, boat.getBoundingBox())) {
                return InteractionResultHolder.fail(itemstack);
            }
            if (!pLevel.isClientSide) {
                pLevel.addFreshEntity((Entity)boat);
                pLevel.gameEvent((Entity)pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
            }
            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
        return InteractionResultHolder.pass(itemstack);
    }

    private ModBoatEntity getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new ModChestBoatEntity(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new ModBoatEntity(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}

