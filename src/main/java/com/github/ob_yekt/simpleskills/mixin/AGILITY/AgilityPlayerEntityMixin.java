package com.github.ob_yekt.simpleskills.mixin.AGILITY;

import com.github.ob_yekt.simpleskills.Skills;
import com.github.ob_yekt.simpleskills.managers.ConfigManager;
import com.github.ob_yekt.simpleskills.managers.XPManager;
import com.github.ob_yekt.simpleskills.utils.XPAwardable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class AgilityPlayerEntityMixin {

    // Jumping: Hook into jump method
    @Inject(method = "jump", at = @At(value = "TAIL"))
    private void onJump(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity)(Object)this;
        if (player instanceof XPAwardable awardable) {
            if (awardable.canAwardXP(player, "jump")) {
                int xp = ConfigManager.getAgilityXP("jump", Skills.AGILITY);
                XPManager.addXPSilent(player, Skills.AGILITY, xp);
//            Simpleskills.LOGGER.debug("Granted {} Agility XP for jumping to player {}",
//                    xp, player.getName().getString());
            }
        }
    }

}
