package net.avery.averysmod.datagen;

import net.avery.averysmod.block.ModBlocks;
import net.avery.averysmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_PURPLE_SAPPHIRE,
            ModItems.PURPLE_SAPPHIRE, ModBlocks.PURPLE_SAPPHIRE_ORE, ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE, ModBlocks.END_PURPLE_SAPPHIRE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.PURPLE_SAPPHIRE,
                1.1f, 200, "purple_sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.PURPLE_SAPPHIRE,
                1.1f, 100, "purple_sapphire");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.PURPLE_SAPPHIRE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHAMAN_APPLE, 1)
                .pattern(" # ")
                .pattern("#a#")
                .pattern(" # ")
                .input('#', ModItems.PURPLE_SAPPHIRE)
                .input('a', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(ModItems.PURPLE_SAPPHIRE), conditionsFromItem(ModItems.PURPLE_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SHAMAN_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAPPHIRE_DETECTOR, 1)
                .pattern("  i")
                .pattern(" pr")
                .pattern("ws ")
                .input('p', ModItems.PURPLE_SAPPHIRE)
                .input('i', Items.IRON_INGOT)
                .input('r', Items.REDSTONE)
                .input('w', Items.STICK)
                .input('s', Items.STRING)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(ModItems.PURPLE_SAPPHIRE), conditionsFromItem(ModItems.PURPLE_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SAPPHIRE_DETECTOR)));
    }
}
