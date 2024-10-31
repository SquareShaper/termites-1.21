package com.squareshaper.termites.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ScorchingChitinBlockItem extends BlockItem {
    public ScorchingChitinBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(selected) {
            entity.damage(world.getDamageSources().inFire(), 2);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
