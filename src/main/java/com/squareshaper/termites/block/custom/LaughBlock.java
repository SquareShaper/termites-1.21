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
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class LaughBlock extends Block {
    private final int soundRepeatThreshold = 2;
    private int soundCounter = 0;

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
                    this.soundCounter++;
                    if (this.soundCounter >= this.soundRepeatThreshold) {
                        //replace with custom laugh sound later
                        world.playSound(null, pos, SoundEvents.ENTITY_DOLPHIN_PLAY, SoundCategory.BLOCKS);
                        entity.addVelocity(0,0.3,0);
                        this.soundCounter = 0;
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
}
