package org.example.GameManager;

public class Inventory {
    private String profileName;
    private int xpCount;
    private int levelCount;
    private int moneyCount;
    private int skillPoint;

    public Inventory(String profileName, int xpCount, int levelCount, int moneyCount, int skillPoint) {
        this.profileName = profileName;
        this.xpCount = xpCount;
        this.levelCount = levelCount;
        this.moneyCount = moneyCount;
        this.skillPoint = skillPoint;
    }

    public String getProfileName() {
        return profileName;
    }

    public void updateProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getXpCount() {
        return xpCount;
    }

    public void addXpCount(int xpCount) {
        this.xpCount += xpCount;
    }

    public int getLevelCount() {
        return levelCount;
    }

    public void addLevelCount() {
        this.levelCount += 1;
    }

    public int getMoneyCount() {
        return moneyCount;
    }

    public void addMoneyCount(int moneyCount) {
        this.moneyCount += moneyCount;
    }

    public void subtractMoneyCount(int moneyCount) {
        this.moneyCount -= moneyCount;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void addSkillPoint() {
        this.skillPoint += 1;
    }

    public void subtractSkillPoint(int skillPoint) {
        this.skillPoint -= skillPoint;
    }
}
