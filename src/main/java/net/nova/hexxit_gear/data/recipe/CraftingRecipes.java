package net.nova.hexxit_gear.data.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.function.Consumer;

public class CraftingRecipes extends HGRecipeProvider {
    public final Consumer<FinishedRecipe> recipeOutput;

    public CraftingRecipes(PackOutput output, Consumer<FinishedRecipe> recipeOutput) {
        super(output);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        // Hexical
        oneToOneConversionRecipe(recipeOutput, HGItems.HEXICAL_PETAL.get(), HGBlocks.HEXBISCUS.get(), "hexical_petal");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HGItems.HEXICAL_DIAMOND.get())
                .define('#', Items.DIAMOND).define('P', HGItems.HEXICAL_PETAL.get())
                .pattern(" P ")
                .pattern("P#P")
                .pattern(" P ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_PETAL.get()), has(HGItems.HEXICAL_PETAL.get()))
                .save(recipeOutput);

        // Scale
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_HELMET.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("GOG")
                .pattern("O#O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_CHESTGUARD.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("G G")
                .pattern("O#O")
                .pattern("GOG")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_LEGGINGS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("OOO")
                .pattern("G#G")
                .pattern("O O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SCALE_BOOTS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('O', Items.OBSIDIAN)
                .pattern("O#O")
                .pattern("O O")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);

        // Tribal
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_SKULL.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('B', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .pattern("BSB")
                .pattern("B#B")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_TUNIC.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("I I")
                .pattern("L#L")
                .pattern("ILI")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_LEGGINGS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("I#I")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_WARBOOTS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('C', Items.CHAIN)
                .define('L', Items.LEATHER)
                .pattern("C#C")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);

        // Thief
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_HOOD.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('R', Items.RED_WOOL)
                .pattern("RRR")
                .pattern("R#R")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TUNIC.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('R', Items.RED_WOOL)
                .define('L', Items.LEATHER)
                .pattern("R R")
                .pattern("L#L")
                .pattern(" L ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TROUSERS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('S', Items.STRING)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("S#S")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.THIEF_TURNSHOES.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('L', Items.LEATHER)
                .pattern("L#L")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);

        // Sage
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_HOOD.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('B', Items.BOOK)
                .define('C', Items.CYAN_WOOL)
                .pattern("CBC")
                .pattern("C#C")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_ROBE.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.CYAN_WOOL)
                .pattern("C C")
                .pattern("G#G")
                .pattern(" C ")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_PANTS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('S', Items.STRING)
                .define('C', Items.CYAN_WOOL)
                .pattern("CSC")
                .pattern("C#C")
                .pattern("C C")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HGItems.SAGE_WALKERS.get())
                .define('#', HGItems.HEXICAL_DIAMOND.get())
                .define('L', Items.LEATHER)
                .define('B', Items.BLACK_WOOL)
                .pattern("B#B")
                .pattern("L L")
                .unlockedBy("has_" + getItemName(HGItems.HEXICAL_DIAMOND.get()), has(HGItems.HEXICAL_DIAMOND.get()))
                .save(recipeOutput);
    }
}
