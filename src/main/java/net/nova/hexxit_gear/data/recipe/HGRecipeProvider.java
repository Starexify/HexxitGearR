package net.nova.hexxit_gear.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

public class HGRecipeProvider extends RecipeProvider {
    protected HGRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Hexical
        oneToOneConversionRecipe(HGItems.HEXICAL_PETAL, HGBlocks.HEXBISCUS, "hexical_petal");
        shaped(RecipeCategory.MISC, HGItems.HEXICAL_DIAMOND)
                .define('#', Items.DIAMOND).define('P', HGItems.HEXICAL_PETAL)
                .pattern(" P ")
                .pattern("P#P")
                .pattern(" P ")
                .unlockedBy(getHasName(HGItems.HEXICAL_PETAL), has(HGItems.HEXICAL_PETAL))
                .save(output);

        // Scale
        shaped(RecipeCategory.COMBAT, HGItems.SCALE_HELMET)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("GOG")
                .pattern("O#O")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SCALE_CHESTGUARD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("G G")
                .pattern("O#O")
                .pattern("GOG")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SCALE_LEGGINGS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('O', Items.OBSIDIAN)
                .pattern("OOO")
                .pattern("G#G")
                .pattern("O O")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SCALE_BOOTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('O', Items.OBSIDIAN)
                .pattern("O#O")
                .pattern("O O")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);

        // Tribal
        shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_SKULL)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('B', Items.BONE)
                .define('S', Items.SKELETON_SKULL)
                .pattern("BSB")
                .pattern("B#B")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_TUNIC)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("I I")
                .pattern("L#L")
                .pattern("ILI")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_LEGGINGS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("I#I")
                .pattern("L L")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_WARBOOTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('C', Items.CHAIN)
                .define('L', Items.LEATHER)
                .pattern("C#C")
                .pattern("L L")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);

        // Thief
        shaped(RecipeCategory.COMBAT, HGItems.THIEF_HOOD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('R', Items.RED_WOOL)
                .pattern("RRR")
                .pattern("R#R")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.THIEF_TUNIC)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('R', Items.RED_WOOL)
                .define('L', Items.LEATHER)
                .pattern("R R")
                .pattern("L#L")
                .pattern(" L ")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.THIEF_TROUSERS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('S', Items.STRING)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("S#S")
                .pattern("L L")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.THIEF_TURNSHOES)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('L', Items.LEATHER)
                .pattern("L#L")
                .pattern("L L")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);

        // Sage
        shaped(RecipeCategory.COMBAT, HGItems.SAGE_HOOD)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('B', Items.BOOK)
                .define('C', Items.CYAN_WOOL)
                .pattern("CBC")
                .pattern("C#C")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SAGE_ROBE)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.CYAN_WOOL)
                .pattern("C C")
                .pattern("G#G")
                .pattern(" C ")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SAGE_PANTS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('S', Items.STRING)
                .define('C', Items.CYAN_WOOL)
                .pattern("CSC")
                .pattern("C#C")
                .pattern("C C")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
        shaped(RecipeCategory.COMBAT, HGItems.SAGE_WALKERS)
                .define('#', HGItems.HEXICAL_DIAMOND)
                .define('L', Items.LEATHER)
                .define('B', Items.BLACK_WOOL)
                .pattern("B#B")
                .pattern("L L")
                .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND), has(HGItems.HEXICAL_DIAMOND))
                .save(output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new HGRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return "Hexxit Gear R Recipes";
        }
    }
}
