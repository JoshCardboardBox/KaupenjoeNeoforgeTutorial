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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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



    /* ########## CUSTOM BLOCKS ############# */

    //AZURITE
    public static final DeferredBlock<Block> AZURITE_BLOCK =
            registerBlock("azurite_block", properties -> new Block(properties
                    .mapColor(MapColor.COLOR_BLUE).strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
            ));
    public static final DeferredBlock<Block> RAW_AZURITE_BLOCK =
            registerBlock("raw_azurite_block", properties -> new Block(properties
                    .mapColor(MapColor.COLOR_BLUE).strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)
            ));



    //VARIANTS
    public static final DeferredBlock<Block> AZURITE_SLAB = registerBlock("azurite_slab",
            properties -> new SlabBlock(properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> AZURITE_STAIRS = registerBlock("azurite_stairs",
            properties -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(), properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> AZURITE_PRESSURE_PLATE = registerBlock("azurite_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties
                    .mapColor(MapColor.COLOR_BLUE).forceSolidOn()
                    .instrument(NoteBlockInstrument.SNARE).noCollision()
                    .strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> AZURITE_BUTTON = registerBlock("azurite_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 10, properties
                    .noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> AZURITE_FENCE = registerBlock("azurite_fence",
            properties -> new FenceBlock(properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> AZURITE_FENCE_GATE = registerBlock("azurite_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> AZURITE_WALL = registerBlock("azurite_wall",
            properties -> new WallBlock(properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> AZURITE_DOOR = registerBlock("azurite_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));
    public static final DeferredBlock<Block> AZURITE_TRAPDOOR = registerBlock("azurite_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));

    public static final DeferredBlock<Block> RAW_AZURITE_SLAB = registerBlock("raw_azurite_slab",
            properties -> new SlabBlock(properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_AZURITE_STAIRS = registerBlock("raw_azurite_stairs",
            properties -> new StairBlock(ModBlocks.RAW_AZURITE_BLOCK.get().defaultBlockState(), properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_AZURITE_PRESSURE_PLATE = registerBlock("raw_azurite_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties
                    .mapColor(MapColor.COLOR_BLUE).forceSolidOn()
                    .instrument(NoteBlockInstrument.SNARE).noCollision()
                    .strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RAW_AZURITE_BUTTON = registerBlock("raw_azurite_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 40, properties
                    .noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RAW_AZURITE_FENCE = registerBlock("raw_azurite_fence",
            properties -> new FenceBlock(properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_AZURITE_FENCE_GATE = registerBlock("raw_azurite_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_AZURITE_WALL = registerBlock("raw_azurite_wall",
            properties -> new WallBlock(properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_AZURITE_DOOR = registerBlock("raw_azurite_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));
    public static final DeferredBlock<Block> RAW_AZURITE_TRAPDOOR = registerBlock("raw_azurite_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON, properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));

    //AZURITE ORES
    public static final DeferredBlock<Block> AZURITE_ORE =
            registerBlock("azurite_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)
            ));
    public static final DeferredBlock<Block> AZURITE_DEEPSLATE_ORE =
            registerBlock("azurite_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
            ));
    public static final DeferredBlock<Block> AZURITE_NETHER_ORE =
            registerBlock("azurite_nether_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)
            ));
    public static final DeferredBlock<Block> AZURITE_END_ORE =
            registerBlock("azurite_end_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)
            ));

    //CUSTOM BLOCKS
    public static final DeferredBlock<Block> MAGIC_BLOCK =
            registerBlock("magic_block", properties -> new MagicBlock(properties
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(20f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DECORATED_POT_CRACKED)
            ), Component.translatable("tooltip.tutorialmod.magic_block.tooltip"));
    //this magic slab has no properties of the magic block
    public static final DeferredBlock<Block> MAGIC_SLAB = registerBlock("magic_slab", properties -> new SlabBlock(properties
            .noCollision()
            .pushReaction(PushReaction.IGNORE)
            .mapColor(MapColor.COLOR_MAGENTA)
            .strength(0.1f)
            .sound(SoundType.ANCIENT_DEBRIS)), Component.translatable("tooltip.tutorialmod.magic_slab.tooltip"));






    /* END OF CUSTOM BLOCKS */




}
