package net.avery.averysmod.item;

import net.avery.averysmod.AverysMod;
import net.avery.averysmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SAPPHIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AverysMod.MOD_ID, "sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sapphire"))
                    .icon(() -> new ItemStack(ModItems.PURPLE_SAPPHIRE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.PURPLE_SAPPHIRE);
                        entries.add(ModItems.RAW_PURPLE_SAPPHIRE);
                        entries.add(ModItems.SAPPHIRE_DETECTOR);
                        entries.add(ModItems.SHAMAN_APPLE);

                        entries.add(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.RAW_PURPLE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.PURPLE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.END_PURPLE_SAPPHIRE_ORE);

                    }).build());

    public static void registerItemGroups() {
        AverysMod.LOGGER.info("Registering Item Groups for " + AverysMod.MOD_ID);
    }
}
