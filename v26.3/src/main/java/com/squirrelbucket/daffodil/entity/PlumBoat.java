package com.squirrelbucket.daffodil.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.level.Level;

public class PlumBoat extends Boat {
    public PlumBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, () -> com.squirrelbucket.daffodil.core.ModItems.PLUM_BOAT.get());
    }
}
