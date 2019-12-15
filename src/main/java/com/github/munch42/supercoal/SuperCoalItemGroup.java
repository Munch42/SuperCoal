package com.github.munch42.supercoal;

import com.github.munch42.supercoal.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SuperCoalItemGroup extends ItemGroup {
    public SuperCoalItemGroup(){
        super("supercoal");
    }

    @Override
    public ItemStack createIcon() {
        // For Block: Item.BLOCK_TO_ITEM.get(BlockList.super_coal_ore)
        return new ItemStack(ItemList.super_coal);
    }
}
