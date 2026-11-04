package com.squirrelbucket.daffodil.core.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class customBerryBushBlock extends SweetBerryBushBlock {

    private final Supplier<Item> berryItem;

    public customBerryBushBlock(Properties properties, Supplier<Item> berryItem) {
        super(properties);
        this.berryItem = berryItem;
    }

    private static final VoxelShape BUSH_SHAPE_0 =
            Block.box(3.5D, 0.0D, 3.5D, 12.5D, 6.0D, 12.5D);

    private static final VoxelShape BUSH_SHAPE_1 =
            Block.box(2.5D, 0.0D, 2.5D, 13.5D, 9.0D, 13.5D);

    private static final VoxelShape BUSH_SHAPE_2 =
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 11.0D, 14.0D);

    private static final VoxelShape BUSH_SHAPE_3 =
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);




    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level,
                               BlockPos pos, CollisionContext context) {

        if (state.getValue(AGE) == 0) {
            return BUSH_SHAPE_0;
        }
        else if (state.getValue(AGE) == 1) {
            return BUSH_SHAPE_1;
        }
        else if (state.getValue(AGE) == 2) {
            return BUSH_SHAPE_2;
        }
        else {
            return state.getValue(AGE) < 3
                    ? BUSH_SHAPE_3
                    : super.getShape(state, level, pos, context);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // Intentionally empty
    }
    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(berryItem.get());
    }
    @Override
    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(berryItem.get(), j + (flag ? 1 : 0)));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            BlockState blockstate = p_57275_.setValue(AGE, Integer.valueOf(1));
            p_57276_.setBlock(p_57277_, blockstate, 2);
            p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }
}
