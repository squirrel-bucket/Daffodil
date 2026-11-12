package com.squirrelbucket.daffodil.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;

public final class ModFeatures {
    public static final ResourceKey<Feature> PLUM_TREE = ResourceKey.create(
            Registries.FEATURE,
            Identifier.fromNamespaceAndPath("daffodil", "plum_tree")
    );

    private ModFeatures() {
    }
}
