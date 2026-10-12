package dev.creoii.greatbigworld.hotsprings.registry;

import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.creoii.greatbigworld.hotsprings.HotSprings;
import dev.creoii.greatbigworld.hotsprings.world.feature.HotSpringFeature;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;

import static dev.creoii.greatbigworld.hotsprings.HotSprings.FEATURE_TYPES;

public final class HotSpringsFeatureTypes {
    public static final RegistrySupplier<MapCodec<? extends Feature>> HOT_SPRING = FEATURE_TYPES.register(Identifier.fromNamespaceAndPath(HotSprings.GBW, "hot_spring"), () -> HotSpringFeature.CODEC);

    public static void register() {
        FEATURE_TYPES.register();
    }
}
