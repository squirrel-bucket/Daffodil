package com.squirrelbucket.daffodil;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import com.squirrelbucket.daffodil.core.ModBlocks;
import com.squirrelbucket.daffodil.core.ModCreativeTabs;
import com.squirrelbucket.daffodil.core.ModEntities;
import com.squirrelbucket.daffodil.core.ModItems;
import com.squirrelbucket.daffodil.core.ModMapDecorationTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Daffodil.MODID)
public class Daffodil {
    public static final String MODID = "daffodil";

    public Daffodil(IEventBus modEventBus, ModContainer modContainer) {
        // Attach dependencies in registry order so dependent holders are bound before
        // block entities and block items resolve them during their registration event.
        ModBlocks.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModItems.register(modEventBus);
        ModMapDecorationTypes.TYPES.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(ModCreativeTabs.DAFFODIL_TAB.getKey())) {
            ModItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }
}
