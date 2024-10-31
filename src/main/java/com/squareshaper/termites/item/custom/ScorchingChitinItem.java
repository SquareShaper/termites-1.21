package com.squareshaper.termites.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ScorchingChitinItem extends Item {
    public ScorchingChitinItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(selected) {
            entity.damage(world.getDamageSources().inFire(), 1);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
