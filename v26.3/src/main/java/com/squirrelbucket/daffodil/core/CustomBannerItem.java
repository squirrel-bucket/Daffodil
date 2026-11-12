package com.squirrelbucket.daffodil.core;

import net.minecraft.world.item.BannerItem;
import net.minecraft.world.level.block.Block;

public class CustomBannerItem extends BannerItem {
    public CustomBannerItem(Block standingBlock, Block wallBlock, Properties properties) {
        super(standingBlock, wallBlock, properties);
    }
}
