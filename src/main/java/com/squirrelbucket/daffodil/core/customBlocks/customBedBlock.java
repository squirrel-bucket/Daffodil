package com.squirrelbucket.daffodil.core.customBlocks;

import com.squirrelbucket.daffodil.customBlockEntities.customBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class customBedBlock extends BedBlock {
    // 1. Change the type from DyeColor to StringRepresentable
    private final StringRepresentable bedColor;

    public customBedBlock(StringRepresentable color, Properties properties) {

        super(color instanceof DyeColor vanillaColor ? vanillaColor : DyeColor.BLACK, properties);
        this.bedColor = color;
    }

    public StringRepresentable getBedColor() {
        return this.bedColor;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new customBedBlockEntity(pos, state);
    }
}