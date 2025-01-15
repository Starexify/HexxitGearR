package net.nova.hexxit_gear.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

public class CraftingRecipes extends HGRecipeProvider {
    public final RecipeOutput recipeOutput;

    public CraftingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput recipeOutput) {
        super(output, lookupProvider);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Hexical
        oneToOneConversionRecipe(recipeOutput, HGItems.HEXICAL_PETAL, HGBlocks.HEXBISCUS, "hexical_petal");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HGItems.HEXICAL_DIAMOND)
                .define('#', Items.DIAMOND).define('P', HGItems.HEXICAL_PETAL)
                .pattern(" P ")
                .pattern("P#P")
                .pattern(" P ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_PETAL), has(HGItems.HEXICAL_PETAL))
                .save(recipeOutput);

        // Scale
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_HELMET)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("GOG")
                .pattern("O#O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_CHESTGUARD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("G G")
                .pattern("O#O")
                .pattern("GOG")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_LEGGINGS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("OOO")
                .pattern("G#G")
                .pattern("O O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_BOOTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('O', Items.OBSIDIAN)
                .pattern("O#O")
                .pattern("O O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);

        // Tribal
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_SKULL)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('B', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .pattern("BSB")
                .pattern("B#B")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_TUNIC)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("I I")
                .pattern("L#L")
                .pattern("ILI")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_LEGGINGS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("I#I")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_WARBOOTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('C', Items.CHAIN)
                .define('L', Items.LEATHER)
                .pattern("C#C")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);

        // Thief
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_HOOD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('R', Items.RED_WOOL)
                .pattern("RRR")
                .pattern("R#R")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TUNIC)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('R', Items.RED_WOOL)
                .define('L', Items.LEATHER)
                .pattern("R R")
                .pattern("L#L")
                .pattern(" L ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TROUSERS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('S', Items.STRING)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("S#S")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TURNSHOES)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('L', Items.LEATHER)
                .pattern("L#L")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);

        // Sage
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_HOOD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('B', Items.BOOK)
                .define('C', Items.CYAN_WOOL)
                .pattern("CBC")
                .pattern("C#C")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_ROBE)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.CYAN_WOOL)
                .pattern("C C")
                .pattern("G#G")
                .pattern(" C ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_PANTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('S', Items.STRING)
                .define('C', Items.CYAN_WOOL)
                .pattern("CSC")
                .pattern("C#C")
                .pattern("C C")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_WALKERS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('L', Items.LEATHER)
                .define('B', Items.BLACK_WOOL)
                .pattern("B#B")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(recipeOutput);
    }
}
