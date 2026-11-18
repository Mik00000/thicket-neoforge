package net.somfunambulist.thicket.block.compat;

import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.somfunambulist.thicket.item.ModItems;

public class EcologicsBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("thicket");
    public static final DeferredBlock<Block> WALNUT_BUNDLE = EcologicsBlocks.registerBlock("walnut_bundle", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        EcologicsBlocks.registerBLockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBLockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.registerSimpleBlockItem(block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
