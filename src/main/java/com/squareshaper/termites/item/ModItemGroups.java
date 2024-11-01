package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
import com.squareshaper.termites.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FUNNY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Termites.MOD_ID, "funny_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAW_FUNNY_CLUMP))
                    .displayName(Text.translatable("itemgroup.termites.funny_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FUNNY_ORE);
                        entries.add(ModItems.RAW_FUNNY_CLUMP);
                        entries.add(ModItems.FUNNY_BALLS);
                        entries.add(ModItems.FUNNY_STICK);
                        entries.add(ModItems.FUNNIFIER);
                        entries.add(ModItems.FUNNY_PICKER);
                        entries.add(ModBlocks.FUNNY_BLOCK);
                        entries.add(ModBlocks.FUNNY_SLAB);
                        entries.add(ModBlocks.FUNNY_STAIRS);
                        entries.add(ModBlocks.FUNNY_WALL);
                        entries.add(ModBlocks.FUNNY_FENCE);
                        entries.add(ModBlocks.FUNNY_FENCE_GATE);
                        entries.add(ModBlocks.FUNNY_BUTTON);
                        entries.add(ModBlocks.FUNNY_DOOR);
                        entries.add(ModBlocks.FUNNY_TRAPDOOR);
                        entries.add(ModBlocks.FUNNY_LAMP);
                        entries.add(ModBlocks.LAUGH_BLOCK);
                        entries.add(ModBlocks.TERMITE_MOUND);
                        entries.add(ModItems.CHITIN);
                        entries.add(ModItems.BURNT_CHITIN);
                        entries.add(ModItems.SCORCHING_CHITIN);
                        entries.add(ModBlocks.CHITIN_BLOCK);
                        entries.add(ModBlocks.HOT_CHITIN_BLOCK);
                        entries.add(ModBlocks.SCORCHING_CHITIN_BLOCK);
                    })
                    .build());

    public static void registerModItemGroups() {
        Termites.LOGGER.info("Registering Mod Item Groups for " + Termites.MOD_ID + "...");
    }
}
