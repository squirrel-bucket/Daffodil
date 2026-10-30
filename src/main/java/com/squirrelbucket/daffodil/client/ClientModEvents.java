package com.squirrelbucket.daffodil.client;

import com.squirrelbucket.daffodil.client.renderer.ModBedRenderer;
import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "daffodil", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BlockEntityRenderers.register(BlockEntityType.BED, net.minecraft.client.renderer.blockentity.BedRenderer::new);
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(
                ModBlockEntities.DAFFODIL_BED.get(),
                ModBedRenderer::new
        );
    }
}