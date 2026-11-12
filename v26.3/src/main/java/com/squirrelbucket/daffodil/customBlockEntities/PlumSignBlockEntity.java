package com.squirrelbucket.daffodil.customBlockEntities;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlumSignBlockEntity extends SignBlockEntity {
    public PlumSignBlockEntity(BlockPos position, BlockState state) { super(position, state); }
    @Override public net.minecraft.world.level.block.entity.BlockEntityType<?> getType() { return ModBlockEntities.PLUM_SIGN.get(); }
}