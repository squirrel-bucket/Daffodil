package com.squirrelbucket.daffodil.client.renderer;

import com.mojang.datafixers.util.Pair;
import com.squirrelbucket.daffodil.Daffodil;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class PlumBoatRenderer extends BoatRenderer {
    private static final ResourceLocation BOAT_TEXTURE = new ResourceLocation(Daffodil.MODID, "textures/entity/boat/plum.png");
    private static final ResourceLocation CHEST_BOAT_TEXTURE = new ResourceLocation(Daffodil.MODID, "textures/entity/chest_boat/plum.png");
    private final boolean chestBoat;

    public PlumBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context, chestBoat);
        this.chestBoat = chestBoat;
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        Pair<ResourceLocation, ListModel<Boat>> vanillaModel = super.getModelWithLocation(boat);
        ResourceLocation texture = chestBoat ? CHEST_BOAT_TEXTURE : BOAT_TEXTURE;
        return Pair.of(texture, vanillaModel.getSecond());
    }
}
