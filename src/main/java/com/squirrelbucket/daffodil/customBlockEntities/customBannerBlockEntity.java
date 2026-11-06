package com.squirrelbucket.daffodil.customBlockEntities;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import com.squirrelbucket.daffodil.core.ModItems;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class customBannerBlockEntity extends BannerBlockEntity {

    public customBannerBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.CUSTOM_BANNER.get();
    }

    @Override
    public ItemStack getItem() {
        ItemStack stack = new ItemStack(switch (((CustomBannerColorProvider) getBlockState().getBlock()).getBannerColor()) {
            case DAFFODIL -> ModItems.DAFFODIL_BANNER.get();
            case BURGUNDY -> ModItems.BURGUNDY_BANNER.get();
            case SCARLET -> ModItems.SCARLET_BANNER.get();
        });

        CompoundTag blockEntityData = new CompoundTag();
        saveAdditional(blockEntityData);
        if (blockEntityData.contains(TAG_PATTERNS)) {
            BlockItem.setBlockEntityData(stack, getType(), blockEntityData);
        }
        Component customName = getCustomName();
        if (customName != null) stack.setHoverName(customName);
        return stack;
    }
}
