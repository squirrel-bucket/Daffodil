package com.squirrelbucket.daffodil.customBlockEntities;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class customBannerBlockEntity extends BannerBlockEntity {
    public customBannerBlockEntity(BlockPos pos, BlockState state) { super(pos, state); }
    @Override public BlockEntityType<?> getType() { return ModBlockEntities.CUSTOM_BANNER.get(); }
}