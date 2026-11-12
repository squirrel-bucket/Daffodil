package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.customBannerBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customWallBannerBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customBedBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customBerryBushBlock;
import com.squirrelbucket.daffodil.core.customBlocks.HibiscusFlowerBlock;
import com.squirrelbucket.daffodil.core.plum.PlumSaplingBlock;
import com.squirrelbucket.daffodil.core.plum.PlumCeilingHangingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumStandingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumWallHangingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumWallSignBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlocks {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MODID);

    public static final DeferredHolder<Block, Block> PLUM_LEAVES = BLOCKS.register("plum_leaves",
            () -> new LeavesBlock(net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer.noAmbientSound(), blockProperties("plum_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES))));
    public static final DeferredHolder<Block, Block> FLOWERING_PLUM_LEAVES = BLOCKS.register("flowering_plum_leaves",
            () -> new LeavesBlock(net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer.noAmbientSound(), blockProperties("flowering_plum_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWERING_AZALEA_LEAVES))));
    public static final DeferredHolder<Block, Block> PLUM_SAPLING = BLOCKS.register("plum_sapling",
            () -> new PlumSaplingBlock(blockProperties("plum_sapling", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING))));
    public static final DeferredHolder<Block, Block> PLUM_PLANKS = BLOCKS.register("plum_planks",
            () -> new Block(blockProperties("plum_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
    public static final DeferredHolder<Block, Block> PLUM_LOG = BLOCKS.register("plum_log",
            () -> new RotatedPillarBlock(blockProperties("plum_log", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))));
    public static final DeferredHolder<Block, Block> STRIPPED_PLUM_LOG = BLOCKS.register("stripped_plum_log",
            () -> new RotatedPillarBlock(blockProperties("stripped_plum_log", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG))));
    public static final DeferredHolder<Block, Block> PLUM_WOOD = BLOCKS.register("plum_wood",
            () -> new RotatedPillarBlock(blockProperties("plum_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD))));
    public static final DeferredHolder<Block, Block> STRIPPED_PLUM_WOOD = BLOCKS.register("stripped_plum_wood",
            () -> new RotatedPillarBlock(blockProperties("stripped_plum_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD))));

    public static final DeferredHolder<Block, Block> PLUM_STAIRS = BLOCKS.register("plum_stairs",
            () -> new StairBlock(PLUM_PLANKS.get().defaultBlockState(), blockProperties("plum_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS))));
    public static final DeferredHolder<Block, Block> PLUM_SLAB = BLOCKS.register("plum_slab",
            () -> new SlabBlock(blockProperties("plum_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB))));

    public static final DeferredHolder<Block, Block> PLUM_TRAPDOOR = BLOCKS.register("plum_trapdoor",
            () -> new TrapDoorBlock(ModWoodTypes.PLUM_BLOCK_SET_TYPE, blockProperties("plum_trapdoor", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR))));
    public static final DeferredHolder<Block, Block> PLUM_BUTTON = BLOCKS.register("plum_button",
            () -> new ButtonBlock(ModWoodTypes.PLUM_BLOCK_SET_TYPE, 30, blockProperties("plum_button", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON))));
    public static final DeferredHolder<Block, Block> PLUM_PRESSURE_PLATE = BLOCKS.register("plum_pressure_plate",
            () -> new PressurePlateBlock(ModWoodTypes.PLUM_BLOCK_SET_TYPE, blockProperties("plum_pressure_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))));
    public static final DeferredHolder<Block, Block> PLUM_DOOR = BLOCKS.register("plum_door",
            () -> new DoorBlock(ModWoodTypes.PLUM_BLOCK_SET_TYPE, blockProperties("plum_door", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR))));
    public static final DeferredHolder<Block, Block> PLUM_FENCE = BLOCKS.register("plum_fence",
            () -> new FenceBlock(blockProperties("plum_fence", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE))));
    public static final DeferredHolder<Block, Block> PLUM_FENCE_GATE = BLOCKS.register("plum_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.PLUM_WOOD_TYPE, blockProperties("plum_fence_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE))));

    public static final DeferredHolder<Block, Block> PLUM_SIGN = BLOCKS.register("plum_sign",
            () -> new PlumStandingSignBlock(blockProperties("plum_sign", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final DeferredHolder<Block, Block> PLUM_WALL_SIGN = BLOCKS.register("plum_wall_sign",
            () -> new PlumWallSignBlock(blockProperties("plum_wall_sign", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final DeferredHolder<Block, Block> PLUM_HANGING_SIGN = BLOCKS.register("plum_hanging_sign",
            () -> new PlumCeilingHangingSignBlock(blockProperties("plum_hanging_sign", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final DeferredHolder<Block, Block> PLUM_WALL_HANGING_SIGN = BLOCKS.register("plum_wall_hanging_sign",
            () -> new PlumWallHangingSignBlock(blockProperties("plum_wall_hanging_sign", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)), ModWoodTypes.PLUM_WOOD_TYPE));

    public static final DeferredHolder<Block, Block> DAFFODIL_BLOCK = BLOCKS.register("daffodil_flower",
            () -> new FlowerBlock(MobEffects.NAUSEA, 100, blockProperties("daffodil_flower", BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY))));
    public static final DeferredHolder<Block, Block> HIBISCUS_BLOCK = BLOCKS.register("hibiscus_flower",
            () -> new HibiscusFlowerBlock(MobEffects.REGENERATION, 100, blockProperties("hibiscus_flower", BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY))
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .lightLevel((blockState) -> 7) ));

    public static final DeferredHolder<Block, Block> GOJI_BERRY_BUSH =
            BLOCKS.register("goji_berry_bush", () ->
                    new customBerryBushBlock(
                            blockProperties("goji_berry_bush", BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)),
                            ModItems.GOJI_BERRIES::get
                    )
            );

    public static final DeferredHolder<Block, Block> DAFFODIL_WOOL_BLOCK = BLOCKS.register("daffodil_wool",
            () -> new Block(blockProperties("daffodil_wool", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_WOOL_BLOCK = BLOCKS.register("burgundy_wool",
            () -> new Block(blockProperties("burgundy_wool", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_WOOL_BLOCK = BLOCKS.register("scarlet_wool",
            () -> new Block(blockProperties("scarlet_wool", BlockBehaviour.Properties.of()).strength(1.0F)));

    public static final DeferredHolder<Block, Block> DAFFODIL_CARPET_BLOCK = BLOCKS.register("daffodil_carpet",
            () -> new ModCarpetBlock(blockProperties("daffodil_carpet", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_CARPET_BLOCK = BLOCKS.register("burgundy_carpet",
            () -> new ModCarpetBlock(blockProperties("burgundy_carpet", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_CARPET_BLOCK = BLOCKS.register("scarlet_carpet",
            () -> new ModCarpetBlock(blockProperties("scarlet_carpet", BlockBehaviour.Properties.of()).strength(1.0F)));

    public static final DeferredHolder<Block, Block> DAFFODIL_BANNER = BLOCKS.register("daffodil_banner",
            () -> new customBannerBlock(CustomDyeColors.DAFFODIL, blockProperties("daffodil_banner", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_BANNER = BLOCKS.register("burgundy_banner",
            () -> new customBannerBlock(CustomDyeColors.BURGUNDY, blockProperties("burgundy_banner", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_BANNER = BLOCKS.register("scarlet_banner",
            () -> new customBannerBlock(CustomDyeColors.SCARLET, blockProperties("scarlet_banner", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> DAFFODIL_WALL_BANNER = BLOCKS.register("daffodil_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.DAFFODIL, blockProperties("daffodil_wall_banner", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_WALL_BANNER = BLOCKS.register("scarlet_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.SCARLET, blockProperties("scarlet_wall_banner", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_WALL_BANNER = BLOCKS.register("burgundy_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.BURGUNDY, blockProperties("burgundy_wall_banner", BlockBehaviour.Properties.of()).strength(1.0F)));

    public static final DeferredHolder<Block, Block> DAFFODIL_BED = BLOCKS.register("daffodil_bed",
            () -> new customBedBlock(CustomDyeColors.DAFFODIL, blockProperties("daffodil_bed", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_BED = BLOCKS.register("burgundy_bed",
            () -> new customBedBlock(CustomDyeColors.BURGUNDY, blockProperties("burgundy_bed", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_BED = BLOCKS.register("scarlet_bed",
            () -> new customBedBlock(CustomDyeColors.SCARLET, blockProperties("scarlet_bed", BlockBehaviour.Properties.of()).strength(1.0F)));
    
    public static final DeferredHolder<Block, Block> DAFFODIL_TERRACOTTA = BLOCKS.register("daffodil_terracotta",
            () -> new Block(blockProperties("daffodil_terracotta", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_TERRACOTTA = BLOCKS.register("burgundy_terracotta",
            () -> new Block(blockProperties("burgundy_terracotta", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_TERRACOTTA = BLOCKS.register("scarlet_terracotta",
            () -> new Block(blockProperties("scarlet_terracotta", BlockBehaviour.Properties.of()).strength(1.0F)));

    public static final DeferredHolder<Block, Block> DAFFODIL_GLAZED_TERRACOTTA = BLOCKS.register("daffodil_glazed_terracotta",
            () -> new GlazedTerracottaBlock(blockProperties("daffodil_glazed_terracotta", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> BURGUNDY_GLAZED_TERRACOTTA = BLOCKS.register("burgundy_glazed_terracotta",
            () -> new GlazedTerracottaBlock(blockProperties("burgundy_glazed_terracotta", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> SCARLET_GLAZED_TERRACOTTA = BLOCKS.register("scarlet_glazed_terracotta",
            () -> new GlazedTerracottaBlock(blockProperties("scarlet_glazed_terracotta", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));

    public static final DeferredHolder<Block, Block> DAFFODIL_CONCRETE = BLOCKS.register("daffodil_concrete",
            () -> new Block(blockProperties("daffodil_concrete", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> BURGUNDY_CONCRETE = BLOCKS.register("burgundy_concrete",
            () -> new Block(blockProperties("burgundy_concrete", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> SCARLET_CONCRETE = BLOCKS.register("scarlet_concrete",
            () -> new Block(blockProperties("scarlet_concrete", BlockBehaviour.Properties.of()).strength(1.0F).requiresCorrectToolForDrops()));

    public static final DeferredHolder<Block, Block> DAFFODIL_CONCRETE_POWDER = BLOCKS.register("daffodil_concrete_powder",
            () -> new ConcretePowderBlock(DAFFODIL_CONCRETE.get(), blockProperties("daffodil_concrete_powder", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> BURGUNDY_CONCRETE_POWDER = BLOCKS.register("burgundy_concrete_powder",
            () -> new ConcretePowderBlock(BURGUNDY_CONCRETE.get(), blockProperties("burgundy_concrete_powder", BlockBehaviour.Properties.of()).strength(1.0F)));
    public static final DeferredHolder<Block, Block> SCARLET_CONCRETE_POWDER = BLOCKS.register("scarlet_concrete_powder",
            () -> new ConcretePowderBlock(SCARLET_CONCRETE.get(), blockProperties("scarlet_concrete_powder", BlockBehaviour.Properties.of()).strength(1.0F)));

    private static BlockBehaviour.Properties blockProperties(String name, BlockBehaviour.Properties properties) {
        return properties.setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
