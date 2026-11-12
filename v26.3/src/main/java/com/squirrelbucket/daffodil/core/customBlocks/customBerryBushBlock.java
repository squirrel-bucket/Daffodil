package com.squirrelbucket.daffodil.core.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class customBerryBushBlock extends SweetBerryBushBlock {
    private final Supplier<Item> berryItem;
    private static final VoxelShape[] SHAPES = {
            Block.box(3.5, 0, 3.5, 12.5, 6, 12.5),
            Block.box(2.5, 0, 2.5, 13.5, 9, 13.5),
            Block.box(2, 0, 2, 14, 11, 14),
            Block.box(1, 0, 1, 15, 16, 15)
    };

    public customBerryBushBlock(Properties properties, Supplier<Item> berryItem) {
        super(properties);
        this.berryItem = berryItem;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(AGE)];
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(berryItem.get());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(AGE);
        if (age <= 1) return InteractionResult.PASS;
        if (level instanceof ServerLevel server) {
            int count = 1 + server.getRandom().nextInt(2) + (age == 3 ? 1 : 0);
            popResource(level, pos, new ItemStack(berryItem.get(), count));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                    1.0F, 0.8F + server.getRandom().nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(AGE, 1), 2);
        }
        return InteractionResult.SUCCESS;
    }
}