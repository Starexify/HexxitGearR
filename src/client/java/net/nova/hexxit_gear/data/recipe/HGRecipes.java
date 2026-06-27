package net.nova.hexxit_gear.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

public class HGRecipes extends RecipeProvider {
  protected HGRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
    super(provider, recipeOutput);
  }

  @Override
  public void buildRecipes() {
    // Hexical
    oneToOneConversionRecipe(HGItems.HEXICAL_PETAL.getFirst().value(), HGBlocks.HEXBISCUS.getFirst().value(), "hexical_petal");
    shaped(RecipeCategory.MISC, HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('#', Items.DIAMOND).define('P', HGItems.HEXICAL_PETAL.getFirst().value())
        .pattern(" P ")
        .pattern("P#P")
        .pattern(" P ")
        .unlockedBy(getHasName(HGItems.HEXICAL_PETAL.getFirst().value()), has(HGItems.HEXICAL_PETAL.getFirst().value()))
        .save(output);

    // Scale
    shaped(RecipeCategory.COMBAT, HGItems.SCALE_HELMET.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('G', Items.GOLD_INGOT)
        .define('O', Items.OBSIDIAN)
        .pattern("GOG")
        .pattern("O#O")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SCALE_CHESTGUARD.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('G', Items.GOLD_INGOT)
        .define('O', Items.OBSIDIAN)
        .pattern("G G")
        .pattern("O#O")
        .pattern("GOG")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SCALE_LEGGINGS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('G', Items.GOLD_INGOT)
        .define('O', Items.OBSIDIAN)
        .pattern("OOO")
        .pattern("G#G")
        .pattern("O O")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SCALE_BOOTS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('O', Items.OBSIDIAN)
        .pattern("O#O")
        .pattern("O O")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);

    // Tribal
    shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_SKULL.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('B', Items.BONE)
        .define('S', Items.SKELETON_SKULL)
        .pattern("BSB")
        .pattern("B#B")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_TUNIC.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('I', Items.IRON_INGOT)
        .define('L', Items.LEATHER)
        .pattern("I I")
        .pattern("L#L")
        .pattern("ILI")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_LEGGINGS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('I', Items.IRON_INGOT)
        .define('L', Items.LEATHER)
        .pattern("LLL")
        .pattern("I#I")
        .pattern("L L")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.TRIBAL_WARBOOTS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('C', Blocks.IRON_CHAIN)
        .define('L', Items.LEATHER)
        .pattern("C#C")
        .pattern("L L")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);

    // Thief
    shaped(RecipeCategory.COMBAT, HGItems.THIEF_HOOD.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('R', Items.WOOL.red())
        .pattern("RRR")
        .pattern("R#R")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.THIEF_TUNIC.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('R', Items.WOOL.red())
        .define('L', Items.LEATHER)
        .pattern("R R")
        .pattern("L#L")
        .pattern(" L ")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.THIEF_TROUSERS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('S', Items.STRING)
        .define('L', Items.LEATHER)
        .pattern("LLL")
        .pattern("S#S")
        .pattern("L L")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.THIEF_TURNSHOES.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('L', Items.LEATHER)
        .pattern("L#L")
        .pattern("L L")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);

    // Sage
    shaped(RecipeCategory.COMBAT, HGItems.SAGE_HOOD.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('B', Items.BOOK)
        .define('C', Items.WOOL.cyan())
        .pattern("CBC")
        .pattern("C#C")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SAGE_ROBE.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('G', Items.GOLD_INGOT)
        .define('C', Items.WOOL.cyan())
        .pattern("C C")
        .pattern("G#G")
        .pattern(" C ")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SAGE_PANTS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('S', Items.STRING)
        .define('C', Items.WOOL.cyan())
        .pattern("CSC")
        .pattern("C#C")
        .pattern("C C")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
    shaped(RecipeCategory.COMBAT, HGItems.SAGE_WALKERS.getFirst().value())
        .define('#', HGItems.HEXICAL_DIAMOND.getFirst().value())
        .define('L', Items.LEATHER)
        .define('B', Items.WOOL.black())
        .pattern("B#B")
        .pattern("L L")
        .unlockedBy(getHasName(HGItems.HEXICAL_DIAMOND.getFirst().value()), has(HGItems.HEXICAL_DIAMOND.getFirst().value()))
        .save(output);
  }
}
