package com.squirrelbucket.daffodil.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_TREE =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    new ResourceLocation("daffodil", "plum_tree")
            );

}