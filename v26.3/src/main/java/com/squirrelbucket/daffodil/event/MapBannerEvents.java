package com.squirrelbucket.daffodil.event;

import com.squirrelbucket.daffodil.core.ModMapDecorationTypes;
import com.squirrelbucket.daffodil.core.customBlocks.CustomBannerColorProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.component.MapDecorations;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = "daffodil")
public final class MapBannerEvents {
    private MapBannerEvents() {}

    @SubscribeEvent
    public static void onMapUsedOnBanner(PlayerInteractEvent.RightClickBlock event) {
        var player = event.getEntity();
        var stack = player.getItemInHand(event.getHand());
        if (!(stack.getItem() instanceof MapItem) || stack.get(DataComponents.MAP_ID) == null) {
            return;
        }

        BlockState state = player.level().getBlockState(event.getPos());
        if (!(state.getBlock() instanceof CustomBannerColorProvider banner)) {
            return;
        }

        Level level = player.level();
        MapItemSavedData mapData = MapItem.getSavedData(stack, level);
        if (mapData == null) {
            return;
        }

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
        if (level.isClientSide()) {
            return;
        }

        String key = "daffodil_banner-" + event.getPos().getX() + "," + event.getPos().getY() + "," + event.getPos().getZ();
        MapDecorations current = stack.getOrDefault(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY);
        // Preserve all other static decorations on this map item.
        Map<String, MapDecorations.Entry> decorations = new HashMap<>(current.decorations());
        if (decorations.remove(key) != null) {
            stack.set(DataComponents.MAP_DECORATIONS, new MapDecorations(decorations));
            mapData.removeDecoration(key);
            return;
        }

        Holder<MapDecorationType> type = switch (banner.getBannerColor()) {
            case DAFFODIL -> ModMapDecorationTypes.DAFFODIL_BANNER;
            case BURGUNDY -> ModMapDecorationTypes.BURGUNDY_BANNER;
            case SCARLET -> ModMapDecorationTypes.SCARLET_BANNER;
        };
        var pos = event.getPos();
        MapDecorations.Entry entry = new MapDecorations.Entry(type, pos.getX(), pos.getZ(), 180.0F);
        decorations.put(key, entry);
        stack.set(DataComponents.MAP_DECORATIONS, new MapDecorations(decorations));
        mapData.addDecoration(type, level, key, pos.getX(), pos.getZ(), 180.0, null);
    }
}
