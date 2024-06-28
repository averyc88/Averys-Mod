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
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AverysMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModItems.PURPLE_SAPPHIRE);
                        entries.add(ModItems.RAW_PURPLE_SAPPHIRE);
                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.RAW_PURPLE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.PURPLE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.END_PURPLE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_RUBY_ORE);

                    }).build());

    public static void registerItemGroups() {
        AverysMod.LOGGER.info("Registering Item Groups for " + AverysMod.MOD_ID);
    }
}
