package com.squareshaper.termites.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

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
            if (!entity.isOnFire()) {
                entity.setOnFireFor(0.5f);
                //only actually play the sound when the entity is set on fire
                world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS);
            }
            //also do damage
            entity.damage(world.getDamageSources().onFire(), 2);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    //this is supposed to light nearby blocks on fire...
    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            world.playSound(null, pos, SoundEvents.BLOCK_BELL_RESONATE, SoundCategory.BLOCKS);
        }
        super.randomTick(state, world, pos, random);
    }
}
