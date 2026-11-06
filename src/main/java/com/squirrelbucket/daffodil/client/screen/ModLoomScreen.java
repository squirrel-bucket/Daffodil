package com.squirrelbucket.daffodil.client.screen;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

public class ModLoomScreen extends LoomScreen {
    private ModelPart previewFlag;

    public ModLoomScreen(LoomMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        previewFlag = minecraft.getEntityModels().bakeLayer(ModelLayers.BANNER).getChild("flag");
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        super.renderBg(graphics, partialTick, mouseX, mouseY);
        ItemStack result = menu.getResultSlot().getItem();
        if (result.isEmpty() || !(result.getItem() instanceof BannerItem)) return;

        ItemStack inputBanner = menu.getBannerSlot().getItem();
        if (inputBanner.isEmpty() || !(inputBanner.getItem() instanceof BannerItem bannerItem)) return;

        DyeColor vanillaBase = bannerItem.getColor();
        CustomDyeColors customBase = null;
        if (inputBanner.getItem() instanceof BlockItem blockItem
                && blockItem.getBlock() instanceof CustomBannerColorProvider colorProvider) {
            customBase = colorProvider.getBannerColor();
        }

        List<Pair<Holder<BannerPattern>, DyeColor>> patterns = BannerBlockEntity.createPatterns(
                vanillaBase, BannerBlockEntity.getItemPatterns(result));
        float[] baseRgb = customBase == null
                ? vanillaBase.getTextureDiffuseColors()
                : customBase.getTextureDiffuseColors();

        // LoomScreen has already drawn the vanilla preview. Restore the GUI pixels
        // under its flag before drawing ours, otherwise the two translucent cloth
        // layers blend and make even vanilla banner colors look dimmer.
        graphics.blit(ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/loom.png"),
                leftPos + 136, topPos + 4, 136, 4, 28, 52);

        Lighting.setupForFlatItems();
        PoseStack pose = graphics.pose();
        pose.pushPose();
        pose.translate(leftPos + 139.0F, topPos + 52.0F, 0.0F);
        pose.scale(24.0F, -24.0F, 1.0F);
        pose.translate(0.5F, 0.5F, 0.5F);
        pose.scale(2.0F / 3.0F, -2.0F / 3.0F, -2.0F / 3.0F);
        previewFlag.xRot = 0.0F;
        previewFlag.y = -32.0F;
        previewFlag.render(pose, ModelBakery.BANNER_BASE.buffer(graphics.bufferSource(), RenderType::entitySolid),
                15728880, OverlayTexture.NO_OVERLAY);
        patterns.get(0).getFirst().unwrapKey().map(Sheets::getBannerMaterial).ifPresent(material ->
                previewFlag.render(pose, material.buffer(graphics.bufferSource(), RenderType::entityNoOutline),
                        15728880, OverlayTexture.NO_OVERLAY, baseRgb[0], baseRgb[1], baseRgb[2], 1.0F));

        for (int index = 1; index < patterns.size(); index++) {
            Pair<Holder<BannerPattern>, DyeColor> pattern = patterns.get(index);
            float[] rgb = customPatternColor(pattern.getSecond());
            pattern.getFirst().unwrapKey().map(Sheets::getBannerMaterial).ifPresent(material ->
                    previewFlag.render(pose, material.buffer(graphics.bufferSource(), RenderType::entityNoOutline),
                            15728880, OverlayTexture.NO_OVERLAY, rgb[0], rgb[1], rgb[2], 1.0F));
        }
        pose.popPose();
        graphics.flush();
        Lighting.setupFor3DItems();
    }

    private float[] customPatternColor(DyeColor color) {
        // Vanilla LoomMenu stores only DyeColor ids. These are the carriers used by the mod dyes.
        if (color == DyeColor.YELLOW) return CustomDyeColors.DAFFODIL.getTextureDiffuseColors();
        if (color == DyeColor.BROWN) return CustomDyeColors.BURGUNDY.getTextureDiffuseColors();
        if (color == DyeColor.RED) return CustomDyeColors.SCARLET.getTextureDiffuseColors();
        return color.getTextureDiffuseColors();
    }
}
