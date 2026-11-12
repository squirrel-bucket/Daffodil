package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.customBlockEntities.customBannerBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.PlumSignBlockEntity;
import com.squirrelbucket.daffodil.customBlockEntities.PlumHangingSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {

    public static final String MODID = "daffodil";

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<customBannerBlockEntity>> CUSTOM_BANNER =
            BLOCK_ENTITIES.register("custom_banner", () ->
                    new BlockEntityType<>(
                            customBannerBlockEntity::new,
                            ModBlocks.DAFFODIL_BANNER.get(),
                            ModBlocks.BURGUNDY_BANNER.get(),
                            ModBlocks.SCARLET_BANNER.get(),
                            ModBlocks.DAFFODIL_WALL_BANNER.get(),
                            ModBlocks.BURGUNDY_WALL_BANNER.get(),
                            ModBlocks.SCARLET_WALL_BANNER.get()
                    ));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlumSignBlockEntity>> PLUM_SIGN = BLOCK_ENTITIES.register("plum_sign",
            () -> new BlockEntityType<>(PlumSignBlockEntity::new,
                    ModBlocks.PLUM_SIGN.get(), ModBlocks.PLUM_WALL_SIGN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlumHangingSignBlockEntity>> PLUM_HANGING_SIGN = BLOCK_ENTITIES.register("plum_hanging_sign",
            () -> new BlockEntityType<>(PlumHangingSignBlockEntity::new,
                    ModBlocks.PLUM_HANGING_SIGN.get(), ModBlocks.PLUM_WALL_HANGING_SIGN.get()));
}
