package com.squirrelbucket.daffodil.core.plum;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import com.squirrelbucket.daffodil.customBlockEntities.PlumHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PlumCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public PlumCeilingHangingSignBlock(BlockBehaviour.Properties properties, WoodType woodType) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos position, BlockState state) {
        return new PlumHangingSignBlockEntity(position, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.PLUM_HANGING_SIGN.get(), SignBlockEntity::tick);
    }
}
