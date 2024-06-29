package net.avery.averysmod.item.custom;

import net.avery.averysmod.block.ModBlocks;
import net.avery.averysmod.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.logging.Logger;

public class SapphireDetectorItem extends Item {
    public SapphireDetectorItem(Settings settings) {
        super(settings);
    }

     @Override
     public ActionResult useOnBlock(ItemUsageContext context) {
         if (!context.getWorld().isClient()) {
             BlockPos positionClicked = context.getBlockPos();
             PlayerEntity player = context.getPlayer();
             boolean foundBlock = false;

             for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                 BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                 if (isValuableBlock(state)) {
                     player.sendMessage(Text.literal("Sapphire Found."));
                     foundBlock = true;

                     break;
                 }
             }

             if (!foundBlock) {
                 player.sendMessage(Text.literal("No Valuables Found."));
             }
         }

         return ActionResult.SUCCESS;

     }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(ModBlocks.DEEPSLATE_PURPLE_SAPPHIRE_ORE) ||
                state.isOf(ModBlocks.PURPLE_SAPPHIRE_ORE) ||
                state.isOf(ModBlocks.END_PURPLE_SAPPHIRE_ORE);
//        return state.isIn(ModTags.Blocks.SAPPHIRE_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.averys-mod.sapphire_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

