package com.squirrelbucket.daffodil.client;

import net.minecraft.util.StringRepresentable;

public enum CustomDyeColors implements StringRepresentable {
    DAFFODIL("daffodil"),
    VERDANT("verdant"),
    SCARLET("scarlet");

    private final String name;

    CustomDyeColors(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
