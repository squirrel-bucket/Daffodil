package com.example.examplemod;

import com.example.examplemod.block.ModCarpetBlock;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final RegistryObject<Block> DAFFODIL_BLOCK =
            BLOCKS.register("daffodil_flower",
                    () -> new FlowerBlock(
                            MobEffects.MOVEMENT_SPEED,
                            100,
                            BlockBehaviour.Properties.copy(Blocks.POPPY)
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
                            BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
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
                            BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)
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

    // Terracotta and Concrete/Concrete Powder

    public static final RegistryObject<Block> DAFFODIL_TERRACOTTA =
            BLOCKS.register("daffodil_terracotta",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                        .strength(1.25F, 4.2F)
                        .sound(SoundType.STONE)
            ));

    public static final RegistryObject<Item> DAFFODIL_TERRACOTTA_ITEM =
            ITEMS.register("daffodil_terracotta",
                    () -> new BlockItem(
                            DAFFODIL_TERRACOTTA.get(),
                            new Item.Properties()
                    ));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE =
            BLOCKS.register("daffodil_concrete",
                    () -> new Block(
                            BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)
                                    .strength(1.8F, 1.8F)
                                    .sound(SoundType.STONE)
                    ));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_ITEM =
            ITEMS.register("daffodil_concrete",
                    () -> new BlockItem(
                            DAFFODIL_CONCRETE.get(),
                            new Item.Properties()
                    ));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE_POWDER =
            BLOCKS.register("daffodil_concrete_powder",
                    () -> new ConcretePowderBlock(
                            DAFFODIL_CONCRETE.get(), // Pass your solid block instance here
                            BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)
                                    .strength(0.5F)
                                    .sound(SoundType.SAND)
                                    .mapColor(MapColor.COLOR_ORANGE)
                    ));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_POWDER_ITEM =
            ITEMS.register("daffodil_concrete_powder",
                    () -> new BlockItem(
                            DAFFODIL_CONCRETE_POWDER.get(),
                            new Item.Properties()
                    ));


    public static final RegistryObject<CreativeModeTab> DAFFODIL_TAB =
            TABS.register("daffodil_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.daffodil.daffodil_tab"))
                            .icon(() -> DAFFODIL_WOOL_ITEM.get().getDefaultInstance())
                            .build());

    public Daffodil(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        TABS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == DAFFODIL_TAB.getKey())
        {
            event.accept(DAFFODIL_ITEM);
            event.accept(DAFFODIL_DYE);
            event.accept(DAFFODIL_WOOL_ITEM);
            event.accept(DAFFODIL_CARPET_ITEM);
            event.accept(DAFFODIL_TERRACOTTA_ITEM);
            event.accept(DAFFODIL_CONCRETE_ITEM);
            event.accept(DAFFODIL_CONCRETE_POWDER_ITEM);
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
