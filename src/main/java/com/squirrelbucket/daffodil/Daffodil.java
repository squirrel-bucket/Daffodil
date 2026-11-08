package com.squirrelbucket.daffodil;

import com.squirrelbucket.daffodil.core.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@Mod(Daffodil.MODID)
public class Daffodil
{
    public static final String MODID = "daffodil";

    public Daffodil(FMLJavaModLoadingContext context)
    {

        IEventBus modEventBus = context.getModEventBus();

        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::restoreVanillaDyeLookup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WoodType.register(ModWoodTypes.PLUM_WOOD_TYPE);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_DOOR.get(), RenderType.cutout());
        });
    }

    @SuppressWarnings("unchecked")
    private void restoreVanillaDyeLookup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            try {
                Map<DyeColor, DyeItem> dyeItems = ObfuscationReflectionHelper.getPrivateValue(
                        DyeItem.class, null, "ITEM_BY_COLOR");
                for (DyeColor color : DyeColor.values()) {
                    Item item = ForgeRegistries.ITEMS.getValue(
                            new ResourceLocation("minecraft", color.getName() + "_dye"));
                    if (item instanceof DyeItem vanillaDye) {
                        dyeItems.put(color, vanillaDye);
                    }
                }
            } catch (RuntimeException exception) {
                throw new IllegalStateException("Unable to restore the vanilla dye lookup after registering loom-compatible custom dyes", exception);
            }
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeTabs.DAFFODIL_TAB.getKey()) {
            ModItems.ITEMS.getEntries().forEach(event::accept);
        }
    }
}
