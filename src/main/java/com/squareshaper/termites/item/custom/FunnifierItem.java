package com.squareshaper.termites.item.custom;

import com.squareshaper.termites.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FunnifierItem extends Item {
    public FunnifierItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        if (!world.isClient()) {
            if (user.isSneaking()) {
                entity.addVelocity(0, 1, 0);
                entity.damage(world.getDamageSources().cramming(), 69420);
            } else {
                entity.noClip = true;
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (!world.isClient()) {
            world.setBlockState(context.getBlockPos(), ModBlocks.FUNNY_ORE.getDefaultState());
        }

        return super.useOnBlock(context);
    }
}
