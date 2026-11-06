package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import com.squirrelbucket.daffodil.customBlockEntities.customBannerBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.customBannerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public final class ModBannerItemRenderer extends BlockEntityWithoutLevelRenderer {
    public static final ModBannerItemRenderer INSTANCE = new ModBannerItemRenderer();

    private ModBannerItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, @NotNull ItemDisplayContext context, @NotNull PoseStack poseStack,
                             @NotNull MultiBufferSource buffers, int light, int overlay) {
        if (!(stack.getItem() instanceof BlockItem item)
                || !(item.getBlock() instanceof CustomBannerColorProvider)) {
            return;
        }

        BlockState state = item.getBlock().defaultBlockState();
        customBannerBlockEntity banner = new customBannerBlockEntity(net.minecraft.core.BlockPos.ZERO, state);
        banner.fromItem(stack);
        Minecraft.getInstance().getBlockEntityRenderDispatcher()
                .renderItem(banner, poseStack, buffers, light, overlay);
    }
}
