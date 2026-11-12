package com.squirrelbucket.daffodil.worldgen.tree;

import com.squirrelbucket.daffodil.worldgen.ModFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public final class PlumTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "daffodil_plum",
            WeightedList.of(ModFeatures.PLUM_TREE),
            WeightedList.of(),
            WeightedList.of(),
            ModFeatures.PLUM_TREE
    );

    private PlumTreeGrower() {
    }
}
