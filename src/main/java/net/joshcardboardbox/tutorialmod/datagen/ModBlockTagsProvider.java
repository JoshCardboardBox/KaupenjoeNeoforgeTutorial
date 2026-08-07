package net.joshcardboardbox.tutorialmod.datagen;

import net.joshcardboardbox.tutorialmod.block.ModBlocks;
import net.joshcardboardbox.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modid) {
        super(output, lookupProvider, modid);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.RAW_AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                ;


        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                ;


        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.RAW_AZURITE_BLOCK.get())
                .add(ModBlocks.RAW_AZURITE_SLAB.get())
                .add(ModBlocks.RAW_AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.AZURITE_FENCE.get())
                .add(ModBlocks.AZURITE_FENCE_GATE.get())
                .add(ModBlocks.AZURITE_WALL.get())
                ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                ;
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                //.add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                ;
        tag(Tags.Blocks.NEEDS_GOLD_TOOL)
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                ;

        //BLOCK SHAPES
        tag(BlockTags.SLABS)
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.RAW_AZURITE_SLAB.get())
        ;
        tag(BlockTags.STAIRS)
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.RAW_AZURITE_STAIRS.get())
        ;
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.get())
                .add(ModBlocks.RAW_AZURITE_PRESSURE_PLATE.get())
        ;
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.AZURITE_BUTTON.get())
                .add(ModBlocks.RAW_AZURITE_BUTTON.get())
        ;
        tag(BlockTags.FENCES)
                .add(ModBlocks.AZURITE_FENCE.get())
                .add(ModBlocks.RAW_AZURITE_FENCE.get())
        ;
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.AZURITE_FENCE_GATE.get())
                .add(ModBlocks.RAW_AZURITE_FENCE_GATE.get())
        ;
        tag(BlockTags.WALLS)
                .add(ModBlocks.AZURITE_WALL.get())
                .add(ModBlocks.RAW_AZURITE_WALL.get())
        ;
        tag(BlockTags.DOORS)
                .add(ModBlocks.AZURITE_DOOR.get())
                .add(ModBlocks.RAW_AZURITE_DOOR.get())
        ;
        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.AZURITE_TRAPDOOR.get())
                .add(ModBlocks.RAW_AZURITE_TRAPDOOR.get())
        ;


        /* new tags */
        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES)
                ;

    }
}
