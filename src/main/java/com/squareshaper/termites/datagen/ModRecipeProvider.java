package com.squareshaper.termites.datagen;

import com.squareshaper.termites.Termites;
import com.squareshaper.termites.block.ModBlocks;
import com.squareshaper.termites.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> RAW_FUNNY_CLUMP_SMELTABLES = List.of(ModBlocks.FUNNY_ORE);
        List<ItemConvertible> BURNT_CHITIN_SMELTABLES = List.of(ModItems.CHITIN);
        List<ItemConvertible> SCORCHING_CHITIN_SMELTABLES = List.of(ModItems.BURNT_CHITIN);

        offerSmelting(recipeExporter, RAW_FUNNY_CLUMP_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_FUNNY_CLUMP, 1, 200, "funny");
        offerSmelting(recipeExporter, BURNT_CHITIN_SMELTABLES, RecipeCategory.MISC, ModItems.BURNT_CHITIN, 1, 200, "chitin");
        offerSmelting(recipeExporter, SCORCHING_CHITIN_SMELTABLES, RecipeCategory.MISC, ModItems.SCORCHING_CHITIN, 1, 1600, "chitin");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.CHITIN, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHITIN_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.BURNT_CHITIN, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HOT_CHITIN_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.SCORCHING_CHITIN, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCORCHING_CHITIN_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.FUNNY_BALLS, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FUNNIFIER)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .input('#', ModItems.FUNNY_STICK)
                .input('X', ModItems.CHITIN)
                .criterion(hasItem(ModItems.FUNNY_STICK), conditionsFromItem(ModItems.FUNNY_STICK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FUNNY_BALLS)
                .input(ModItems.RAW_FUNNY_CLUMP)
                .criterion(hasItem(ModItems.RAW_FUNNY_CLUMP), conditionsFromItem(ModItems.RAW_FUNNY_CLUMP))
                .offerTo(recipeExporter, Identifier.of(Termites.MOD_ID, "funny_balls_from_clumps"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FUNNY_STICK, 4)
                .pattern("#")
                .pattern("#")
                .input('#', ModItems.FUNNY_BALLS)
                .criterion(hasItem(ModItems.FUNNY_BALLS), conditionsFromItem(ModItems.FUNNY_BALLS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LAUGH_BLOCK)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', ModItems.FUNNY_BALLS)
                .input('X', Items.SLIME_BALL)
                .criterion(hasItem(ModItems.FUNNY_BALLS), conditionsFromItem(ModItems.FUNNY_BALLS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LAUGH_BLOCK)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', ModItems.FUNNY_BALLS)
                .input('X', Items.SLIME_BLOCK)
                .criterion(hasItem(ModItems.FUNNY_BALLS), conditionsFromItem(ModItems.FUNNY_BALLS))
                .offerTo(recipeExporter, Identifier.of(Termites.MOD_ID, "laugh_block_from_slime_block"));

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_SLAB, ModBlocks.FUNNY_BLOCK);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.FUNNY_PRESSURE_PLATE, ModBlocks.FUNNY_BLOCK);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_WALL,ModBlocks.FUNNY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FUNNY_DOOR, 4)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.FUNNY_BLOCK)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FUNNY_TRAPDOOR, 2)
                .pattern("###")
                .pattern("#X#")
                .input('#', ModBlocks.FUNNY_BLOCK)
                .input('X', ModItems.FUNNY_BALLS)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_FENCE, 3)
                .pattern("#X#")
                .pattern("#X#")
                .input('#', ModBlocks.FUNNY_BLOCK)
                .input('X', ModItems.FUNNY_STICK)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_FENCE_GATE, 1)
                .pattern("#X#")
                .pattern("#X#")
                .input('X', ModBlocks.FUNNY_BLOCK)
                .input('#', ModItems.FUNNY_STICK)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FUNNY_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.FUNNY_BLOCK)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FUNNY_BUTTON)
                .input(ModBlocks.FUNNY_BLOCK)
                .criterion(hasItem(ModBlocks.FUNNY_BLOCK), conditionsFromItem(ModBlocks.FUNNY_BLOCK))
                .offerTo(recipeExporter);
    }
}
