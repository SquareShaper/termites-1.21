package com.squareshaper.termites;

import com.squareshaper.termites.block.ModBlocks;
import com.squareshaper.termites.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Termites implements ModInitializer {
	public static final String MOD_ID = "termites";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}