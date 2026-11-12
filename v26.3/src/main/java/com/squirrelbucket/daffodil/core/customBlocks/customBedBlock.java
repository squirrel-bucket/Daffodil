package com.squirrelbucket.daffodil.core.customBlocks;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class customBedBlock extends BedBlock {

    private final CustomDyeColors bedColor;

    public customBedBlock(CustomDyeColors color, Properties properties) {
        super(color.getVanillaCarrier(), properties);
        this.bedColor = color;
    }

    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state,
                              @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if (!player.isCreative()) {
            super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        }
    }

    public CustomDyeColors getBedColor() {
        return this.bedColor;
    }

}
