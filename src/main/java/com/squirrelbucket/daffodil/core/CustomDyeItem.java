package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;

public class CustomDyeItem extends DyeItem {
    private final CustomDyeColors customColor;

    public CustomDyeItem(CustomDyeColors customColor, DyeColor loomColor, Properties properties) {
        super(loomColor, properties);
        this.customColor = customColor;
    }

    public CustomDyeColors getCustomColor() {
        return customColor;
    }
}
