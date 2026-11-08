package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.customBlockEntities.customBannerBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.customBedBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.PlumSignBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.PlumHangingSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final String MODID = "daffodil";

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<customBedBlockEntity>> CUSTOM_BED =
            BLOCK_ENTITIES.register("custom_bed", () ->
                    BlockEntityType.Builder.of(
                            customBedBlockEntity::new,
                            ModBlocks.DAFFODIL_BED.get(),
                            ModBlocks.BURGUNDY_BED.get(),
                            ModBlocks.SCARLET_BED.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<customBannerBlockEntity>> CUSTOM_BANNER =
            BLOCK_ENTITIES.register("custom_banner", () ->
                    BlockEntityType.Builder.of(
                            customBannerBlockEntity::new,
                            ModBlocks.DAFFODIL_BANNER.get(),
                            ModBlocks.BURGUNDY_BANNER.get(),
                            ModBlocks.SCARLET_BANNER.get(),
                            ModBlocks.DAFFODIL_WALL_BANNER.get(),
                            ModBlocks.BURGUNDY_WALL_BANNER.get(),
                            ModBlocks.SCARLET_WALL_BANNER.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<PlumSignBlockEntity>> PLUM_SIGN = BLOCK_ENTITIES.register("plum_sign",
            () -> BlockEntityType.Builder.of(PlumSignBlockEntity::new,
                    ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<PlumHangingSignBlockEntity>> PLUM_HANGING_SIGN = BLOCK_ENTITIES.register("plum_hanging_sign",
            () -> BlockEntityType.Builder.of(PlumHangingSignBlockEntity::new,
                    ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get()).build(null));
}
