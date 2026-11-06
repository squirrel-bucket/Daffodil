package com.squirrelbucket.daffodil.client;

import com.squirrelbucket.daffodil.client.renderer.ModBedRenderer;
import com.squirrelbucket.daffodil.client.renderer.ModBannerRenderer;
import com.squirrelbucket.daffodil.client.screen.ModLoomScreen;
import com.squirrelbucket.daffodil.core.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.Map;

@Mod.EventBusSubscriber(modid = "daffodil", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BlockEntityRenderers.register(BlockEntityType.BED, net.minecraft.client.renderer.blockentity.BedRenderer::new);
            @SuppressWarnings("unchecked")
            Map<MenuType<?>, Object> screens = (Map<MenuType<?>, Object>) (Map<?, ?>)
                    ObfuscationReflectionHelper.getPrivateValue(MenuScreens.class, null, "SCREENS");
            screens.remove(MenuType.LOOM);
            MenuScreens.register(MenuType.LOOM, ModLoomScreen::new);
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

        // Use the custom renderer for vanilla banners too so custom loom dyes retain
        // their RGB colors when placed on any banner.
        BlockEntityRenderers.register(BlockEntityType.BANNER, ModBannerRenderer::new);

        event.registerBlockEntityRenderer(
                ModBlockEntities.CUSTOM_BED.get(),
                ModBedRenderer::new
        );
        BlockEntityRenderers.register(ModBlockEntities.CUSTOM_BANNER.get(), ModBannerRenderer::new);
    }



}
