package com.squareshaper.termites.item.custom;

import net.minecraft.entity.Entity;

public class Killeds {
    public final Entity entity;
    private int countdown;

    public Killeds(Entity entity, int countdown) {
        this.entity = entity;
        this.countdown = countdown;
    }

    public boolean tick() {
        this.countdown--;

        if(this.countdown <= 0) {
            return true;
        }

        return false;
    }
}
