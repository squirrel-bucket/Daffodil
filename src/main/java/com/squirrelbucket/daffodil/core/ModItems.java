package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.Daffodil;
import com.squirrelbucket.daffodil.core.ModBedItem;
import com.squirrelbucket.daffodil.core.ModBlocks;
import com.squirrelbucket.daffodil.client.CustomDyeColors;
import net.minecraft.world.item.DyeColor;
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
            () -> new CustomDyeItem(CustomDyeColors.DAFFODIL, DyeColor.YELLOW, new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_DYE = ITEMS.register("burgundy_dye",
            () -> new CustomDyeItem(CustomDyeColors.BURGUNDY, DyeColor.BROWN, new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_DYE = ITEMS.register("scarlet_dye",
            () -> new CustomDyeItem(CustomDyeColors.SCARLET, DyeColor.RED, new Item.Properties()));

    public static final RegistryObject<Item> DAFFODIL_BANNER = ITEMS.register("daffodil_banner",
            () -> new CustomBannerItem(ModBlocks.DAFFODIL_BANNER.get(), ModBlocks.DAFFODIL_WALL_BANNER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCARLET_BANNER = ITEMS.register("scarlet_banner",
            () -> new CustomBannerItem(ModBlocks.SCARLET_BANNER.get(), ModBlocks.SCARLET_WALL_BANNER.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_BANNER = ITEMS.register("burgundy_banner",
            () -> new CustomBannerItem(ModBlocks.BURGUNDY_BANNER.get(), ModBlocks.BURGUNDY_WALL_BANNER.get(), new Item.Properties()));


    public static final RegistryObject<Item> PLUM_LEAVES = ITEMS.register("plum_leaves",
            () -> new BlockItem(ModBlocks.PLUM_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLOWERING_PLUM_LEAVES = ITEMS.register("flowering_plum_leaves",
            () -> new BlockItem(ModBlocks.FLOWERING_PLUM_LEAVES.get(), new Item.Properties()));

    public static final RegistryObject<Item> PLUM_PLANKS = ModItems.ITEMS.register("plum_planks", () -> new BlockItem(ModBlocks.PLUM_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_LOG = ModItems.ITEMS.register("plum_log", () -> new BlockItem(ModBlocks.PLUM_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_PLUM_LOG = ModItems.ITEMS.register("stripped_plum_log", () -> new BlockItem(ModBlocks.STRIPPED_PLUM_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_WOOD = ModItems.ITEMS.register("plum_wood", () -> new BlockItem(ModBlocks.PLUM_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_PLUM_WOOD = ModItems.ITEMS.register("stripped_plum_wood", () -> new BlockItem(ModBlocks.STRIPPED_PLUM_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<Item> PLUM_STAIRS = ModItems.ITEMS.register("plum_stairs", () -> new BlockItem(ModBlocks.PLUM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_SLAB = ModItems.ITEMS.register("plum_slab", () -> new BlockItem(ModBlocks.PLUM_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<Item> PLUM_TRAPDOOR = ModItems.ITEMS.register("plum_trapdoor", () -> new BlockItem(ModBlocks.PLUM_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_BUTTON = ModItems.ITEMS.register("plum_button", () -> new BlockItem(ModBlocks.PLUM_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_PRESSURE_PLATE = ModItems.ITEMS.register("plum_pressure_plate", () -> new BlockItem(ModBlocks.PLUM_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_DOOR = ModItems.ITEMS.register("plum_door", () -> new BlockItem(ModBlocks.PLUM_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_FENCE = ModItems.ITEMS.register("plum_fence", () -> new BlockItem(ModBlocks.PLUM_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLUM_FENCE_GATE = ModItems.ITEMS.register("plum_fence_gate", () -> new BlockItem(ModBlocks.PLUM_FENCE_GATE.get(), new Item.Properties()));

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
            () -> new ModBedItem(ModBlocks.DAFFODIL_BED.get(), new Item.Properties()));
    public static final RegistryObject<Item> BURGUNDY_BED_ITEM = ITEMS.register("burgundy_bed",
            () -> new ModBedItem(ModBlocks.BURGUNDY_BED.get(), new Item.Properties()));
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
