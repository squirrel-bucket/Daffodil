package com.squirrelbucket.daffodil.core.customBlocks;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.customBlockEntities.customBannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class customBannerBlock extends BannerBlock implements CustomBannerColorProvider {

    private final CustomDyeColors bannerColor;

    public customBannerBlock(CustomDyeColors color, Properties properties) {
        super(color.getVanillaCarrier(), properties);
        this.bannerColor = color;
    }

    @Override
    public CustomDyeColors getBannerColor() {
        return bannerColor;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new customBannerBlockEntity(pos, state);
    }
}
