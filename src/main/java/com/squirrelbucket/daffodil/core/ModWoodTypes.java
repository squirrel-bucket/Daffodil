package com.squirrelbucket.daffodil.core;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {

    public static final String MOD_WOOD_ID = "daffodil:plum";

    public static final BlockSetType PLUM_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType("daffodil:plum_wood"));
    public static final WoodType PLUM_WOOD_TYPE = WoodType.register(new WoodType(MOD_WOOD_ID, PLUM_BLOCK_SET_TYPE));
}
