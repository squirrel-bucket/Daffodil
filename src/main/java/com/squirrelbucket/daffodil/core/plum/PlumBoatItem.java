package com.squirrelbucket.daffodil.core.plum;

import com.squirrelbucket.daffodil.core.ModEntities;
import com.squirrelbucket.daffodil.entity.PlumBoat;
import com.squirrelbucket.daffodil.entity.PlumChestBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class PlumBoatItem extends Item {
    private final boolean chestBoat;

    public PlumBoatItem(boolean chestBoat, Properties properties) {
        super(properties);
        this.chestBoat = chestBoat;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult hit = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hit.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        }

        Vec3 view = player.getViewVector(1.0F);
        AABB searchBox = player.getBoundingBox().expandTowards(view.scale(5.0D)).inflate(1.0D);
        for (Entity entity : level.getEntities(player, searchBox,
                candidate -> !candidate.isSpectator() && candidate.isPickable())) {
            if (entity.getBoundingBox().inflate(entity.getPickRadius()).contains(player.getEyePosition())) {
                return InteractionResultHolder.pass(stack);
            }
        }

        if (hit.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        }

        Vec3 location = hit.getLocation();
        Boat boat = chestBoat
                ? new PlumChestBoat(ModEntities.PLUM_CHEST_BOAT.get(), level)
                : new PlumBoat(ModEntities.PLUM_BOAT.get(), level);
        boat.setPos(location.x, location.y, location.z);
        boat.setYRot(player.getYRot());
        if (!level.noCollision(boat, boat.getBoundingBox())) {
            return InteractionResultHolder.fail(stack);
        }

        if (!level.isClientSide) {
            level.addFreshEntity(boat);
        }
        level.gameEvent(player, GameEvent.ENTITY_PLACE, location);
        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}
