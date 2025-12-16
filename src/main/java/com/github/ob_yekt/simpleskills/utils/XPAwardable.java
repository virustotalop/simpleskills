package com.github.ob_yekt.simpleskills.utils;

import net.minecraft.server.network.ServerPlayerEntity;

public interface XPAwardable {

    boolean canAwardXP(ServerPlayerEntity player, String action);

}
