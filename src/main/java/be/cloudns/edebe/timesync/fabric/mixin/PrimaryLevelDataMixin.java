package be.cloudns.edebe.timesync.fabric.mixin;

import be.cloudns.edebe.timesync.fabric.util.TimeUtil;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelProperties.class)
public class PrimaryLevelDataMixin {
    @Inject(method = "getTimeOfDay", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Long> returnable) {
        returnable.setReturnValue(TimeUtil.getMinecraftTime());
    }
}