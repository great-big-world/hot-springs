package dev.creoii.greatbigworld.hotsprings.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.creoii.greatbigworld.hotsprings.HotSprings;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static dev.creoii.greatbigworld.hotsprings.HotSprings.ITEMS;

public final class HotSpringsItems {
    public static final RegistrySupplier<Item> GOLDEN_TRAVERTINE = registerBlockItem(ITEMS, "golden_travertine", () -> HotSpringsBlocks.GOLDEN_TRAVERTINE.get());
    public static final RegistrySupplier<Item> PEACH_TRAVERTINE = registerBlockItem(ITEMS, "peach_travertine", () -> HotSpringsBlocks.PEACH_TRAVERTINE.get());
    public static final RegistrySupplier<Item> IVORY_TRAVERTINE = registerBlockItem(ITEMS, "ivory_travertine", () -> HotSpringsBlocks.IVORY_TRAVERTINE.get());
    public static final RegistrySupplier<Item> POLISHED_GOLDEN_TRAVERTINE = registerBlockItem(ITEMS, "polished_golden_travertine", () -> HotSpringsBlocks.POLISHED_GOLDEN_TRAVERTINE.get());
    public static final RegistrySupplier<Item> POLISHED_GOLDEN_TRAVERTINE_STAIRS = registerBlockItem(ITEMS, "polished_golden_travertine_stairs", () -> HotSpringsBlocks.POLISHED_GOLDEN_TRAVERTINE_STAIRS.get());
    public static final RegistrySupplier<Item> POLISHED_GOLDEN_TRAVERTINE_SLAB = registerBlockItem(ITEMS, "polished_golden_travertine_slab", () -> HotSpringsBlocks.POLISHED_GOLDEN_TRAVERTINE_SLAB.get());
    public static final RegistrySupplier<Item> POLISHED_GOLDEN_TRAVERTINE_WALL = registerBlockItem(ITEMS, "polished_golden_travertine_wall", () -> HotSpringsBlocks.POLISHED_GOLDEN_TRAVERTINE_WALL.get());
    public static final RegistrySupplier<Item> POLISHED_PEACH_TRAVERTINE = registerBlockItem(ITEMS, "polished_peach_travertine", () -> HotSpringsBlocks.POLISHED_PEACH_TRAVERTINE.get());
    public static final RegistrySupplier<Item> POLISHED_PEACH_TRAVERTINE_STAIRS = registerBlockItem(ITEMS, "polished_peach_travertine_stairs", () -> HotSpringsBlocks.POLISHED_PEACH_TRAVERTINE_STAIRS.get());
    public static final RegistrySupplier<Item> POLISHED_PEACH_TRAVERTINE_SLAB = registerBlockItem(ITEMS, "polished_peach_travertine_slab", () -> HotSpringsBlocks.POLISHED_PEACH_TRAVERTINE_SLAB.get());
    public static final RegistrySupplier<Item> POLISHED_PEACH_TRAVERTINE_WALL = registerBlockItem(ITEMS, "polished_peach_travertine_wall", () -> HotSpringsBlocks.POLISHED_PEACH_TRAVERTINE_WALL.get());
    public static final RegistrySupplier<Item> POLISHED_IVORY_TRAVERTINE = registerBlockItem(ITEMS, "polished_ivory_travertine", () -> HotSpringsBlocks.POLISHED_IVORY_TRAVERTINE.get());
    public static final RegistrySupplier<Item> POLISHED_IVORY_TRAVERTINE_STAIRS = registerBlockItem(ITEMS, "polished_ivory_travertine_stairs", () -> HotSpringsBlocks.POLISHED_IVORY_TRAVERTINE_STAIRS.get());
    public static final RegistrySupplier<Item> POLISHED_IVORY_TRAVERTINE_SLAB = registerBlockItem(ITEMS, "polished_ivory_travertine_slab", () -> HotSpringsBlocks.POLISHED_IVORY_TRAVERTINE_SLAB.get());
    public static final RegistrySupplier<Item> POLISHED_IVORY_TRAVERTINE_WALL = registerBlockItem(ITEMS, "polished_ivory_travertine_wall", () -> HotSpringsBlocks.POLISHED_IVORY_TRAVERTINE_WALL.get());

    public static void register() {
        ITEMS.register();

        CreativeTabRegistry.modify(CreativeTabRegistry.defer(CreativeModeTabs.BUILDING_BLOCKS), (_, output, _) -> {
            output.acceptAllAfter(Items.CUT_RED_SANDSTONE_SLAB, List.of(
                    POLISHED_IVORY_TRAVERTINE_WALL.get().getDefaultInstance(), POLISHED_IVORY_TRAVERTINE_SLAB.get().getDefaultInstance(), POLISHED_IVORY_TRAVERTINE_STAIRS.get().getDefaultInstance(), POLISHED_IVORY_TRAVERTINE.get().getDefaultInstance(),
                    POLISHED_PEACH_TRAVERTINE_WALL.get().getDefaultInstance(), POLISHED_PEACH_TRAVERTINE_SLAB.get().getDefaultInstance(), POLISHED_PEACH_TRAVERTINE_STAIRS.get().getDefaultInstance(), POLISHED_PEACH_TRAVERTINE.get().getDefaultInstance(),
                    POLISHED_GOLDEN_TRAVERTINE_WALL.get().getDefaultInstance(), POLISHED_GOLDEN_TRAVERTINE_SLAB.get().getDefaultInstance(), POLISHED_GOLDEN_TRAVERTINE_STAIRS.get().getDefaultInstance(), POLISHED_GOLDEN_TRAVERTINE.get().getDefaultInstance()
                    ));
        });

        CreativeTabRegistry.modify(CreativeTabRegistry.defer(CreativeModeTabs.NATURAL_BLOCKS), (_, output, _) -> {
            output.acceptAllAfter(Items.PRISMARINE, List.of(IVORY_TRAVERTINE.get().getDefaultInstance(), PEACH_TRAVERTINE.get().getDefaultInstance(), GOLDEN_TRAVERTINE.get().getDefaultInstance()));
        });
    }

    public static RegistrySupplier<Item> registerItem(DeferredRegister<Item> register, Identifier id, Function<Item.Properties, Item> factory) {
        return register.register(id, () -> factory.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id))));
    }

    public static RegistrySupplier<Item> registerBlockItem(DeferredRegister<Item> register, String name, Supplier<Block> block) {
        Identifier id = Identifier.fromNamespaceAndPath(HotSprings.GBW, name);
        return registerItem(register, id, settings1 -> new BlockItem(block.get(), settings1.setId(ResourceKey.create(Registries.ITEM, id)).useBlockDescriptionPrefix()));
    }
}
