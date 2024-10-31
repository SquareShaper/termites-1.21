package com.squareshaper.termites.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HotChitinBlock extends Block {
    public HotChitinBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            //burn the player when touching the block
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS);
            player.damage(world.getDamageSources().inFire(), 1);
        }
        return super.onUse(state, world, pos, player, hit);
    }

    //when an entity drops on the block
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        //if it's an item
        if (entity instanceof ItemEntity item) {
            //only run on server
            if (!world.isClient()) {
                RecipeManager recipeManager = world.getRecipeManager();
                //make a recipe input of the item in the itemstack that landed on the block
                SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(new ItemStack((item.getStack().getItem())));
                //check if it is smeltable
                if (recipeManager.getFirstMatch(RecipeType.SMELTING, recipeInput, world).isPresent()) {
                    // It needs a WrapperLookup, so I just gave it a null - probably not up to code, but... it works? this gets the result of smelting the item that landed on the block
                    Item cookedItem = recipeManager.getFirstMatch(RecipeType.SMELTING, recipeInput, world).get().value().getResult(null).getItem();
                    //create a new itemstack
                    ItemStack cookedItemStack = new ItemStack(cookedItem, ((ItemEntity) entity).getStack().getCount());
                    //then replace the itemstack of the itementity, to smoothly "smelt" the item in place
                    ((ItemEntity) entity).setStack(cookedItemStack);
                    //also, woooosh sound
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS);
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
