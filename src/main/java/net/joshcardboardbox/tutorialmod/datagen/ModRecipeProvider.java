package net.joshcardboardbox.tutorialmod.datagen;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.block.ModBlocks;
import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.AZURITE)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);
        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output);
        //will save it by name of output, also u need to add  modid:
        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 18)
                .requires(ModBlocks.RAW_AZURITE_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModBlocks.RAW_AZURITE_BLOCK.get()), has(ModBlocks.RAW_AZURITE_BLOCK))
                .group("azurite")
                .save(output, TutorialMod.MODID+":azurite_from_blaze_powder");

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_SLAB.get(), ModItems.AZURITE.get());
        stairBuilder(ModBlocks.AZURITE_STAIRS.get(), Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite").save(output);
        pressurePlate(ModBlocks.AZURITE_PRESSURE_PLATE, ModItems.AZURITE.get());
        buttonBuilder(ModBlocks.AZURITE_BUTTON, Ingredient.of(ModItems.AZURITE.get()))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite"). save(output);
        fenceBuilder(ModBlocks.AZURITE_FENCE, Ingredient.of(ModItems.AZURITE.get()))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite"). save(output);
        fenceGateBuilder(ModBlocks.AZURITE_FENCE_GATE, Ingredient.of(ModItems.AZURITE.get()))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite"). save(output);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_WALL, Ingredient.of(ModBlocks.AZURITE_BLOCK.get()))
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite"). save(output);
        doorBuilder(ModBlocks.AZURITE_DOOR, Ingredient.of(ModItems.AZURITE.get()))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite"). save(output);;
        trapdoorBuilder(ModBlocks.AZURITE_TRAPDOOR, Ingredient.of(ModItems.AZURITE.get()))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite"). save(output);;


        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AZURITE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_AZURITE)
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite")
                .save(output);
        shapeless(RecipeCategory.MISC, ModItems.RAW_AZURITE.get(), 9)
                .requires(ModBlocks.RAW_AZURITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RAW_AZURITE_BLOCK.get()), has(ModBlocks.RAW_AZURITE_BLOCK))
                .group("raw_azurite")
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AZURITE_SLAB.get(), ModItems.RAW_AZURITE.get());
        stairBuilder(ModBlocks.RAW_AZURITE_STAIRS.get(), Ingredient.of(ModItems.RAW_AZURITE))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .save(output);
        pressurePlate(ModBlocks.RAW_AZURITE_PRESSURE_PLATE, ModItems.RAW_AZURITE.get());
        buttonBuilder(ModBlocks.RAW_AZURITE_BUTTON, Ingredient.of(ModItems.RAW_AZURITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite"). save(output);
        fenceBuilder(ModBlocks.RAW_AZURITE_FENCE, Ingredient.of(ModItems.RAW_AZURITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite"). save(output);;
        fenceGateBuilder(ModBlocks.RAW_AZURITE_FENCE_GATE, Ingredient.of(ModItems.RAW_AZURITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite"). save(output);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_AZURITE_WALL, Ingredient.of(ModBlocks.RAW_AZURITE_BLOCK.get()))
                .unlockedBy(getHasName(ModBlocks.RAW_AZURITE_BLOCK.get()), has(ModBlocks.RAW_AZURITE_BLOCK))
                .group("raw_azurite"). save(output);
        //generateForEnabledBlockFamilies();
        doorBuilder(ModBlocks.RAW_AZURITE_DOOR, Ingredient.of(ModItems.RAW_AZURITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite"). save(output);;
        trapdoorBuilder(ModBlocks.RAW_AZURITE_TRAPDOOR, Ingredient.of(ModItems.RAW_AZURITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_AZURITE.get()), has(ModItems.RAW_AZURITE))
                .group("raw_azurite"). save(output);;

        shaped(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR.get())
                .pattern("#")
                .pattern("A")
                .pattern("A")
                .define('#', ModBlocks.AZURITE_BLOCK)
                .define('A', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .save(output);

        //Items.Item has no get(), apparently this does work tho
        shaped(RecipeCategory.FOOD, ModItems.ONION.get())
                .pattern("###")
                .pattern("#O#")
                .pattern("###").define('#', ModItems.AZURITE). define('O', Items.POISONOUS_POTATO)
                .unlockedBy(getHasName(Items.POISONOUS_POTATO), has(Items.POISONOUS_POTATO))
                .save(output);






        //doesn't work bc puts it under data.minecraft.recipe
        //nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.AZURITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK,
        //        getSimpleRecipeName(ModBlocks.AZURITE_BLOCK), TutorialMod.MODID+":"+getSimpleRecipeName(ModBlocks.AZURITE_BLOCK),
        //        getSimpleRecipeName(ModItems.AZURITE), TutorialMod.MODID+":"+getSimpleRecipeName(ModItems.AZURITE));

        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE,
                ModBlocks.AZURITE_ORE, ModBlocks.AZURITE_NETHER_ORE, ModBlocks.AZURITE_END_ORE);
        oreSmelting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 500, "azurite");
        oreBlasting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 100, "azurite");


    }

    //polymorphism calls this. mainly for tutorialMod.modid
    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TutorialMod.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }




    //class inside class
    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(registries, recipeOutput);
        }

        @Override
        public String getName() {
            return "Tutorial Mod Recipes";
        }
    }
}
