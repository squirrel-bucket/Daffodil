package com.squirrelbucket.daffodil.client.renderer;

import com.squirrelbucket.daffodil.Daffodil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.AbstractBoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.resources.Identifier;

/** Renders the custom hull with the standard oak geometry and Daffodil texture. */
public final class PlumBoatRenderer extends AbstractBoatRenderer {
    private static final ModelLayerLocation BOAT_LAYER = ModelLayers.OAK_BOAT;
    private static final ModelLayerLocation CHEST_BOAT_LAYER = ModelLayers.OAK_CHEST_BOAT;
    private final EntityModel<BoatRenderState> model;

    public PlumBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context, Identifier.fromNamespaceAndPath(Daffodil.MODID, chestBoat
                ? "textures/entity/chest_boat/plum.png"
                : "textures/entity/boat/plum.png"));
        this.model = new BoatModel(context.bakeLayer(chestBoat ? CHEST_BOAT_LAYER : BOAT_LAYER));
    }

    @Override
    protected EntityModel<BoatRenderState> model() {
        return model;
    }
}
