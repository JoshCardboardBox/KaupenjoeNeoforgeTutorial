package net.joshcardboardbox.tutorialmod.creativemodetab;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.block.ModBlocks;
import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

//test https://github.com/neoforged/NeoForge/discussions/2548
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
//test end

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MODID);

    public static final Supplier<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
        () -> CreativeModeTab.builder()
                .icon(()->new ItemStack(ModItems.AZURITE.get()))
                .title(Component.translatable("creativetab.tutorialmod.azurite_items"))
                .withTabsAfter(Identifier.fromNamespaceAndPath(TutorialMod.MODID, "azurite_blocks_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.AZURITE);
                    output.accept(ModItems.RAW_AZURITE);
                    output.accept(ModItems.METAL_DETECTOR);
                    output.accept(ModItems.ONION);
                    output.accept(ModItems.END_FIRE_STARTER);
                    output.accept(ModItems.TEXTURELESS_SWORD);
                })
                .build());

    public static final Supplier<CreativeModeTab> AZURITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("azurite_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(()->new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.tutorialmod.azurite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AZURITE_BLOCK);
                        output.accept(ModBlocks.AZURITE_SLAB);
                        output.accept(ModBlocks.AZURITE_STAIRS);
                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.AZURITE_BUTTON);
                        output.accept(ModBlocks.AZURITE_FENCE);
                        output.accept(ModBlocks.AZURITE_FENCE_GATE);
                        output.accept(ModBlocks.AZURITE_WALL);
                        output.accept(ModBlocks.AZURITE_DOOR);
                        output.accept(ModBlocks.AZURITE_TRAPDOOR);
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK);
                        output.accept(ModBlocks.RAW_AZURITE_SLAB);
                        output.accept(ModBlocks.RAW_AZURITE_STAIRS);
                        output.accept(ModBlocks.RAW_AZURITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.RAW_AZURITE_BUTTON);
                        output.accept(ModBlocks.RAW_AZURITE_FENCE);
                        output.accept(ModBlocks.RAW_AZURITE_FENCE_GATE);
                        output.accept(ModBlocks.RAW_AZURITE_WALL);
                        output.accept(ModBlocks.RAW_AZURITE_DOOR);
                        output.accept(ModBlocks.RAW_AZURITE_TRAPDOOR);
                        output.accept(ModBlocks.AZURITE_ORE);
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.AZURITE_NETHER_ORE);
                        output.accept(ModBlocks.AZURITE_END_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.MAGIC_SLAB);
                        output.accept(Blocks.TUFF.asItem()); //TEST
                        output.accept(Items.DIAMOND); //test
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
