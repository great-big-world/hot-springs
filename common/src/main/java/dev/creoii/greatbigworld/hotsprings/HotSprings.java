package dev.creoii.greatbigworld.hotsprings;

import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.creoii.greatbigworld.hotsprings.registry.HotSpringsBlocks;
import dev.creoii.greatbigworld.hotsprings.registry.HotSpringsFeatureTypes;
import dev.creoii.greatbigworld.hotsprings.registry.HotSpringsItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

public final class HotSprings {
    public static final String NAMESPACE = "hot_springs";
    public static final String GBW = "great_big_world";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(NAMESPACE, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(NAMESPACE, Registries.ITEM);
    public static final DeferredRegister<MapCodec<? extends Feature>> FEATURE_TYPES = DeferredRegister.create(NAMESPACE, Registries.FEATURE_TYPE);

    public static final PerlinNoise HOT_SPRING_NOISE = new PerlinNoise(RandomSource.create());

    public static void init() {
        HotSpringsBlocks.register();
        HotSpringsItems.register();
        HotSpringsFeatureTypes.register();
    }
}
