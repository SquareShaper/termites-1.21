package com.squareshaper.termites.block.custom;

import com.squareshaper.termites.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class LaughBlock extends Block {
    public static final int soundRepeatThreshold = 2;
    public static final IntProperty SOUND_COUNTER = IntProperty.of("sound_counter", 0, soundRepeatThreshold);

    public LaughBlock(Settings settings) {
        super(settings);
    }

    //when an entity drops on the block
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        //if it's an item
        if (entity instanceof ItemEntity item) {
            //only run on server
            if (!world.isClient()) {
                //check if it is of tag funny
                if (isValidItem(item.getStack())) {
                    world.setBlockState(pos, state.cycle(SOUND_COUNTER));
                    if (world.getBlockState(pos).get(SOUND_COUNTER) >= soundRepeatThreshold) {
                        //replace with custom laugh sound later
                        world.playSound(null, pos, SoundEvents.ENTITY_DOLPHIN_PLAY, SoundCategory.BLOCKS);
                        entity.addVelocity(0,0.3,0);
                        world.setBlockState(pos, state.with(SOUND_COUNTER, 0));
                    }
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.FUNNY_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.termites.block.laugh"));
        super.appendTooltip(stack, context, tooltip, options);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
       builder.add(SOUND_COUNTER);
    }
}
