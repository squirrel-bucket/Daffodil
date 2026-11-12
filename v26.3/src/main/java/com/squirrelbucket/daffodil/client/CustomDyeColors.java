package com.squirrelbucket.daffodil.client;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;

public enum CustomDyeColors implements StringRepresentable {
    // Vanilla's loom and banner/bed components still store one of the sixteen
    // DyeColor values. These distinct carrier colors let the custom colors pass
    // through those vanilla systems without collapsing every block to yellow.
    DAFFODIL("daffodil", 0xf9f96b, DyeColor.YELLOW),
    BURGUNDY("burgundy", 0x700725, DyeColor.BROWN),
    SCARLET("scarlet", 0xec241c, DyeColor.RED);

    private final String name;
    private final int rgb;
    private final float[] textureDiffuseColors;
    private final DyeColor vanillaCarrier;

    CustomDyeColors(String name, int rgb, DyeColor vanillaCarrier) {
        this.name = name;
        this.rgb = rgb;
        this.vanillaCarrier = vanillaCarrier;
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
        return 0xFF000000 | rgb;
    }

    public DyeColor getVanillaCarrier() {
        return vanillaCarrier;
    }

    public float[] getTextureDiffuseColors() {
        return textureDiffuseColors.clone();
    }
}
