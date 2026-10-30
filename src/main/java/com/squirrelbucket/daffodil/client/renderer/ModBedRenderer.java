package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.squirrelbucket.daffodil.core.customBlocks.customBedBlock;
import com.squirrelbucket.daffodil.customBlockEntities.customBedBlockEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.client.model.geom.ModelLayers;

public class ModBedRenderer implements BlockEntityRenderer<customBedBlockEntity> {
    private final ModelPart headModel;
    private final ModelPart footModel;

    public ModBedRenderer(BlockEntityRendererProvider.Context context) {
        this.headModel = context.bakeLayer(ModelLayers.BED_HEAD);
        this.footModel = context.bakeLayer(ModelLayers.BED_FOOT);
    }

    @Override
    public void render(customBedBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        if (level == null) return;

        BlockState state = blockEntity.getBlockState();
        if (!(state.getBlock() instanceof customBedBlock bedBlock)) return;

        BedPart part = state.getValue(BedBlock.PART);
        poseStack.pushPose();

        poseStack.translate(0.5D, 0.5D, 0.5D);

        float rotation = state.getValue(BedBlock.FACING).toYRot();
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-rotation));
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180.0F));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.0F, 0.0F, 0.4375F);
        poseStack.translate(-0.5D, -0.5D, -0.5D);

        StringRepresentable color = bedBlock.getBedColor();
        Material material = getBedMaterial(color);

        // 5. Draw the correct model part
        VertexConsumer consumer = material.buffer(bufferSource, RenderType::entitySolid);
        if (part == BedPart.HEAD) {
            this.headModel.render(poseStack, consumer, packedLight, packedOverlay);
        } else {
            this.footModel.render(poseStack, consumer, packedLight, packedOverlay);
        }

        poseStack.popPose();
    }

    private Material getBedMaterial(StringRepresentable color) {
        ResourceLocation textureLocation;

        if (color instanceof DyeColor vanillaColor) {
            textureLocation = new ResourceLocation("minecraft", "entity/bed/" + vanillaColor.getName());
        } else {
            textureLocation = new ResourceLocation("daffodil", "entity/bed/" + color.getSerializedName());
        }

        return new Material(net.minecraft.client.renderer.texture.TextureAtlas.LOCATION_BLOCKS, textureLocation);
    }


}