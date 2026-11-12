package com.squirrelbucket.daffodil.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModMapDecorationTypes {
    public static final DeferredRegister<MapDecorationType> TYPES =
            DeferredRegister.create(Registries.MAP_DECORATION_TYPE, ModItems.MODID);

    public static final DeferredHolder<MapDecorationType, MapDecorationType> DAFFODIL_BANNER = register("daffodil_banner");
    public static final DeferredHolder<MapDecorationType, MapDecorationType> BURGUNDY_BANNER = register("burgundy_banner");
    public static final DeferredHolder<MapDecorationType, MapDecorationType> SCARLET_BANNER = register("scarlet_banner");

    private ModMapDecorationTypes() {}

    private static DeferredHolder<MapDecorationType, MapDecorationType> register(String name) {
        return TYPES.register(name, () -> new MapDecorationType(
                Identifier.fromNamespaceAndPath(ModItems.MODID, name), true, true));
    }
}
