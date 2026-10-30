package com.squirrelbucket.daffodil;

import com.squirrelbucket.daffodil.core.ModBlockEntities;
import com.squirrelbucket.daffodil.core.ModBlocks;
import com.squirrelbucket.daffodil.core.ModCreativeTabs;
import com.squirrelbucket.daffodil.core.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Daffodil.MODID)
public class Daffodil
{
    public static final String MODID = "daffodil";

    public Daffodil(FMLJavaModLoadingContext context)
    {

        IEventBus modEventBus = context.getModEventBus();

        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeTabs.DAFFODIL_TAB.getKey()) {
            ModItems.ITEMS.getEntries().forEach(event::accept);
        }
    }
}
