package be.cloudns.edebe.timesync.mixin.client;

import be.cloudns.edebe.timesync.util.TimeUtil;
import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientLevel.ClientLevelData.class)
public class ClientLevelDataMixin {
    @Inject(method = "getDayTime", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Long> returnable) {
        returnable.setReturnValue(TimeUtil.getMinecraftTime());
    }
}