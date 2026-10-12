package dev.creoii.greatbigworld.hotsprings.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.hotsprings.util.HotSpringsTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Arrays;

import static dev.creoii.greatbigworld.hotsprings.HotSprings.HOT_SPRING_NOISE;

public record HotSpringFeature(int yOffset, IntProvider rimSize, BlockStateProvider rimState, BlockStateProvider baseState, BlockStateProvider innerState, IntProvider height, IntProvider startRadius, IntProvider innerDepth, TagKey<Block> replaceable, boolean solidRim) implements Feature {
    public static final MapCodec<HotSpringFeature> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("y_offset").orElse(0).forGetter(config -> {
            return config.yOffset;
        }), IntProviders.codec(0, 16).fieldOf("rim_size").forGetter(config -> {
            return config.rimSize;
        }), BlockStateProvider.TYPED_CODEC.fieldOf("rim_state").forGetter(config -> {
            return config.rimState;
        }), BlockStateProvider.TYPED_CODEC.fieldOf("base_state").forGetter(config -> {
            return config.baseState;
        }), BlockStateProvider.TYPED_CODEC.fieldOf("inner_state").forGetter(config -> {
            return config.innerState;
        }), IntProviders.POSITIVE_CODEC.fieldOf("height").forGetter(config -> {
            return config.height;
        }), IntProviders.POSITIVE_CODEC.fieldOf("start_radius").forGetter(config -> {
            return config.startRadius;
        }), IntProviders.POSITIVE_CODEC.fieldOf("inner_depth").forGetter(config -> {
            return config.innerDepth;
        }), TagKey.codec(Registries.BLOCK).fieldOf("replaceable").forGetter(config -> {
            return config.replaceable;
        }), Codec.BOOL.fieldOf("solid_rim").orElse(false).forGetter(config -> {
            return config.solidRim;
        })).apply(instance, HotSpringFeature::new);
    });

    @Override
    public MapCodec<? extends Feature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        origin = origin.relative(Direction.Axis.Y, yOffset);

        int height = height().sample(random);
        int radius = startRadius.sample(random);
        int rimSize = rimSize().sample(random);
        int innerDepth = Math.min(innerDepth().sample(random), height);
        for (int y = 0; y < height; ++y) {
            double scale = (y / (double) height) * 5;
            for (int x = -radius; x <= radius; ++x) {
                for (int z = -radius; z <= radius; ++z) {
                    BlockPos pos = origin.offset(x, y, z);
                    double distance = Math.sqrt(x * x + z * z);
                    double radiusMod = radius + HOT_SPRING_NOISE.get(x * scale, y, z * scale);
                    if (distance < radiusMod - rimSize && y <= innerDepth) {
                        if (y > 0) {
                            level.setBlock(pos, innerState.getState(level, random, pos), 3);
                            if (solidRim()) {
                                BlockPos.MutableBlockPos offset = new BlockPos.MutableBlockPos();
                                Arrays.stream(Direction.values()).filter(direction -> direction != Direction.UP).forEach(direction -> {
                                    offset.set(pos.relative(direction));
                                    if (level.isEmptyBlock(offset) || (!level.isFluidAtPosition(offset, _ -> true) && level.getBlockState(offset).is(HotSpringsTags.HOT_SPRING_REPLACEABLE))) {
                                        level.setBlock(offset, rimState.getState(level, random, offset), 3);
                                    }
                                });
                            }
                        } else level.setBlock(pos, baseState.getState(level, random, pos), 3);
                    } else if (distance < radiusMod) {
                        level.setBlock(pos, rimState.getState(level, random, pos), 3);
                    }
                }
            }
            radius += random.nextBoolean() ? 1 : 0;
        }
        return true;
    }
}