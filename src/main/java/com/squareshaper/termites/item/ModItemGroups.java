package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FUNNY_STICK))
                    .displayName(Text.translatable("itemgroup.termites.funny_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FUNNY_STICK);
                    })
                    .build());

    public static void registerModItemGroups() {
        Termites.LOGGER.info("Registering Mod Item Groups for " + Termites.MOD_ID + "...");
    }
}
