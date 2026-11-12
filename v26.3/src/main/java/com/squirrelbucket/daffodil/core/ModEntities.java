package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.entity.PlumBoat;
import com.squirrelbucket.daffodil.entity.PlumChestBoat;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, ModBlocks.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<PlumBoat>> PLUM_BOAT = ENTITY_TYPES.register("plum_boat",
            () -> EntityType.Builder.of(PlumBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10).updateInterval(3)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ModBlocks.MODID, "plum_boat"))));

    public static final DeferredHolder<EntityType<?>, EntityType<PlumChestBoat>> PLUM_CHEST_BOAT = ENTITY_TYPES.register("plum_chest_boat",
            () -> EntityType.Builder.of(PlumChestBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10).updateInterval(3)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ModBlocks.MODID, "plum_chest_boat"))));

    private ModEntities() {}
}