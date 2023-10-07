package com.cerbon.better_beacons.advancement.condition;

import com.cerbon.better_beacons.config.BBCommonConfigs;
import com.cerbon.better_beacons.util.BBConstants;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class IsConfigEnabledCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(BBConstants.MOD_ID, "is_config_enabled");
    private final String config;

    public IsConfigEnabledCondition(String config) {
        this.config = config;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test(IContext context) {
        if (config.equals("tertiary_effect"))
            return BBCommonConfigs.ENABLE_TERTIARY_EFFECTS.get();

        else if (config.equals("beacon_beam_redirection"))
            return BBCommonConfigs.ENABLE_BEACON_BEAM_REDIRECTION.get();

        return false;
    }

    public static class Serializer implements IConditionSerializer<IsConfigEnabledCondition> {
        public static final IsConfigEnabledCondition.Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, IsConfigEnabledCondition value) {
            json.addProperty("config", value.config);
        }

        @Override
        public IsConfigEnabledCondition read(JsonObject json) {
            return new IsConfigEnabledCondition(GsonHelper.getAsString(json, "config"));
        }

        @Override
        public ResourceLocation getID() {
            return IsConfigEnabledCondition.NAME;
        }
    }
}
