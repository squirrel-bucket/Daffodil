package com.squirrelbucket.daffodil.customBlockEntities;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class customBedBlockEntity extends BlockEntity {

    public customBedBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DAFFODIL_BED.get(), pos, state);
    }
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}