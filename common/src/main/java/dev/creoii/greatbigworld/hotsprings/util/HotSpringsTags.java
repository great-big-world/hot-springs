package dev.creoii.greatbigworld.hotsprings.util;

import dev.creoii.greatbigworld.hotsprings.HotSprings;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class HotSpringsTags {
    public static final TagKey<Block> HOT_SPRING_REPLACEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(HotSprings.GBW, "hot_spring_replaceable"));
    public static final TagKey<Block> TRAVERTINE_FORMS_FROM = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(HotSprings.GBW, "travertine_forms_from"));
}
