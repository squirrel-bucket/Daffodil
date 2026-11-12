package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BoatItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);

    public static final DeferredHolder<Item, Item> DAFFODIL_DYE = ITEMS.register("daffodil_dye",
            () -> new CustomDyeItem(CustomDyeColors.DAFFODIL, itemProperties("daffodil_dye", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_DYE = ITEMS.register("burgundy_dye",
            () -> new CustomDyeItem(CustomDyeColors.BURGUNDY, itemProperties("burgundy_dye", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_DYE = ITEMS.register("scarlet_dye",
            () -> new CustomDyeItem(CustomDyeColors.SCARLET, itemProperties("scarlet_dye", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_BANNER = ITEMS.register("daffodil_banner",
            () -> new CustomBannerItem(ModBlocks.DAFFODIL_BANNER.get(), ModBlocks.DAFFODIL_WALL_BANNER.get(), itemProperties("daffodil_banner", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_BANNER = ITEMS.register("scarlet_banner",
            () -> new CustomBannerItem(ModBlocks.SCARLET_BANNER.get(), ModBlocks.SCARLET_WALL_BANNER.get(), itemProperties("scarlet_banner", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_BANNER = ITEMS.register("burgundy_banner",
            () -> new CustomBannerItem(ModBlocks.BURGUNDY_BANNER.get(), ModBlocks.BURGUNDY_WALL_BANNER.get(), itemProperties("burgundy_banner", new Item.Properties())));


    public static final DeferredHolder<Item, Item> PLUM_LEAVES = ITEMS.register("plum_leaves",
            () -> new BlockItem(ModBlocks.PLUM_LEAVES.get(), itemProperties("plum_leaves", new Item.Properties())));
    public static final DeferredHolder<Item, Item> FLOWERING_PLUM_LEAVES = ITEMS.register("flowering_plum_leaves",
            () -> new BlockItem(ModBlocks.FLOWERING_PLUM_LEAVES.get(), itemProperties("flowering_plum_leaves", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_SAPLING = ITEMS.register("plum_sapling",
            () -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), itemProperties("plum_sapling", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM = ITEMS.register("plum",
            () -> new Item(itemProperties("plum", new Item.Properties()).food(ModFoods.PLUM)));

    public static final DeferredHolder<Item, Item> PLUM_PLANKS = ModItems.ITEMS.register("plum_planks", () -> new BlockItem(ModBlocks.PLUM_PLANKS.get(), itemProperties("plum_planks", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_LOG = ModItems.ITEMS.register("plum_log", () -> new BlockItem(ModBlocks.PLUM_LOG.get(), itemProperties("plum_log", new Item.Properties())));
    public static final DeferredHolder<Item, Item> STRIPPED_PLUM_LOG = ModItems.ITEMS.register("stripped_plum_log", () -> new BlockItem(ModBlocks.STRIPPED_PLUM_LOG.get(), itemProperties("stripped_plum_log", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_WOOD = ModItems.ITEMS.register("plum_wood", () -> new BlockItem(ModBlocks.PLUM_WOOD.get(), itemProperties("plum_wood", new Item.Properties())));
    public static final DeferredHolder<Item, Item> STRIPPED_PLUM_WOOD = ModItems.ITEMS.register("stripped_plum_wood", () -> new BlockItem(ModBlocks.STRIPPED_PLUM_WOOD.get(), itemProperties("stripped_plum_wood", new Item.Properties())));

    public static final DeferredHolder<Item, Item> PLUM_STAIRS = ModItems.ITEMS.register("plum_stairs", () -> new BlockItem(ModBlocks.PLUM_STAIRS.get(), itemProperties("plum_stairs", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_SLAB = ModItems.ITEMS.register("plum_slab", () -> new BlockItem(ModBlocks.PLUM_SLAB.get(), itemProperties("plum_slab", new Item.Properties())));

    public static final DeferredHolder<Item, Item> PLUM_TRAPDOOR = ModItems.ITEMS.register("plum_trapdoor", () -> new BlockItem(ModBlocks.PLUM_TRAPDOOR.get(), itemProperties("plum_trapdoor", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_BUTTON = ModItems.ITEMS.register("plum_button", () -> new BlockItem(ModBlocks.PLUM_BUTTON.get(), itemProperties("plum_button", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_PRESSURE_PLATE = ModItems.ITEMS.register("plum_pressure_plate", () -> new BlockItem(ModBlocks.PLUM_PRESSURE_PLATE.get(), itemProperties("plum_pressure_plate", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_DOOR = ModItems.ITEMS.register("plum_door", () -> new BlockItem(ModBlocks.PLUM_DOOR.get(), itemProperties("plum_door", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_FENCE = ModItems.ITEMS.register("plum_fence", () -> new BlockItem(ModBlocks.PLUM_FENCE.get(), itemProperties("plum_fence", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_FENCE_GATE = ModItems.ITEMS.register("plum_fence_gate", () -> new BlockItem(ModBlocks.PLUM_FENCE_GATE.get(), itemProperties("plum_fence_gate", new Item.Properties())));

    public static final DeferredHolder<Item, Item> PLUM_SIGN = ITEMS.register("plum_sign",
            () -> new StandingAndWallBlockItem(ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get(), Direction.UP, itemProperties("plum_sign", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_HANGING_SIGN = ITEMS.register("plum_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get(), itemProperties("plum_hanging_sign", new Item.Properties())));
    public static final DeferredHolder<Item, Item> PLUM_BOAT = ITEMS.register("plum_boat",
            () -> new BoatItem(ModEntities.PLUM_BOAT.get(), itemProperties("plum_boat", new Item.Properties()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> PLUM_CHEST_BOAT = ITEMS.register("plum_chest_boat",
            () -> new BoatItem(ModEntities.PLUM_CHEST_BOAT.get(), itemProperties("plum_chest_boat", new Item.Properties()).stacksTo(1)));

    public static final DeferredHolder<Item, Item> DAFFODIL_ITEM = ITEMS.register("daffodil_flower",
            () -> new BlockItem(ModBlocks.DAFFODIL_BLOCK.get(), itemProperties("daffodil_flower", new Item.Properties())));
    public static final DeferredHolder<Item, Item> HIBISCUS_ITEM = ITEMS.register("hibiscus_flower",
            () -> new BlockItem(ModBlocks.HIBISCUS_BLOCK.get(), itemProperties("hibiscus_flower", new Item.Properties())));
    public static final DeferredHolder<Item, Item> GOJI_BERRIES = ITEMS.register("goji_berries",
            () -> new BlockItem(ModBlocks.GOJI_BERRY_BUSH.get(), itemProperties("goji_berries", new Item.Properties()).food(ModFoods.GOJI_BERRIES)));

    public static final DeferredHolder<Item, Item> DAFFODIL_WOOL_ITEM = ITEMS.register("daffodil_wool",
            () -> new BlockItem(ModBlocks.DAFFODIL_WOOL_BLOCK.get(), itemProperties("daffodil_wool", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_WOOL_ITEM = ITEMS.register("burgundy_wool",
            () -> new BlockItem(ModBlocks.BURGUNDY_WOOL_BLOCK.get(), itemProperties("burgundy_wool", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_WOOL_ITEM = ITEMS.register("scarlet_wool",
            () -> new BlockItem(ModBlocks.SCARLET_WOOL_BLOCK.get(), itemProperties("scarlet_wool", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_CARPET_ITEM = ITEMS.register("daffodil_carpet",
            () -> new BlockItem(ModBlocks.DAFFODIL_CARPET_BLOCK.get(), itemProperties("daffodil_carpet", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_CARPET_ITEM = ITEMS.register("burgundy_carpet",
            () -> new BlockItem(ModBlocks.BURGUNDY_CARPET_BLOCK.get(), itemProperties("burgundy_carpet", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_CARPET_ITEM = ITEMS.register("scarlet_carpet",
            () -> new BlockItem(ModBlocks.SCARLET_CARPET_BLOCK.get(), itemProperties("scarlet_carpet", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_BED_ITEM = ITEMS.register("daffodil_bed",
            () -> new ModBedItem(ModBlocks.DAFFODIL_BED.get(), itemProperties("daffodil_bed", new Item.Properties().stacksTo(1))));
    public static final DeferredHolder<Item, Item> BURGUNDY_BED_ITEM = ITEMS.register("burgundy_bed",
            () -> new ModBedItem(ModBlocks.BURGUNDY_BED.get(), itemProperties("burgundy_bed", new Item.Properties().stacksTo(1))));
    public static final DeferredHolder<Item, Item> SCARLET_BED = ITEMS.register("scarlet_bed",
            () -> new ModBedItem(ModBlocks.SCARLET_BED.get(), itemProperties("scarlet_bed", new Item.Properties().stacksTo(1))));


    public static final DeferredHolder<Item, Item> DAFFODIL_TERRACOTTA_ITEM = ITEMS.register("daffodil_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_TERRACOTTA.get(), itemProperties("daffodil_terracotta", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_TERRACOTTA_ITEM = ITEMS.register("burgundy_terracotta",
            () -> new BlockItem(ModBlocks.BURGUNDY_TERRACOTTA.get(), itemProperties("burgundy_terracotta", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_TERRACOTTA_ITEM = ITEMS.register("scarlet_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_TERRACOTTA.get(), itemProperties("scarlet_terracotta", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_GLAZED_TERRACOTTA_ITEM = ITEMS.register("daffodil_glazed_terracotta",
            () -> new BlockItem(ModBlocks.DAFFODIL_GLAZED_TERRACOTTA.get(), itemProperties("daffodil_glazed_terracotta", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_GLAZED_TERRACOTTA_ITEM = ITEMS.register("burgundy_glazed_terracotta",
            () -> new BlockItem(ModBlocks.BURGUNDY_GLAZED_TERRACOTTA.get(), itemProperties("burgundy_glazed_terracotta", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_GLAZED_TERRACOTTA_ITEM = ITEMS.register("scarlet_glazed_terracotta",
            () -> new BlockItem(ModBlocks.SCARLET_GLAZED_TERRACOTTA.get(), itemProperties("scarlet_glazed_terracotta", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_CONCRETE_ITEM = ITEMS.register("daffodil_concrete",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE.get(), itemProperties("daffodil_concrete", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_CONCRETE_ITEM = ITEMS.register("burgundy_concrete",
            () -> new BlockItem(ModBlocks.BURGUNDY_CONCRETE.get(), itemProperties("burgundy_concrete", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_CONCRETE_ITEM = ITEMS.register("scarlet_concrete",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE.get(), itemProperties("scarlet_concrete", new Item.Properties())));

    public static final DeferredHolder<Item, Item> DAFFODIL_CONCRETE_POWDER_ITEM = ITEMS.register("daffodil_concrete_powder",
            () -> new BlockItem(ModBlocks.DAFFODIL_CONCRETE_POWDER.get(), itemProperties("daffodil_concrete_powder", new Item.Properties())));
    public static final DeferredHolder<Item, Item> BURGUNDY_CONCRETE_POWDER_ITEM = ITEMS.register("burgundy_concrete_powder",
            () -> new BlockItem(ModBlocks.BURGUNDY_CONCRETE_POWDER.get(), itemProperties("burgundy_concrete_powder", new Item.Properties())));
    public static final DeferredHolder<Item, Item> SCARLET_CONCRETE_POWDER_ITEM = ITEMS.register("scarlet_concrete_powder",
            () -> new BlockItem(ModBlocks.SCARLET_CONCRETE_POWDER.get(), itemProperties("scarlet_concrete_powder", new Item.Properties())));

    private static Item.Properties itemProperties(String name, Item.Properties properties) {
        return properties.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
