package com.squirrelbucket.daffodil.core.customBlocks;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.customBlockEntities.customBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class customBedBlock extends BedBlock {

    private final CustomDyeColors bedColor;

    public customBedBlock(CustomDyeColors color, Properties properties) {

        super(DyeColor.YELLOW, properties);

        this.bedColor = color;
    }

    public CustomDyeColors getBedColor() {
        return this.bedColor;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new customBedBlockEntity(pos, state);
    }
}
