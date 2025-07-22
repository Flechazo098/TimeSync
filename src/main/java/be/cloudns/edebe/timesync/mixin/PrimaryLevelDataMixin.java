package be.cloudns.edebe.timesync.mixin;

import be.cloudns.edebe.timesync.util.TimeUtil;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PrimaryLevelData.class)
public class PrimaryLevelDataMixin {
    @Inject(method = "getDayTime", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Long> returnable) {
        returnable.setReturnValue(TimeUtil.getMinecraftTime());
    }
}