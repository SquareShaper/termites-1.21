package com.squareshaper.termites.util;

import com.squareshaper.termites.Termites;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Termites.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> FUNNY_ITEMS = createTag("funny_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Termites.MOD_ID, name));
        }
    }
}
