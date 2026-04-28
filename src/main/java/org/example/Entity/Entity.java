package org.example.Entity;

public abstract class Entity {
    protected String nama;
    protected double health;
    protected double armor;

    protected String getNama() {
        return this.nama;
    }

    protected double getHealth() {
        return this.health;
    }

    protected double getArmor() {
        return this.armor;
    }
}
