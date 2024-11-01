package com.squareshaper.termites.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class ScorchingChitinBlockItem extends BlockItem {
    public ScorchingChitinBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected) {
            entity.damage(world.getDamageSources().inFire(), 2);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin"));
        tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_2"));
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_shift_down"));
        }
        else {
            tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_shift"));}
        if (Screen.hasAltDown()) {
            tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_alt_down"));
        }
        else {
            tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_alt"));}
        if (Screen.hasControlDown()) {
            tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_ctrl_down"));
        }
        else {
        tooltip.add(Text.translatable("tooltip.termites.block.scorching_chitin_ctrl"));}
        super.appendTooltip(stack, context, tooltip, options);
    }
}
