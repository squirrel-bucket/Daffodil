package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.customBedBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> DAFFODIL_BLOCK = BLOCKS.register("daffodil_flower",
            () -> new FlowerBlock(MobEffects.CONFUSION, 100, BlockBehaviour.Properties.copy(Blocks.POPPY)));

    public static final RegistryObject<Block> DAFFODIL_WOOL_BLOCK = BLOCKS.register("daffodil_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> VERDANT_WOOL_BLOCK = BLOCKS.register("verdant_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> SCARLET_WOOL_BLOCK = BLOCKS.register("scarlet_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final RegistryObject<Block> DAFFODIL_CARPET_BLOCK = BLOCKS.register("daffodil_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final RegistryObject<Block> VERDANT_CARPET_BLOCK = BLOCKS.register("verdant_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final RegistryObject<Block> SCARLET_CARPET_BLOCK = BLOCKS.register("scarlet_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));

    public static final RegistryObject<Block> DAFFODIL_BED = BLOCKS.register("daffodil_bed",
            () -> new customBedBlock(CustomDyeColors.DAFFODIL, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final RegistryObject<Block> VERDANT_BED = BLOCKS.register("verdant_bed",
            () -> new customBedBlock(CustomDyeColors.VERDANT, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final RegistryObject<Block> SCARLET_BED = BLOCKS.register("scarlet_bed",
            () -> new customBedBlock(CustomDyeColors.SCARLET, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));

    public static final RegistryObject<Block> DAFFODIL_TERRACOTTA = BLOCKS.register("daffodil_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> VERDANT_TERRACOTTA = BLOCKS.register("verdant_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> SCARLET_TERRACOTTA = BLOCKS.register("scarlet_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));

    public static final RegistryObject<Block> DAFFODIL_GLAZED_TERRACOTTA = BLOCKS.register("daffodil_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> VERDANT_GLAZED_TERRACOTTA = BLOCKS.register("verdant_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCARLET_GLAZED_TERRACOTTA = BLOCKS.register("scarlet_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE = BLOCKS.register("daffodil_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> VERDANT_CONCRETE = BLOCKS.register("verdant_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCARLET_CONCRETE = BLOCKS.register("scarlet_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE_POWDER = BLOCKS.register("daffodil_concrete_powder",
            () -> new ConcretePowderBlock(DAFFODIL_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final RegistryObject<Block> VERDANT_CONCRETE_POWDER = BLOCKS.register("verdant_concrete_powder",
            () -> new ConcretePowderBlock(VERDANT_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final RegistryObject<Block> SCARLET_CONCRETE_POWDER = BLOCKS.register("scarlet_concrete_powder",
            () -> new ConcretePowderBlock(SCARLET_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}