package net.raccoon.will.verdant_tides.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.raccoon.will.verdant_tides.VerdantTides;

import java.util.function.Supplier;


public class VTBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VerdantTides.MODID);





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, boolean registerItem) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (registerItem) {
            VTItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        }
        return toReturn;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true);
    }

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}

