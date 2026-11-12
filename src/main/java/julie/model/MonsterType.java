package julie.util;

public enum MonsterType {
    GOBLIN("Гоблин", 20, 5, 1, 12, 10),
    ORC("Орк", 40, 9, 2, 25, 10),
    DRAGON("Дракон", 150, 20, 5, 100, 20);

    private final String displayName;
    private final int HP;
    private final int ATK;
    private final int lvl;
    private final int rewardGold;
    private final int CR;

    MonsterType(String displayName, int HP, int ATK, int lvl, int rewardGold, int CR) {
        this.displayName = displayName;
        this.HP = HP;
        this.ATK = ATK;
        this.lvl = lvl;
        this.rewardGold = rewardGold;
        this.CR = CR;
    }

    public String getDisplayName() { return displayName; }
    public int getHP() { return HP; }
    public int getATK() { return ATK; }
    public int getLvl() { return lvl; }
    public int getRewardGold() { return rewardGold; }
    public int getCR() { return CR; }
}
