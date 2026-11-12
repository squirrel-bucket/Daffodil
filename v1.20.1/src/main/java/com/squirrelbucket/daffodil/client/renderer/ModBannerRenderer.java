package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;

import java.util.List;

public class ModBannerRenderer implements BlockEntityRenderer<BannerBlockEntity> {
    private final ModelPart flag;
    private final ModelPart pole;
    private final ModelPart bar;

    public ModBannerRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart model = context.bakeLayer(ModelLayers.BANNER);
        this.flag = model.getChild("flag");
        this.pole = model.getChild("pole");
        this.bar = model.getChild("bar");
    }

    @Override
    public void render(BannerBlockEntity banner, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        List<Pair<Holder<BannerPattern>, DyeColor>> patterns = banner.getPatterns();
        boolean itemRender = banner.getLevel() == null;
        poseStack.pushPose();
        long gameTime;
        if (itemRender) {
            gameTime = 0L;
            poseStack.translate(0.5F, 0.5F, 0.5F);
            pole.visible = true;
        } else {
            gameTime = banner.getLevel().getGameTime();
            BlockState state = banner.getBlockState();
            if (state.getBlock() instanceof BannerBlock) {
                poseStack.translate(0.5F, 0.5F, 0.5F);
                poseStack.mulPose(Axis.YP.rotationDegrees(-RotationSegment.convertToDegrees(state.getValue(BannerBlock.ROTATION))));
                pole.visible = true;
            } else {
                poseStack.translate(0.5F, -0.16666667F, 0.5F);
                poseStack.mulPose(Axis.YP.rotationDegrees(-state.getValue(WallBannerBlock.FACING).toYRot()));
                poseStack.translate(0.0F, -0.3125F, -0.4375F);
                pole.visible = false;
            }
        }

        poseStack.pushPose();
        poseStack.scale(2.0F / 3.0F, -2.0F / 3.0F, -2.0F / 3.0F);
        VertexConsumer baseConsumer = ModelBakery.BANNER_BASE.buffer(buffer, RenderType::entitySolid);
        pole.render(poseStack, baseConsumer, packedLight, packedOverlay);
        bar.render(poseStack, baseConsumer, packedLight, packedOverlay);

        BlockPos pos = banner.getBlockPos();
        float phase = ((float) Math.floorMod((long) (pos.getX() * 7 + pos.getY() * 9 + pos.getZ() * 13) + gameTime, 100L)
                + partialTick) / 100.0F;
        flag.xRot = (-0.0125F + 0.01F * Mth.cos((float) (Math.PI * 2.0) * phase)) * (float) Math.PI;
        flag.y = -32.0F;

        CustomDyeColors color = banner.getBlockState().getBlock() instanceof CustomBannerColorProvider provider
                ? provider.getBannerColor() : null;
        float[] baseRgb = color != null ? color.getTextureDiffuseColors() : banner.getBaseColor().getTextureDiffuseColors();
        flag.render(poseStack, ModelBakery.BANNER_BASE.buffer(buffer, RenderType::entitySolid),
                packedLight, packedOverlay);

        // Vanilla draws the plain cloth first, then colors the BASE pattern layer.
        patterns.get(0).getFirst().unwrapKey().map(Sheets::getBannerMaterial).ifPresent(material ->
                flag.render(poseStack, material.buffer(buffer, RenderType::entityNoOutline),
                        packedLight, packedOverlay, baseRgb[0], baseRgb[1], baseRgb[2], 1.0F));

        // The first vanilla pattern is the base cloth color, drawn above using CustomDyeColors.
        for (int i = 1; i < 17 && i < patterns.size(); i++) {
            Pair<Holder<BannerPattern>, DyeColor> pattern = patterns.get(i);
            float[] patternRgb = getPatternDiffuseColor(pattern.getSecond());
            pattern.getFirst().unwrapKey().map(Sheets::getBannerMaterial).ifPresent(material ->
                    flag.render(poseStack, material.buffer(buffer, RenderType::entityNoOutline),
                            packedLight, packedOverlay, patternRgb[0], patternRgb[1], patternRgb[2], 1.0F));
        }

        poseStack.popPose();
        poseStack.popPose();
    }

    private static float[] getPatternDiffuseColor(DyeColor color) {
        // The loom stores vanilla DyeColor ids. These three carrier ids represent the
        // custom dyes when they are used on a custom banner.
        if (color == DyeColor.YELLOW) return CustomDyeColors.DAFFODIL.getTextureDiffuseColors();
        if (color == DyeColor.BROWN) return CustomDyeColors.BURGUNDY.getTextureDiffuseColors();
        if (color == DyeColor.RED) return CustomDyeColors.SCARLET.getTextureDiffuseColors();
        return color.getTextureDiffuseColors();
    }
}
