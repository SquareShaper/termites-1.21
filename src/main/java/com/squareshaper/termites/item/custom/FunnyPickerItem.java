package com.squareshaper.termites.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FunnyPickerItem extends Item {
    public FunnyPickerItem(Settings settings) {
        super(settings);
    }


    // Make it save the block state and remove the block at pos, then when you click and theres something stored, place it back down -- do the same with entities
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if (!world.isClient()) {

        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.termites.item.funny_picker"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
