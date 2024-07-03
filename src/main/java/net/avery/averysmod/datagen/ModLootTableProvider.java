package net.avery.averysmod.datagen;

import net.avery.averysmod.block.ModBlocks;
import net.avery.averysmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.RAW_PURPLE_SAPPHIRE_BLOCK);

        addDrop(ModBlocks.PURPLE_SAPPHIRE_ORE, sapphireOreDrops(ModBlocks.PURPLE_SAPPHIRE_ORE, ModItems.RAW_PURPLE_SAPPHIRE));
        addDrop(ModBlocks.END_PURPLE_SAPPHIRE_ORE, sapphireOreDrops(ModBlocks.END_PURPLE_SAPPHIRE_ORE, ModItems.RAW_PURPLE_SAPPHIRE));
        addDrop(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE, sapphireOreDrops(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE, ModItems.RAW_PURPLE_SAPPHIRE));
    }

    public LootTable.Builder sapphireOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
