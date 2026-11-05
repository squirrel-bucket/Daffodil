package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.Daffodil;
import com.squirrelbucket.daffodil.core.ModBedItem;
import com.squirrelbucket.daffodil.core.ModBlocks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> DAFFODIL_DYE = ITEMS.register("daffodil_dye",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_DYE = ITEMS.register("burgundy_dye",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_DYE = ITEMS.register("scarlet_dye",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_ITEM = ITEMS.register("daffodil_flower",
            () -> new BlockItem(ModBlocks.DAFFODIL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> HIBISCUS_ITEM = ITEMS.register("hibiscus_flower",
            () -> new BlockItem(ModBlocks.HIBISCUS_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> GOJI_BERRIES = ITEMS.register("goji_berries",
            () -> new ItemNameBlockItem(ModBlocks.GOJI_BERRY_BUSH.get(), new Item.Properties().food(ModFoods.GOJI_BERRIES)));

    public static final RegistryObject<Item> DAFFODIL_WOOL_ITEM = ITEMS.register("daffodil_wool",
            () -> new BlockItem(ModBlocks.DAFFODIL_WOOL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_WOOL_ITEM = ITEMS.register("burgundy_wool",
            () -> new BlockItem(ModBlocks.BURGUNDY_WOOL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_WOOL_ITEM = ITEMS.register("scarlet_wool",
            () -> new BlockItem(ModBlocks.SCARLET_WOOL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CARPET_ITEM = ITEMS.register("daffodil_carpet",
            () -> new BlockItem(ModBlocks.DAFFODIL_CARPET_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_CARPET_ITEM = ITEMS.register("burgundy_carpet",
            () -> new BlockItem(ModBlocks.BURGUNDY_CARPET_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CARPET_ITEM = ITEMS.register("scarlet_carpet",
            () -> new BlockItem(ModBlocks.SCARLET_CARPET_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_BED_ITEM = ITEMS.register("daffodil_bed",
            () -> new BlockItem(ModBlocks.DAFFODIL_BED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_BED_ITEM = ITEMS.register("burgundy_bed",
            () -> new BlockItem(ModBlocks.BURGUNDY_BED.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_BED = ITEMS.register("scarlet_bed",
            () -> new ModBedItem(ModBlocks.SCARLET_BED.get(), new Item.Properties()));


    public static final RegistryObject<Item> DAFFODIL_TERRACOTTA_ITEM = ITEMS.register("daffodil_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_TERRACOTTA_ITEM = ITEMS.register("burgundy_terracotta",
            () -> new BlockItem(ModBlocks.BURGUNDY_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_TERRACOTTA_ITEM = ITEMS.register("scarlet_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_TERRACOTTA.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_GLAZED_TERRACOTTA_ITEM = ITEMS.register("daffodil_glazed_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_GLAZED_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_GLAZED_TERRACOTTA_ITEM = ITEMS.register("burgundy_glazed_terracotta",
            () -> new BlockItem(ModBlocks.BURGUNDY_GLAZED_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_GLAZED_TERRACOTTA_ITEM = ITEMS.register("scarlet_glazed_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_GLAZED_TERRACOTTA.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_ITEM = ITEMS.register("daffodil_concrete",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_CONCRETE_ITEM = ITEMS.register("burgundy_concrete",
            () -> new BlockItem(ModBlocks.BURGUNDY_CONCRETE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CONCRETE_ITEM = ITEMS.register("scarlet_concrete",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_POWDER_ITEM = ITEMS.register("daffodil_concrete_powder",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE_POWDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_CONCRETE_POWDER_ITEM = ITEMS.register("burgundy_concrete_powder",
            () -> new BlockItem(ModBlocks.BURGUNDY_CONCRETE_POWDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CONCRETE_POWDER_ITEM = ITEMS.register("scarlet_concrete_powder",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE_POWDER.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}