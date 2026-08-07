package net.joshcardboardbox.tutorialmod.datagen;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.block.ModBlocks;
import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TutorialMod.MODID);
    }

    /** Where our code for rendering things is put. */
    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels)
    {
        /* register functions for groups of items */
        registerAzuriteItemsBlocks(blockModels, itemModels);

        /* Unique Items & Blocks */
        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.END_FIRE_STARTER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TEXTURELESS_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


    }

    ///Azurite
    private void registerAzuriteItemsBlocks(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        /* Items */
        itemModels.generateFlatItem(ModItems.AZURITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AZURITE.get(), ModelTemplates.FLAT_ITEM);

        /* Blocks - generate Item, Block, and block model JSON files */
        blockModels.family(ModBlocks.AZURITE_BLOCK.get())
                .slab(ModBlocks.AZURITE_SLAB.get())
                .stairs(ModBlocks.AZURITE_STAIRS.get())
                .pressurePlate(ModBlocks.AZURITE_PRESSURE_PLATE.get())
                .button(ModBlocks.AZURITE_BUTTON.get())
                .fence(ModBlocks.AZURITE_FENCE.get())
                .fenceGate(ModBlocks.AZURITE_FENCE_GATE.get())
                .wall(ModBlocks.AZURITE_WALL.get())
                .door(ModBlocks.AZURITE_DOOR.get())
                .trapdoor(ModBlocks.AZURITE_TRAPDOOR.get()); //needs to be final, is void
        blockModels.family(ModBlocks.RAW_AZURITE_BLOCK.get())
                .slab(ModBlocks.RAW_AZURITE_SLAB.get())
                .stairs(ModBlocks.RAW_AZURITE_STAIRS.get())
                .pressurePlate(ModBlocks.RAW_AZURITE_PRESSURE_PLATE.get())
                .button(ModBlocks.RAW_AZURITE_BUTTON.get())
                .fence(ModBlocks.RAW_AZURITE_FENCE.get())
                .fenceGate(ModBlocks.RAW_AZURITE_FENCE_GATE.get())
                .wall(ModBlocks.RAW_AZURITE_WALL.get())
                .door(ModBlocks.RAW_AZURITE_DOOR.get())
                .trapdoor(ModBlocks.RAW_AZURITE_TRAPDOOR.get()); //needs to be final, is void



        blockModels.createTrivialCube(ModBlocks.AZURITE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_END_ORE.get());

        blockModels.family(ModBlocks.MAGIC_BLOCK.get())
                .slab(ModBlocks.MAGIC_SLAB.get());



    }

}
