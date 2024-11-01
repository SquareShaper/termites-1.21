package com.squareshaper.termites.datagen;

import com.squareshaper.termites.block.ModBlocks;
import com.squareshaper.termites.item.ModItems;
import com.squareshaper.termites.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.FUNNY_ITEMS)
                .add(ModItems.RAW_FUNNY_CLUMP)
                .add(ModItems.FUNNY_BALLS)
                .add(ModItems.FUNNY_STICK)
                .add(ModItems.FUNNIFIER)
                .add(ModBlocks.FUNNY_ORE.asItem())
                .add(ModBlocks.LAUGH_BLOCK.asItem())
                .add(ModBlocks.FUNNY_BLOCK.asItem())
                .add(ModBlocks.FUNNY_BUTTON.asItem())
                .add(ModBlocks.FUNNY_PRESSURE_PLATE.asItem())
                .add(ModBlocks.FUNNY_DOOR.asItem())
                .add(ModBlocks.FUNNY_TRAPDOOR.asItem())
                .add(ModBlocks.FUNNY_SLAB.asItem())
                .add(ModBlocks.FUNNY_STAIRS.asItem())
                .add(ModBlocks.FUNNY_FENCE.asItem())
                .add(ModBlocks.FUNNY_FENCE_GATE.asItem())
                .add(ModBlocks.FUNNY_WALL.asItem());
    }
}
