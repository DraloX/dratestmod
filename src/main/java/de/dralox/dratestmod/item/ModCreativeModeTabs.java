package de.dralox.dratestmod.item;

import de.dralox.dratestmod.DraTestMod;
import de.dralox.dratestmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DraTestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DRAXITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("draxite_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DRAXITE.get()))
                    .title(Component.translatable("creativetab.dratestmod.draxite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DRAXITE.get());
                        output.accept(ModItems.RAWDRAXITE.get());
                    })
                    .build());

    public static final Supplier<CreativeModeTab> DRAXITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("draxite_blocks_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.DRAXITE_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DraTestMod.MOD_ID, "draxite_items_tab"))
                    .title(Component.translatable("creativetab.dratestmod.draxite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DRAXITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_DRAXITE_BLOCK.get());
                        output.accept(ModBlocks.DRAXITE_ORE.get());
                        output.accept(ModBlocks.DRAXITE_DEEPSLATE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
