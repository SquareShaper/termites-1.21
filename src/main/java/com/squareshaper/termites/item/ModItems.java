package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
import com.squareshaper.termites.item.custom.FunnifierItem;
import com.squareshaper.termites.item.custom.FunnyBallsItem;
import com.squareshaper.termites.item.custom.ScorchingChitinItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item CHITIN = registerItem("chitin", new Item(new Item.Settings() ) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.termites.item.chitin"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item BURNT_CHITIN = registerItem("burnt_chitin", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.termites.item.burnt_chitin"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SCORCHING_CHITIN = registerItem("scorching_chitin", new ScorchingChitinItem(new Item.Settings().fireproof()));
    public static final Item TERMITE_TREAT = registerItem("termite_treat", new Item(new Item.Settings()
            .food(ModFoodComponents.TERMITE_TREAT)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.termites.item.termite_treat"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item RAW_FUNNY_CLUMP = registerItem("raw_funny_clump", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.termites.item.raw_funny_clump"));
            tooltip.add(Text.translatable("tooltip.termites.item.raw_funny_clump_2"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item FUNNY_BALLS = registerItem("funny_balls", new FunnyBallsItem(new Item.Settings().maxCount(64)));
    public static final Item FUNNY_STICK = registerItem("funny_stick", new Item(new Item.Settings()));
    public static final Item FUNNIFIER = registerItem("funnifier", new FunnifierItem(new Item.Settings().maxDamage(320)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Termites.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Termites.LOGGER.info("Registering Mod Items for " + Termites.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.DISC_FRAGMENT_5,SCORCHING_CHITIN);
            entries.addAfter(Items.DISC_FRAGMENT_5,BURNT_CHITIN);
            entries.addAfter(Items.DISC_FRAGMENT_5,CHITIN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.COOKED_SALMON,TERMITE_TREAT);
        });
    }
}
