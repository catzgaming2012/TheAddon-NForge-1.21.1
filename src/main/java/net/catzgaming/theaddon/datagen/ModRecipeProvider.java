package net.catzgaming.theaddon.datagen;

import net.catzgaming.theaddon.TheAddon;
import net.catzgaming.theaddon.block.ModBlocks;
import net.catzgaming.theaddon.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> STRANGEINGOT_SMELTABLE = List.of(ModItems.STRANGECLUMP,
                 ModBlocks.STRANGE_ORE, ModBlocks.DEEPSLATE_STRANGE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRANGE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STRANGEINGOT.get())
                .unlockedBy("has_strangeingot", has(ModItems.STRANGEINGOT))
                .save(recipeOutput, "theaddonlol:strange_ingot_to_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRANGED_APPLE.get())
                .pattern("###")
                .pattern(" A ")
                .pattern("   ")
                .define('#', ModItems.STRANGEINGOT.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_strangeingot", has(ModItems.STRANGEINGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STRANGE_COAL.get())
                .pattern(" # ")
                .pattern("#C#")
                .pattern(" # ")
                .define('#', ModItems.STRANGEINGOT.get())
                .define('C', Items.COAL)
                .unlockedBy("has_strangeingot", has(ModItems.STRANGEINGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRANGEINGOT.get(), 9)
                .requires(ModBlocks.STRANGE_BLOCK)
                .unlockedBy("has_strangeblock", has(ModItems.STRANGEINGOT))
                .save(recipeOutput, "theaddonlol:strange_block_to_ingot");

        oreSmelting(recipeOutput, STRANGEINGOT_SMELTABLE, RecipeCategory.MISC, ModItems.STRANGEINGOT.get(), 0.3f, 200, "strangeore");
        oreBlasting(recipeOutput, STRANGEINGOT_SMELTABLE, RecipeCategory.MISC, ModItems.STRANGEINGOT.get(), 0.35f, 100, "strangeore");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TheAddon.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
