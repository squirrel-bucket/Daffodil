package com.squirrelbucket.daffodil.entity;

import com.squirrelbucket.daffodil.core.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class PlumChestBoat extends ChestBoat {
    public PlumChestBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
        setVariant(Boat.Type.OAK);
    }

    @Override
    public Item getDropItem() {
        return ModItems.PLUM_CHEST_BOAT.get();
    }
}
