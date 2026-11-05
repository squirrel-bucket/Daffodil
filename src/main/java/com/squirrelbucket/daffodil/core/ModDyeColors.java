package com.squirrelbucket.daffodil.core;

import net.minecraft.util.StringRepresentable;

public enum ModDyeColors implements StringRepresentable {
    DAFFODIL("daffodil", 0xf9f96b),
    VERDANT("verdant", 0x700725 ),
    SCARLET("scarlet", 0xec241c);

    private final String name;
    private final int rgb;
    private final float[] textureDiffuseColors;

    ModDyeColors(String name, int rgb) {
        this.name = name;
        this.rgb = rgb;
        this.textureDiffuseColors = new float[] {
                ((rgb >> 16) & 255) / 255.0F,
                ((rgb >> 8) & 255) / 255.0F,
                (rgb & 255) / 255.0F
        };
    }

    public String getSerializedName() {
        return name;
    }

    public int getRgb() {
        return rgb;
    }

    public float[] getTextureDiffuseColors() {
        return textureDiffuseColors.clone();
    }
}
