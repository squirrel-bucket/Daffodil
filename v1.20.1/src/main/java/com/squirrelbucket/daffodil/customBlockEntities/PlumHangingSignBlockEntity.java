package com.squirrelbucket.daffodil.customBlockEntities;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlumHangingSignBlockEntity extends HangingSignBlockEntity {
    public PlumHangingSignBlockEntity(BlockPos position, BlockState state) {
        super(ModBlockEntities.PLUM_HANGING_SIGN.get(), position, state);
    }
}
