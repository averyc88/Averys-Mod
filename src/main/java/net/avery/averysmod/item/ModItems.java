package net.avery.averysmod.item;

import net.avery.averysmod.AverysMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item PURPLE_SAPPHIRE = registerItem("purple_sapphire", new Item(new FabricItemSettings()));
    public static final Item RAW_PURPLE_SAPPHIRE = registerItem("raw_purple_sapphire", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(PURPLE_SAPPHIRE);
        entries.add(RAW_PURPLE_SAPPHIRE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AverysMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AverysMod.LOGGER.info("Registering Mod Items for " + AverysMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}