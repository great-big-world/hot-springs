package dev.creoii.greatbigworld.hotsprings.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.creoii.greatbigworld.hotsprings.HotSprings;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

import static dev.creoii.greatbigworld.hotsprings.HotSprings.BLOCKS;

public final class HotSpringsBlocks {
    public static RegistrySupplier<Block> GOLDEN_TRAVERTINE = registerBlock(BLOCKS, "golden_travertine", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static RegistrySupplier<Block> PEACH_TRAVERTINE = registerBlock(BLOCKS, "peach_travertine", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.RAW_IRON));
    public static RegistrySupplier<Block> IVORY_TRAVERTINE = registerBlock(BLOCKS, "ivory_travertine", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE));
    public static RegistrySupplier<Block> POLISHED_GOLDEN_TRAVERTINE = registerBlock(BLOCKS, "polished_golden_travertine", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static RegistrySupplier<Block> POLISHED_GOLDEN_TRAVERTINE_STAIRS = registerBlock(BLOCKS, "polished_golden_travertine_stairs", properties -> new StairBlock(POLISHED_GOLDEN_TRAVERTINE.get().defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static RegistrySupplier<Block> POLISHED_GOLDEN_TRAVERTINE_SLAB = registerBlock(BLOCKS, "polished_golden_travertine_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static RegistrySupplier<Block> POLISHED_GOLDEN_TRAVERTINE_WALL = registerBlock(BLOCKS, "polished_golden_travertine_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static RegistrySupplier<Block> POLISHED_PEACH_TRAVERTINE = registerBlock(BLOCKS, "polished_peach_travertine", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.RAW_IRON));
    public static RegistrySupplier<Block> POLISHED_PEACH_TRAVERTINE_STAIRS = registerBlock(BLOCKS, "polished_peach_travertine_stairs", properties -> new StairBlock(POLISHED_PEACH_TRAVERTINE.get().defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(MapColor.RAW_IRON));
    public static RegistrySupplier<Block> POLISHED_PEACH_TRAVERTINE_SLAB = registerBlock(BLOCKS, "polished_peach_travertine_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(MapColor.RAW_IRON));
    public static RegistrySupplier<Block> POLISHED_PEACH_TRAVERTINE_WALL = registerBlock(BLOCKS, "polished_peach_travertine_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(MapColor.RAW_IRON));
    public static RegistrySupplier<Block> POLISHED_IVORY_TRAVERTINE = registerBlock(BLOCKS, "polished_ivory_travertine", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE));
    public static RegistrySupplier<Block> POLISHED_IVORY_TRAVERTINE_STAIRS = registerBlock(BLOCKS, "polished_ivory_travertine_stairs", properties -> new StairBlock(POLISHED_IVORY_TRAVERTINE.get().defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(MapColor.TERRACOTTA_WHITE));
    public static RegistrySupplier<Block> POLISHED_IVORY_TRAVERTINE_SLAB = registerBlock(BLOCKS, "polished_ivory_travertine_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(MapColor.TERRACOTTA_WHITE));
    public static RegistrySupplier<Block> POLISHED_IVORY_TRAVERTINE_WALL = registerBlock(BLOCKS, "polished_ivory_travertine_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).mapColor(MapColor.TERRACOTTA_WHITE));

    public static void register() {
        BLOCKS.register();
    }

    public static RegistrySupplier<Block> registerBlock(DeferredRegister<Block> register, String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Identifier id = Identifier.fromNamespaceAndPath(HotSprings.GBW, name);
        return register.register(id, () -> factory.apply(settings.setId(ResourceKey.create(Registries.BLOCK, id))));
    }
}
