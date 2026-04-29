package org.example.GameManager.Range;

public abstract class Difficulty {
    private final String nama;
    private final String desc;
    private final int level;

    //TODO: modifier stats / enemy spawn
    private int healthModifier; //health * berapa modifier
    private int armorModifier; //health * berapa modifier
    private int Modifier; //health * berapa modifier

    public Difficulty(String nama, String desc, int level) {
        this.nama = nama;
        this.desc = desc;
        this.level = level;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

    public int getLevel() {
        return level;
    }
}
