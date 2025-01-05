package de.dralox.dratestmod.item;

import de.dralox.dratestmod.DraTestMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DraTestMod.MOD_ID);

    public static final DeferredItem<Item> DRAXITE = ITEMS.register("draxite", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAWDRAXITE = ITEMS.register("rawdraxite", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
