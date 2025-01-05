package de.dralox.dratestmod.block;

import de.dralox.dratestmod.DraTestMod;
import de.dralox.dratestmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DraTestMod.MOD_ID);

    public static final DeferredBlock<Block> RAW_DRAXITE_BLOCK = registerBlock("rawdraxiteblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DRAXITE_BLOCK = registerBlock("draxiteblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> DRAXITE_ORE = registerBlock("draxiteore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DRAXITE_DEEPSLATE_ORE = registerBlock("draxitedeepslateore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> result = BLOCKS.register(name, block);
        registerBlockItem(name, result);
        return result;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
