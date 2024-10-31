package com.squareshaper.termites.block;

import com.squareshaper.termites.Termites;
import com.squareshaper.termites.block.custom.HotChitinBlock;
import com.squareshaper.termites.block.custom.ScorchingChitinBlock;
import com.squareshaper.termites.item.custom.ScorchingChitinBlockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block CHITIN_BLOCK = registerBlock("chitin_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.BASALT).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final Block HOT_CHITIN_BLOCK = registerBlock("hot_chitin_block",
            new HotChitinBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.BASALT).instrument(NoteBlockInstrument.BASEDRUM)));

    //needs to be changed, to use the custom block item
    public static final Block SCORCHING_CHITIN_BLOCK = registerBlock("scorching_chitin_block",
            new ScorchingChitinBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.BASALT).instrument(NoteBlockInstrument.BASEDRUM)));

    //have to do it manually here, since it uses a special block item class
//    public static final Block SCORCHING_CHITIN_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(Termites.MOD_ID, "schorching_chitin_block"), new ScorchingChitinBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
//                    .sounds(BlockSoundGroup.BASALT).instrument(NoteBlockInstrument.BASEDRUM)));
//    public static final Item SCHORCHING_CHITIN_BLOCK = Registry.register(Registries.ITEM, Identifier.of(Termites.MOD_ID, "schorching_chitin_block"),
//            new ScorchingChitinBlockItem(new ScorchingChitinBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F).sounds(BlockSoundGroup.BASALT).instrument(NoteBlockInstrument.BASEDRUM)), new Item.Settings()));

    public static final Block TERMITE_MOUND = registerBlock("termite_mound",
            new Block(AbstractBlock.Settings.create().strength(4.0F, 5.0F)
                    .requiresTool().sounds(BlockSoundGroup.CORAL)));

    public static final Block FUNNY_ORE = registerBlock("funny_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Termites.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Termites.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Termites.LOGGER.info("Registering Mod Blocks for " + Termites.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CHITIN_BLOCK);
            entries.add(HOT_CHITIN_BLOCK);
            entries.add(SCORCHING_CHITIN_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(TERMITE_MOUND);
        });
    }
}
