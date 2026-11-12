package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.squirrelbucket.daffodil.core.customBlocks.customBedBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public final class ModBedItemRenderer
        extends BlockEntityWithoutLevelRenderer {

    public static final ModBedItemRenderer INSTANCE =
            new ModBedItemRenderer();

    private final ModelPart head;
    private final ModelPart foot;

    private ModBedItemRenderer() {
        super(
                Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels()
        );

        var models = Minecraft.getInstance().getEntityModels();
        head = models.bakeLayer(ModelLayers.BED_HEAD);
        foot = models.bakeLayer(ModelLayers.BED_FOOT);
    }

    @Override
    public void renderByItem(
            ItemStack stack,
            @NotNull ItemDisplayContext context,
            @NotNull PoseStack poseStack,
            @NotNull MultiBufferSource buffers,
            int light,
            int overlay
    ) {
        if (!(stack.getItem() instanceof BlockItem item)
                || !(item.getBlock() instanceof customBedBlock bed)) {
            return;
        }

        ResourceLocation texture =
                ResourceLocation.fromNamespaceAndPath(
                        "daffodil",
                        "textures/entity/bed/"
                                + bed.getBedColor().getSerializedName()
                                + ".png"
                );

        VertexConsumer vertices =
                buffers.getBuffer(RenderType.entitySolid(texture));

        renderHalf(head, false, poseStack, vertices, light, overlay);
        renderHalf(foot, true, poseStack, vertices, light, overlay);
    }

    private static void renderHalf(
            ModelPart model,
            boolean isFoot,
            PoseStack poseStack,
            VertexConsumer vertices,
            int light,
            int overlay
    ) {
        // Matches vanilla's transforms for a bed rendered without a level.
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        poseStack.translate(-0.5F, -0.5F, -0.5F);

        model.render(poseStack, vertices, light, overlay);

        poseStack.popPose();
    }
}