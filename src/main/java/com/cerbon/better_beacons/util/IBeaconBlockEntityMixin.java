package com.cerbon.better_beacons.util;

import net.minecraft.world.effect.MobEffect;

public interface IBeaconBlockEntityMixin {
    String better_beacons_getPaymentItem();
    MobEffect better_beacons_getTertiaryPower();
    int better_beacons_getUpgradeAmplifier();
    void better_beacons_setUpgradeAmplifier(int amplifier);
}
