package net.avery.averysmod.item.custom;

import net.avery.averysmod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

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
    }
}

