/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.vehicle.Boat
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.Level
 */
package net.somfunambulist.thicket.entity.custom;

import java.util.function.Supplier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.somfunambulist.thicket.entity.ModEntities;
import net.somfunambulist.thicket.item.ModItems;

public class ModBoatEntity
extends Boat {
    private static final EntityDataAccessor<Integer> WOOD_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public ModBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this((EntityType<? extends Boat>)((EntityType)ModEntities.MOD_BOAT.get()), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WOOD_TYPE, 0);
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setWoodType(Type.byName(pCompound.getString("Type")));
        }
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getWoodType().getName());
    }

    public Type getWoodType() {
        return Type.byId((Integer)this.entityData.get(WOOD_TYPE));
    }

    public void setWoodType(Type type) {
        this.entityData.set(WOOD_TYPE, type.ordinal());
    }

    public Item getDropItem() {
        return this.getWoodType().getItem().get();
    }

    

    public static enum Type {
        HAZEL("hazel", () -> (Item)ModItems.HAZEL_BOAT.get(), () -> (Item)ModItems.HAZEL_CHEST_BOAT.get()),
        MYRRH("myrrh", () -> (Item)ModItems.MYRRH_BOAT.get(), () -> (Item)ModItems.MYRRH_CHEST_BOAT.get()),
        BOSWELLIA("boswellia", () -> (Item)ModItems.BOSWELLIA_BOAT.get(), () -> (Item)ModItems.BOSWELLIA_CHEST_BOAT.get());

        private final String name;
        private final Supplier<Item> item;
        private final Supplier<Item> chestItem;

        private Type(String name, Supplier<Item> boatItem, Supplier<Item> chestBoatItem) {
            this.name = name;
            this.item = boatItem;
            this.chestItem = chestBoatItem;
        }

        public ResourceLocation getTexture(boolean hasChest) {
            if (hasChest) {
                return ResourceLocation.fromNamespaceAndPath("thicket", "textures/entity/mod_chest_boat/" + this.name + ".png");
            }
            return ResourceLocation.fromNamespaceAndPath("thicket", "textures/entity/mod_boat/" + this.name + ".png");
        }

        public String getModelLocation() {
            return "boat/" + this.name;
        }

        public String getChestModelLocation() {
            return "chest_boat/" + this.name;
        }

        public String getName() {
            return this.name;
        }

        public Supplier<Item> getItem() {
            return this.item;
        }

        public Supplier<Item> getChestItem() {
            return this.chestItem;
        }

        public static Type byId(int id) {
            Type[] values = Type.values();
            if (id < 0 || id >= values.length) {
                id = 0;
            }
            return values[id];
        }

        public static Type byName(String name) {
            Type[] values = Type.values();
            for (int i = 0; i < values.length; ++i) {
                if (!values[i].getName().equals(name)) continue;
                return values[i];
            }
            return values[0];
        }
    }
}

