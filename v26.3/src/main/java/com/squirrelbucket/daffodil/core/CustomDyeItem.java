package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeItem;

public class CustomDyeItem extends DyeItem {
    private final CustomDyeColors customColor;

    public CustomDyeItem(CustomDyeColors customColor, Properties properties) {
        super(properties.component(DataComponents.DYE, customColor.getVanillaCarrier()));
        this.customColor = customColor;
    }

    public CustomDyeColors getCustomColor() { return customColor; }
}
