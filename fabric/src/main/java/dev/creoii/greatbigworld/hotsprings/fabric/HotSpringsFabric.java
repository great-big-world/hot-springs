package dev.creoii.greatbigworld.hotsprings.fabric;

import dev.creoii.greatbigworld.hotsprings.HotSprings;
import net.fabricmc.api.ModInitializer;

public final class HotSpringsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HotSprings.init();
    }
}
