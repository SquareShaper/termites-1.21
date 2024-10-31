package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
import com.squareshaper.termites.item.custom.FunnifierItem;
import com.squareshaper.termites.item.custom.FunnyBallsItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHITIN = registerItem("chitin", new Item(new Item.Settings()));
    public static final Item BURNT_CHITIN = registerItem("burnt_chitin", new Item(new Item.Settings()));
    public static final Item TERMITE_TREAT = registerItem("termite_treat", new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(4).saturationModifier(4)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 0), 1f).build())));

    public static final Item RAW_FUNNY_CLUMP = registerItem("raw_funny_clump", new Item(new Item.Settings()));
    public static final Item FUNNY_BALLS = registerItem("funny_balls", new FunnyBallsItem(new Item.Settings().maxCount(64)));
    public static final Item FUNNY_STICK = registerItem("funny_stick", new Item(new Item.Settings()));
    public static final Item FUNNIFIER = registerItem("funnifier", new FunnifierItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Termites.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Termites.LOGGER.info("Registering Mod Items for " + Termites.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CHITIN);
            entries.add(BURNT_CHITIN);
            entries.add(TERMITE_TREAT);
        });
    }
}
