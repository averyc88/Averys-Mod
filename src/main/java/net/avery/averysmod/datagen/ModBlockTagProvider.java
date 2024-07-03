package net.avery.averysmod.datagen;

import net.avery.averysmod.block.ModBlocks;
import net.avery.averysmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.SAPPHIRE_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.END_PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.END_PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.PURPLE_SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_PURPLE_SAPPHIRE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_PURPLE_SAPPHIRE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.END_PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.PURPLE_SAPPHIRE_ORE)
                .add(ModBlocks.PURPLE_SAPPHIRE_BLOCK);

        // create custom tag
//        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
//                .add(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
    }
}
