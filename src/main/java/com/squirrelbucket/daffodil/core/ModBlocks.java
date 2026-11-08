package com.squirrelbucket.daffodil.core;

import com.squirrelbucket.daffodil.client.CustomDyeColors;
import com.squirrelbucket.daffodil.core.customBlocks.customBannerBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customWallBannerBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customBedBlock;
import com.squirrelbucket.daffodil.core.customBlocks.customBerryBushBlock;
import com.squirrelbucket.daffodil.core.plum.PlumSaplingBlock;
import com.squirrelbucket.daffodil.core.plum.PlumCeilingHangingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumStandingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumWallHangingSignBlock;
import com.squirrelbucket.daffodil.core.plum.PlumWallSignBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final String MODID = "daffodil";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> PLUM_LEAVES = BLOCKS.register("plum_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.AZALEA_LEAVES)));
    public static final RegistryObject<Block> FLOWERING_PLUM_LEAVES = BLOCKS.register("flowering_plum_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.FLOWERING_AZALEA_LEAVES)));
    public static final RegistryObject<Block> PLUM_SAPLING = BLOCKS.register("plum_sapling",
            () -> new PlumSaplingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PLUM_PLANKS = BLOCKS.register("plum_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PLUM_LOG = BLOCKS.register("plum_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PLUM_LOG = BLOCKS.register("stripped_plum_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> PLUM_WOOD = BLOCKS.register("plum_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PLUM_WOOD = BLOCKS.register("stripped_plum_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> PLUM_STAIRS = BLOCKS.register("plum_stairs",
            () -> new StairBlock(() -> PLUM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> PLUM_SLAB = BLOCKS.register("plum_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> PLUM_TRAPDOOR = BLOCKS.register("plum_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), ModWoodTypes.PLUM_BLOCK_SET_TYPE));
    public static final RegistryObject<Block> PLUM_BUTTON = BLOCKS.register("plum_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), ModWoodTypes.PLUM_BLOCK_SET_TYPE, 30, true));
    public static final RegistryObject<Block> PLUM_PRESSURE_PLATE = BLOCKS.register("plum_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModWoodTypes.PLUM_BLOCK_SET_TYPE));
    public static final RegistryObject<Block> PLUM_DOOR = BLOCKS.register("plum_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), ModWoodTypes.PLUM_BLOCK_SET_TYPE));
    public static final RegistryObject<Block> PLUM_FENCE = BLOCKS.register("plum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> PLUM_FENCE_GATE = BLOCKS.register("plum_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.PLUM_WOOD_TYPE));

    public static final RegistryObject<Block> PLUM_SIGN = BLOCKS.register("plum_sign",
            () -> new PlumStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final RegistryObject<Block> PLUM_WALL_SIGN = BLOCKS.register("plum_wall_sign",
            () -> new PlumWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final RegistryObject<Block> PLUM_HANGING_SIGN = BLOCKS.register("plum_hanging_sign",
            () -> new PlumCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PLUM_WOOD_TYPE));
    public static final RegistryObject<Block> PLUM_WALL_HANGING_SIGN = BLOCKS.register("plum_wall_hanging_sign",
            () -> new PlumWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PLUM_WOOD_TYPE));

    public static final RegistryObject<Block> DAFFODIL_BLOCK = BLOCKS.register("daffodil_flower",
            () -> new FlowerBlock(MobEffects.CONFUSION, 100, BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> HIBISCUS_BLOCK = BLOCKS.register("hibiscus_flower",
            () -> new FlowerBlock(MobEffects.REGENERATION, 100, BlockBehaviour.Properties.of()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .lightLevel((blockState) -> 7) ));

    public static final RegistryObject<Block> GOJI_BERRY_BUSH =
            BLOCKS.register("goji_berry_bush", () ->
                    new customBerryBushBlock(
                            BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH),
                            ModItems.GOJI_BERRIES::get
                    )
            );

    public static final RegistryObject<Block> DAFFODIL_WOOL_BLOCK = BLOCKS.register("daffodil_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> BURGUNDY_WOOL_BLOCK = BLOCKS.register("burgundy_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> SCARLET_WOOL_BLOCK = BLOCKS.register("scarlet_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static final RegistryObject<Block> DAFFODIL_CARPET_BLOCK = BLOCKS.register("daffodil_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final RegistryObject<Block> BURGUNDY_CARPET_BLOCK = BLOCKS.register("burgundy_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final RegistryObject<Block> SCARLET_CARPET_BLOCK = BLOCKS.register("scarlet_carpet",
            () -> new ModCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));

    public static final RegistryObject<Block> DAFFODIL_BANNER = BLOCKS.register("daffodil_banner",
            () -> new customBannerBlock(CustomDyeColors.DAFFODIL, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> BURGUNDY_BANNER = BLOCKS.register("burgundy_banner",
            () -> new customBannerBlock(CustomDyeColors.BURGUNDY, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> SCARLET_BANNER = BLOCKS.register("scarlet_banner",
            () -> new customBannerBlock(CustomDyeColors.SCARLET, BlockBehaviour.Properties.copy(Blocks.WHITE_BANNER)));
    public static final RegistryObject<Block> DAFFODIL_WALL_BANNER = BLOCKS.register("daffodil_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.DAFFODIL, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER)));
    public static final RegistryObject<Block> SCARLET_WALL_BANNER = BLOCKS.register("scarlet_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.SCARLET, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER)));
    public static final RegistryObject<Block> BURGUNDY_WALL_BANNER = BLOCKS.register("burgundy_wall_banner",
            () -> new customWallBannerBlock(CustomDyeColors.BURGUNDY, BlockBehaviour.Properties.copy(Blocks.WHITE_WALL_BANNER)));

    public static final RegistryObject<Block> DAFFODIL_BED = BLOCKS.register("daffodil_bed",
            () -> new customBedBlock(CustomDyeColors.DAFFODIL, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final RegistryObject<Block> BURGUNDY_BED = BLOCKS.register("burgundy_bed",
            () -> new customBedBlock(CustomDyeColors.BURGUNDY, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    public static final RegistryObject<Block> SCARLET_BED = BLOCKS.register("scarlet_bed",
            () -> new customBedBlock(CustomDyeColors.SCARLET, BlockBehaviour.Properties.copy(Blocks.WHITE_BED)));
    
    public static final RegistryObject<Block> DAFFODIL_TERRACOTTA = BLOCKS.register("daffodil_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> BURGUNDY_TERRACOTTA = BLOCKS.register("burgundy_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));
    public static final RegistryObject<Block> SCARLET_TERRACOTTA = BLOCKS.register("scarlet_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)));

    public static final RegistryObject<Block> DAFFODIL_GLAZED_TERRACOTTA = BLOCKS.register("daffodil_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BURGUNDY_GLAZED_TERRACOTTA = BLOCKS.register("burgundy_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCARLET_GLAZED_TERRACOTTA = BLOCKS.register("scarlet_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.RED_GLAZED_TERRACOTTA).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE = BLOCKS.register("daffodil_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BURGUNDY_CONCRETE = BLOCKS.register("burgundy_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCARLET_CONCRETE = BLOCKS.register("scarlet_concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DAFFODIL_CONCRETE_POWDER = BLOCKS.register("daffodil_concrete_powder",
            () -> new ConcretePowderBlock(DAFFODIL_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final RegistryObject<Block> BURGUNDY_CONCRETE_POWDER = BLOCKS.register("burgundy_concrete_powder",
            () -> new ConcretePowderBlock(BURGUNDY_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final RegistryObject<Block> SCARLET_CONCRETE_POWDER = BLOCKS.register("scarlet_concrete_powder",
            () -> new ConcretePowderBlock(SCARLET_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
