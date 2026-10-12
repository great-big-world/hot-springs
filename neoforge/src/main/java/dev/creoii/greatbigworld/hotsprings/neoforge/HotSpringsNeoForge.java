package dev.creoii.greatbigworld.hotsprings.neoforge;

import dev.creoii.greatbigworld.hotsprings.HotSprings;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("hot_springs")
public final class HotSpringsNeoForge {
    public HotSpringsNeoForge(IEventBus modBus) {
        HotSprings.init();
    }
}
