package com.squareshaper.termites.item;

import com.squareshaper.termites.Termites;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent TERMITE_TREAT = new FoodComponent.Builder().nutrition(4).saturationModifier(4)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 0), 1f).build();

    public static void registerModFoodComponents() {
        Termites.LOGGER.info("Registering Mod Food Components for " + Termites.MOD_ID + "...");
    }
}
