package com.example.examplemod;

import com.example.examplemod.block.ModCarpetBlock;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.material.PushReaction;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Daffodil.MODID)
public class Daffodil
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "daffodil";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> DAFFODIL_BLOCK =
            BLOCKS.register("daffodil_flower",
                    () -> new FlowerBlock(
                            MobEffects.MOVEMENT_SPEED,
                            100,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.PLANT)
                                    .noCollission()
                                    .instabreak()
                                    .sound(SoundType.GRASS)
                                    .pushReaction(PushReaction.DESTROY)
                    ));

    public static final RegistryObject<Item> DAFFODIL_ITEM =
            ITEMS.register("daffodil_flower",
                    () -> new BlockItem(
                            DAFFODIL_BLOCK.get(),
                            new Item.Properties()
                    ));

    // DAFFODIL DYE

    public static final RegistryObject<Item> DAFFODIL_DYE =
            ITEMS.register("daffodil_dye",
                () -> new Item(
                        new Item.Properties()
                ));

    // WOOL STUFF (wool, carpet)

    public static final RegistryObject<Block> DAFFODIL_WOOL_BLOCK =
            BLOCKS.register("daffodil_wool",
                    () -> new Block(
                            BlockBehaviour.Properties.of()
                                    .strength(0.8F, 0.8F)
                                    .mapColor(MapColor.WOOL)
                                    .sound(SoundType.WOOL)
                    ));

    public static final RegistryObject<Item> DAFFODIL_WOOL_ITEM =
            ITEMS.register("daffodil_wool",
                    () -> new BlockItem(
                            DAFFODIL_WOOL_BLOCK.get(),
                            new Item.Properties()
                    ));

    public static final RegistryObject<Block> DAFFODIL_CARPET_BLOCK =
            BLOCKS.register("daffodil_carpet",
                    () -> new ModCarpetBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(0.1F, 0.1F)
                                    .mapColor(MapColor.WOOL)
                                    .sound(SoundType.WOOL)
                                    .noOcclusion()
                    ));

    public static final RegistryObject<Item> DAFFODIL_CARPET_ITEM =
            ITEMS.register("daffodil_carpet",
                    () -> new BlockItem(
                            DAFFODIL_CARPET_BLOCK.get(),
                            new Item.Properties()
                    ));

    public Daffodil(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(DAFFODIL_ITEM);
            event.accept(DAFFODIL_DYE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(DAFFODIL_WOOL_ITEM);
            event.accept(DAFFODIL_CARPET_ITEM);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
