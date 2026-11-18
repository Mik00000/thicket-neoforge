/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.world.level.Level
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package net.somfunambulist.thicket.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.somfunambulist.thicket.util.CommonProxy;

public class ClientProxy
extends CommonProxy {
    @Override
    @OnlyIn(value=Dist.CLIENT)
    public Level getClientLevel() {
        return Minecraft.getInstance().level;
    }
}

