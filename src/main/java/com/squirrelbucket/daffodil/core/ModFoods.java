package com.squirrelbucket.daffodil.core;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ModFoods {
    public static final FoodProperties GOJI_BERRIES = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1f)
            .build();

    public static final FoodProperties PLUM = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .build();
}