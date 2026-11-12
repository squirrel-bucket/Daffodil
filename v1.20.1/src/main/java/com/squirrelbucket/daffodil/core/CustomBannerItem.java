package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.renderer.ModBannerItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class CustomBannerItem extends BannerItem {
    public CustomBannerItem(Block standingBlock, Block wallBlock, Properties properties) {
        super(standingBlock, wallBlock, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ModBannerItemRenderer.INSTANCE;
            }
        });
    }
}
