package com.squirrelbucket.daffodil.client;

import com.squirrelbucket.daffodil.client.renderer.PlumBoatRenderer;
import com.squirrelbucket.daffodil.core.ModBlockEntities;
import com.squirrelbucket.daffodil.core.ModEntities;
import com.squirrelbucket.daffodil.client.renderer.CustomBannerRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "daffodil", value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.CUSTOM_BANNER.get(), CustomBannerRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.PLUM_SIGN.get(), StandingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.PLUM_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerEntityRenderer(ModEntities.PLUM_BOAT.get(), context -> new PlumBoatRenderer(context, false));
        event.registerEntityRenderer(ModEntities.PLUM_CHEST_BOAT.get(), context -> new PlumBoatRenderer(context, true));
    }
}
