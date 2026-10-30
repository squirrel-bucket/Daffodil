package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.customBlockEntities.customBedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<customBedBlockEntity>> DAFFODIL_BED =
            BLOCK_ENTITIES.register("daffodil_bed", () ->
                    BlockEntityType.Builder.of(customBedBlockEntity::new,
                            ModBlocks.DAFFODIL_BED.get()).build(null));
    public static final RegistryObject<BlockEntityType<customBedBlockEntity>> VERDANT_BED =
            BLOCK_ENTITIES.register("verdant_bed", () ->
                    BlockEntityType.Builder.of(customBedBlockEntity::new,
                            ModBlocks.VERDANT_BED.get()).build(null));
    public static final RegistryObject<BlockEntityType<customBedBlockEntity>> SCARLET_BED =
            BLOCK_ENTITIES.register("scarlet_bed", () ->
                    BlockEntityType.Builder.of(customBedBlockEntity::new,
                            ModBlocks.SCARLET_BED.get()).build(null));
}