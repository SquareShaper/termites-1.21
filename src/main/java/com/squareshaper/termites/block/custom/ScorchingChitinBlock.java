package com.squareshaper.termites.block.custom;

import net.minecraft.block.AirBlock;
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
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ScorchingChitinBlock extends Block {
    public ScorchingChitinBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            //burn the player when touching the block
            world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS);
            player.damage(world.getDamageSources().inFire(), 4);
        }
        return super.onUse(state, world, pos, player, hit);
    }

    //when an entity drops on the block
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        //only run on server
        if (!world.isClient()) {
            //BURN IT!
            entity.setOnFireFor(6);
            entity.damage(world.getDamageSources().onFire(), 2);
            world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    //this is supposed to light nearby blocks on fire... but it crashes xD
//    @Override
//    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if(world.getBlockState(neighborPos.up()).getBlock() instanceof AirBlock) {
//            world.setBlockState(neighborPos.up(), new BlockState(new AirBlock(Settings.create()), null, null), 0);
//        }
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }
}
