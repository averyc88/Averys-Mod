package net.avery.averysmod;

import net.avery.averysmod.block.ModBlocks;
import net.avery.averysmod.item.ModItemGroups;
import net.avery.averysmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AverysMod implements ModInitializer {

	public static final String MOD_ID = "averys-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}