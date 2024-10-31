package com.squareshaper.termites;

import com.squareshaper.termites.block.ModBlocks;
import com.squareshaper.termites.item.ModFoodComponents;
import com.squareshaper.termites.item.ModItemGroups;
import com.squareshaper.termites.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Termites implements ModInitializer {
	public static final String MOD_ID = "termites";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModFoodComponents.registerModFoodComponents();

		//Register Scorching chitin as a fuel type - 4x as effective as coal, but costs 1 whole coal to smelt from chitin
		FuelRegistry.INSTANCE.add(ModItems.SCORCHING_CHITIN, 6400);
	}
}