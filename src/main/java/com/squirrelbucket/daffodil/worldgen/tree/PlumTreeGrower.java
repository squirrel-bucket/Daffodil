package com.squirrelbucket.daffodil.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import com.squirrelbucket.daffodil.worldgen.ModConfiguredFeatures;

public class PlumTreeGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(
            RandomSource random,
            boolean hasFlowers) {

        return ModConfiguredFeatures.PLUM_TREE;
    }
}