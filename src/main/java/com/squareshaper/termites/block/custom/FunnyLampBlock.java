package com.squareshaper.termites.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FunnyLampBlock extends Block {
    public static final BooleanProperty clicked = BooleanProperty.of("clicked");
    public FunnyLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(clicked, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()){
            world.setBlockState(pos, state.cycle(clicked));
            world.playSound(player, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(clicked);
    }
}
