package be.cloudns.edebe.timesync.fabric.mixin.client;

import be.cloudns.edebe.timesync.fabric.util.TimeUtil;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.Properties.class)
public class ClientLevelDataMixin {
    @Inject(method = "getTimeOfDay", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Long> returnable) {
        returnable.setReturnValue(TimeUtil.getMinecraftTime());
    }
}