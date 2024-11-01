package com.squareshaper.termites.datagen;

import com.squareshaper.termites.block.ModBlocks;
import com.squareshaper.termites.block.custom.FunnyLampBlock;
import com.squareshaper.termites.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHITIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HOT_CHITIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCORCHING_CHITIN_BLOCK);

        blockStateModelGenerator.registerSingleton(ModBlocks.FUNNY_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.LAUGH_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.TERMITE_MOUND, TexturedModel.CUBE_COLUMN);

        BlockStateModelGenerator.BlockTexturePool funnyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FUNNY_BLOCK);

        funnyPool.stairs(ModBlocks.FUNNY_STAIRS);
        funnyPool.slab(ModBlocks.FUNNY_SLAB);

        funnyPool.button(ModBlocks.FUNNY_BUTTON);
        funnyPool.pressurePlate(ModBlocks.FUNNY_PRESSURE_PLATE);

        funnyPool.fence(ModBlocks.FUNNY_FENCE);
        funnyPool.fenceGate(ModBlocks.FUNNY_FENCE_GATE);
        funnyPool.wall(ModBlocks.FUNNY_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.FUNNY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.FUNNY_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.FUNNY_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.FUNNY_LAMP, "_active", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FUNNY_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(FunnyLampBlock.clicked, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_FUNNY_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUNNY_BALLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUNNY_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHITIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNT_CHITIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCORCHING_CHITIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TERMITE_TREAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUNNIFIER, Models.HANDHELD);
    }
}
