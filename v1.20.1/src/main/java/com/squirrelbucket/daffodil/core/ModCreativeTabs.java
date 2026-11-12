package com.squirrelbucket.daffodil.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> DAFFODIL_TAB =
            TABS.register("daffodil_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.daffodil.daffodil_tab"))
                            .icon(() -> ModItems.DAFFODIL_WOOL_ITEM.get().getDefaultInstance())
                            .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
