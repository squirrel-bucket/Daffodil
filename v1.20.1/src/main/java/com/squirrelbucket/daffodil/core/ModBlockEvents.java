package com.squirrelbucket.daffodil.core;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "daffodil", bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ModBlockEvents {
    private ModBlockEvents() {
    }

    @SubscribeEvent
    public static void onToolModification(BlockEvent.BlockToolModificationEvent event) {
        if (event.getToolAction() != ToolActions.AXE_STRIP) {
            return;
        }

        BlockState originalState = event.getState();
        if (originalState.is(ModBlocks.PLUM_LOG.get())) {
            event.setFinalState(ModBlocks.STRIPPED_PLUM_LOG.get()
                    .defaultBlockState()
                    .setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)));
        } else if (originalState.is(ModBlocks.PLUM_WOOD.get())) {
            event.setFinalState(ModBlocks.STRIPPED_PLUM_WOOD.get()
                    .defaultBlockState()
                    .setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)));
        }
    }
}
