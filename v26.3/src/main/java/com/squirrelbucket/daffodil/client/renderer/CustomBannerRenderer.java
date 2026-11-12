package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import net.minecraft.client.model.object.banner.BannerFlagModel;
import net.minecraft.client.model.object.banner.BannerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.OrderedSubmitNodeCollector;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public final class CustomBannerRenderer implements BlockEntityRenderer<BannerBlockEntity, CustomBannerRenderState> {
    private final SpriteGetter sprites;
    private final BannerModel standingModel;
    private final BannerModel wallModel;
    private final BannerFlagModel standingFlag;
    private final BannerFlagModel wallFlag;

    public CustomBannerRenderer(BlockEntityRendererProvider.Context context) {
        var models = context.entityModelSet();
        this.sprites = context.sprites();
        this.standingModel = new BannerModel(models.bakeLayer(ModelLayers.STANDING_BANNER));
        this.wallModel = new BannerModel(models.bakeLayer(ModelLayers.WALL_BANNER));
        this.standingFlag = new BannerFlagModel(models.bakeLayer(ModelLayers.STANDING_BANNER_FLAG));
        this.wallFlag = new BannerFlagModel(models.bakeLayer(ModelLayers.WALL_BANNER_FLAG));
    }

    @Override
    public CustomBannerRenderState createRenderState() {
        return new CustomBannerRenderState();
    }

    @Override
    public void extractRenderState(BannerBlockEntity banner, CustomBannerRenderState state, float partialTick,
                                   Vec3 cameraPosition,
                                   ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(banner, state, partialTick, cameraPosition, breakProgress);
        state.baseColor = banner.getBaseColor();
        state.patterns = banner.getPatterns();
        BlockState blockState = banner.getBlockState();
        if (blockState.getBlock() instanceof BannerBlock) {
            state.transformation = net.minecraft.client.renderer.blockentity.BannerRenderer.TRANSFORMATIONS
                    .freeTransformations(blockState.getValue(BannerBlock.ROTATION));
            state.attachmentType = BannerBlock.AttachmentType.GROUND;
        } else {
            state.transformation = net.minecraft.client.renderer.blockentity.BannerRenderer.TRANSFORMATIONS
                    .wallTransformation(blockState.getValue(WallBannerBlock.FACING));
            state.attachmentType = BannerBlock.AttachmentType.WALL;
        }
        state.daffodilColor = blockState.getBlock() instanceof CustomBannerColorProvider provider
                ? provider.getBannerColor() : null;
        long gameTime = banner.getLevel() == null ? 0L : banner.getLevel().getGameTime();
        BlockPos pos = banner.getBlockPos();
        state.phase = (Math.floorMod(pos.getX() * 7L + pos.getY() * 9L + pos.getZ() * 13L + gameTime, 100L)
                + partialTick) / 100.0F;
    }

    @Override
    public void submit(CustomBannerRenderState state, PoseStack poseStack,
                       SubmitNodeCollector collector, CameraRenderState camera) {
        boolean wall = state.attachmentType == BannerBlock.AttachmentType.WALL;
        BannerModel model = wall ? this.wallModel : this.standingModel;
        BannerFlagModel flag = wall ? this.wallFlag : this.standingFlag;
        poseStack.pushPose();
        poseStack.mulPose(state.transformation);
        SpriteId base = Sheets.BANNER_BASE;
        collector.submitModel(model, Unit.INSTANCE, poseStack, state.lightCoords, OverlayTexture.NO_OVERLAY, -1, base, sprites, 0);
        collector.submitModel(flag, state.phase, poseStack, state.lightCoords, OverlayTexture.NO_OVERLAY, -1, base, sprites, 0);

        submitPattern(flag, state.phase, Sheets.BANNER_PATTERN_BASE,
                state.daffodilColor == null ? state.baseColor.getTextureDiffuseColor() : state.daffodilColor.getRgb(),
                poseStack, collector.order(1), state);
        for (int i = 0; i < Math.min(16, state.patterns.layers().size()); i++) {
            BannerPatternLayers.Layer layer = state.patterns.layers().get(i);
            submitPattern(flag, state.phase, Sheets.getBannerSprite(layer.pattern()), color(layer.color()),
                    poseStack, collector.order(i + 2), state);
        }
        poseStack.popPose();
    }

    private void submitPattern(BannerFlagModel flag, float phase, SpriteId sprite, int color,
                               PoseStack poseStack, OrderedSubmitNodeCollector collector,
                               CustomBannerRenderState state) {
        collector.submitModel(flag, phase, poseStack, sprite.renderType(RenderTypes::bannerPattern),
                state.lightCoords, OverlayTexture.NO_OVERLAY, color, sprites.get(sprite), 0);
    }

    private static int color(DyeColor color) {
        if (color == CustomDyeColors.DAFFODIL.getVanillaCarrier()) return CustomDyeColors.DAFFODIL.getRgb();
        if (color == CustomDyeColors.BURGUNDY.getVanillaCarrier()) return CustomDyeColors.BURGUNDY.getRgb();
        if (color == CustomDyeColors.SCARLET.getVanillaCarrier()) return CustomDyeColors.SCARLET.getRgb();
        return color.getTextureDiffuseColor();
    }
}
