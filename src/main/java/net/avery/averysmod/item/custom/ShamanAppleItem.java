package net.avery.averysmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShamanAppleItem extends Item{
    public ShamanAppleItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
