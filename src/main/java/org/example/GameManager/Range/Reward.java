package org.example.GameManager.Range;

public class Reward {
    private final int minXp;
    private final int maxXp;
    private final int minMoney;
    private final int maxMoney;

    public Reward(int minXp, int maxXp, int minMoney, int maxMoney) {
        this.minXp = minXp;
        this.maxXp = maxXp;
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
    }

    public int getMinXp() {
        return minXp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public int getMinMoney() {
        return minMoney;
    }

    public int getMaxMoney() {
        return maxMoney;
    }
}
