package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.Daffodil;
import com.squirrelbucket.daffodil.core.ModBlocks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
    public static final RegistryObject<Item> VERDANT_DYE = ITEMS.register("verdant_dye",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_DYE = ITEMS.register("scarlet_dye",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_ITEM = ITEMS.register("daffodil_flower",
            () -> new BlockItem(ModBlocks.DAFFODIL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_WOOL_ITEM = ITEMS.register("daffodil_wool",
            () -> new BlockItem(ModBlocks.DAFFODIL_WOOL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_WOOL_ITEM = ITEMS.register("verdant_wool",
            () -> new BlockItem(ModBlocks.VERDANT_WOOL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_WOOL_ITEM = ITEMS.register("scarlet_wool",
            () -> new BlockItem(ModBlocks.SCARLET_WOOL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CARPET_ITEM = ITEMS.register("daffodil_carpet",
            () -> new BlockItem(ModBlocks.DAFFODIL_CARPET_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_CARPET_ITEM = ITEMS.register("verdant_carpet",
            () -> new BlockItem(ModBlocks.VERDANT_CARPET_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CARPET_ITEM = ITEMS.register("scarlet_carpet",
            () -> new BlockItem(ModBlocks.SCARLET_CARPET_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_BED_ITEM = ITEMS.register("daffodil_bed",
            () -> new BlockItem(ModBlocks.DAFFODIL_BED.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_BED_ITEM = ITEMS.register("verdant_bed",
            () -> new BlockItem(ModBlocks.VERDANT_BED.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_BED_ITEM = ITEMS.register("scarlet_bed",
            () -> new BlockItem(ModBlocks.SCARLET_BED.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_TERRACOTTA_ITEM = ITEMS.register("daffodil_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_TERRACOTTA_ITEM = ITEMS.register("verdant_terracotta",
            () -> new BlockItem(ModBlocks.VERDANT_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_TERRACOTTA_ITEM = ITEMS.register("scarlet_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_TERRACOTTA.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_GLAZED_TERRACOTTA_ITEM = ITEMS.register("daffodil_glazed_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_GLAZED_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_GLAZED_TERRACOTTA_ITEM = ITEMS.register("verdant_glazed_terracotta",
            () -> new BlockItem(ModBlocks.VERDANT_GLAZED_TERRACOTTA.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_GLAZED_TERRACOTTA_ITEM = ITEMS.register("scarlet_glazed_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_GLAZED_TERRACOTTA.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_ITEM = ITEMS.register("daffodil_concrete",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_CONCRETE_ITEM = ITEMS.register("verdant_concrete",
            () -> new BlockItem(ModBlocks.VERDANT_CONCRETE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CONCRETE_ITEM = ITEMS.register("scarlet_concrete",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_CONCRETE_POWDER_ITEM = ITEMS.register("daffodil_concrete_powder",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE_POWDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> VERDANT_CONCRETE_POWDER_ITEM = ITEMS.register("verdant_concrete_powder",
            () -> new BlockItem(ModBlocks.VERDANT_CONCRETE_POWDER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_CONCRETE_POWDER_ITEM = ITEMS.register("scarlet_concrete_powder",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE_POWDER.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}