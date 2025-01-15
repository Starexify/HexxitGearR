package net.nova.hexxit_gear.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGRecipeProvider extends RecipeProvider {
    public final PackOutput output;
    public final CompletableFuture<HolderLookup.Provider> lookupProvider;
    public static String path = MODID + ":";

    public HGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
        this.output = output;
        this.lookupProvider = lookupProvider;
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        new CraftingRecipes(output, lookupProvider, recipeOutput).build();
    }

    // Recipes
    protected static void oneToOneConversionRecipe(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient, @Nullable String pGroup) {
        oneToOneConversionRecipe(pRecipeOutput, pResult, pIngredient, pGroup, 1);
    }

    protected static void oneToOneConversionRecipe(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient, @Nullable String pGroup, int pResultCount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, pResultCount)
                .requires(pIngredient)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput, getConversionRecipeName(pResult, pIngredient));
    }

    protected static String getConversionRecipeName(ItemLike pResult, ItemLike pIngredient) {
        return path + getItemName(pResult) + "_from_" + getItemName(pIngredient);
    }
}
