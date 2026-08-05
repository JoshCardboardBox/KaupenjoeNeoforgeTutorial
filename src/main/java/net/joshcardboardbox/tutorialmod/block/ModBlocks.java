package net.joshcardboardbox.tutorialmod.block;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.block.custom.MagicBlock;
import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    /** for most blocks... */
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //register blocks & block items
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }

    /** method overloading for adding hover text */
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, Component... components) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, components);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Component... components) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix())
        {
            @Override
            public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                //Components... <-- because you may wish to add multiple hover texts to one item
                for (var component : components) {
                    builder.accept(component);
                }
                super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
            }
        });
    }



    /* ##########CUSTOM BLOCKS############# */
    public static final DeferredBlock<Block> AZURITE_BLOCK =
            registerBlock("azurite_block", properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));
    public static final DeferredBlock<Block> RAW_AZURITE_BLOCK =
            registerBlock("raw_azurite_block", properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST_CLUSTER)
            ));
    public static final DeferredBlock<Block> AZURITE_ORE =
            registerBlock("azurite_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));
    public static final DeferredBlock<Block> AZURITE_DEEPSLATE_ORE =
            registerBlock("azurite_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            ));
    public static final DeferredBlock<Block> AZURITE_NETHER_ORE =
            registerBlock("azurite_nether_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERRACK)
            ));
    public static final DeferredBlock<Block> AZURITE_END_ORE =
            registerBlock("azurite_end_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties
                    .strength(3.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)
            ));

    public static final DeferredBlock<Block> MAGIC_BLOCK =
            registerBlock("magic_block", properties -> new MagicBlock(properties
                    .strength(20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DECORATED_POT_CRACKED)
            ), Component.translatable("tooltip.tutorialmod.magic_block.tooltip"));
    /* END OF CUSTOM BLOCKS */




}
