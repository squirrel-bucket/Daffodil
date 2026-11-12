package com.squirrelbucket.daffodil.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class PlumChestBoat extends ChestBoat {
    public PlumChestBoat(EntityType<? extends ChestBoat> entityType, Level level) {
        super(entityType, level, () -> com.squirrelbucket.daffodil.core.ModItems.PLUM_CHEST_BOAT.get());
    }
}
