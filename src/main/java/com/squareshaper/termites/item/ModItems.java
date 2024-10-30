package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHITIN = registerItem("chitin", new Item(new Item.Settings()));
    public static final Item TERMITE_TREAT = registerItem("termite_treat", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Termites.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Termites.LOGGER.info("Registering Mod Items for " + Termites.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CHITIN);
            entries.add(TERMITE_TREAT);
        });
    }
}
