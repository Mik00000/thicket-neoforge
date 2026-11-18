package net.somfunambulist.thicket.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.somfunambulist.thicket.enchantment.ModEnchantments;
import net.somfunambulist.thicket.item.ModItems;
import net.somfunambulist.thicket.item.custom.AnointingOilItem;
import net.somfunambulist.thicket.tags.ModEntityTags;

@EventBusSubscriber(modid = "thicket", bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            var trades = event.getTrades();
            var list = trades.get(3); if (list != null) { list.add((pTrader, pRandom) -> new MerchantOffer(new ItemCost(ModItems.MYRRH_RESIN.get(), 3), new ItemStack(Items.EMERALD, 1), 16, 12, 0.05f));
            list.add((pTrader, pRandom) -> new MerchantOffer(new ItemCost(ModItems.FRANKINCENSE_RESIN.get(), 3), new ItemStack(Items.EMERALD, 1), 16, 12, 0.05f)); }
        }
    }

    public static InteractionResult onRightClickEntity(Player player, Level level, InteractionHand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
        AnointingOilItem oilItem;
        InteractionResult res;
        if (player.isSpectator()) {
            return InteractionResult.PASS;
        }
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item instanceof AnointingOilItem && (res = (oilItem = (AnointingOilItem)item).doInteract(stack, player, entity, hand)).consumesAction()) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        InteractionResult res = ModEvents.onRightClickEntity(event.getEntity(), event.getLevel(), event.getHand(), event.getTarget(), null);
        if (res != InteractionResult.PASS) {
            event.setCanceled(true);
            event.setCancellationResult(res);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() == null) return;
        DamageSource source = event.getSource();
        if (source.getDirectEntity() instanceof Player player) {
            ItemStack weapon = player.getMainHandItem();
            var registry = player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            var occultHolder = registry.get(ModEnchantments.OCCULT);
            if (occultHolder.isPresent()) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(occultHolder.get(), weapon);
                if (level > 0 && event.getEntity().getType().is(ModEntityTags.OCCULT_TARGET)) {
                    event.setNewDamage(event.getNewDamage() + 6.0f * level);
                    player.magicCrit(event.getEntity());
                }
            }
        }
    }
}
