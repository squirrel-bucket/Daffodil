package com.squirrelbucket.daffodil.core.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class HibiscusFlowerBlock extends FlowerBlock {
    public HibiscusFlowerBlock(Holder<MobEffect> effect, float duration, BlockBehaviour.Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(Blocks.MOSS_BLOCK) || super.mayPlaceOn(state, level, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getFluidState(pos).isEmpty()
                && (super.canSurvive(state, level, pos)
                || level.getBlockState(pos.below()).is(Blocks.MOSS_BLOCK));
    }
}
