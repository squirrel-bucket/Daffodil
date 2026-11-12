package com.squirrelbucket.daffodil.core.plum;

import com.squirrelbucket.daffodil.worldgen.tree.PlumTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PlumSaplingBlock extends SaplingBlock {
    public PlumSaplingBlock(BlockBehaviour.Properties properties) {
        super(new PlumTreeGrower(), properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(Blocks.MOSS_BLOCK) || super.mayPlaceOn(state, level, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos)
                || level.getBlockState(pos.below()).is(Blocks.MOSS_BLOCK);
    }
}
