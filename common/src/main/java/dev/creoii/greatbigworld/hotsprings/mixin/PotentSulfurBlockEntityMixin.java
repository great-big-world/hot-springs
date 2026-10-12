package dev.creoii.greatbigworld.hotsprings.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.hotsprings.registry.HotSpringsBlocks;
import dev.creoii.greatbigworld.hotsprings.util.HotSpringsTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.PotentSulfurBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotentSulfurBlockEntity.class)
public class PotentSulfurBlockEntityMixin {
    @Inject(method = "lambda$static$5", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/AABB;expandTowards(DDD)Lnet/minecraft/world/phys/AABB;"))
    private static void gbw$createTravertine(Level level, BlockPos pos, BlockState state, PotentSulfurBlockEntity entity, CallbackInfo ci, @Local(name = "geyserForceHeight") int geyserForceHeight) {
        BlockPos obstructionPos = pos.above(geyserForceHeight + 1);
        BlockState obstructionState = level.getBlockState(obstructionPos);

        if (obstructionState.is(HotSpringsTags.TRAVERTINE_FORMS_FROM) && level.getRandom().nextInt(geyserForceHeight) == 0) {
            Block travertine = switch (level.getRandom().nextInt(3)) {
                case 0 -> HotSpringsBlocks.IVORY_TRAVERTINE.get();
                case 1 -> HotSpringsBlocks.GOLDEN_TRAVERTINE.get();
                case 2 -> HotSpringsBlocks.PEACH_TRAVERTINE.get();
                default -> throw new IllegalStateException("Unexpected value: " + level.getRandom().nextInt(3));
            };

            level.setBlock(obstructionPos, travertine.defaultBlockState(), 3);
        }
    }
}
