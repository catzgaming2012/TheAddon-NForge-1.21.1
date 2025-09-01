package net.catzgaming.theaddon.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties STRANGED_APPLE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(4.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 800), .2f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 1200), .4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200), .4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800), .2f)
            .build();

}
