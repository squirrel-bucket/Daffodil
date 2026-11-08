package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.entity.PlumBoat;
import com.squirrelbucket.daffodil.entity.PlumChestBoat;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModBlocks.MODID);

    public static final RegistryObject<EntityType<PlumBoat>> PLUM_BOAT = ENTITY_TYPES.register("plum_boat",
            () -> EntityType.Builder.of(PlumBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10).updateInterval(3).build("plum_boat"));
    public static final RegistryObject<EntityType<PlumChestBoat>> PLUM_CHEST_BOAT = ENTITY_TYPES.register("plum_chest_boat",
            () -> EntityType.Builder.of(PlumChestBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10).updateInterval(3).build("plum_chest_boat"));

    private ModEntities() {
    }
}
