package julie.model;

public class Monster extends GameCharacter{
    private int lvl;
    private final int rewardGold;

    private static final int EXP_per_lvl = 50;

    public Monster(String name, int HP, int ATK, int lvl, int rewardGold, int CR){
        super(name, HP, ATK, CR);
        this.rewardGold = rewardGold;
        this.lvl = lvl;
    }

    public Monster(MonsterType type) {
        this(type.getDisplayName(), type.getHP(), type.getATK(),
                type.getLvl(), type.getRewardGold(), type.getCR());
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public int getExpReward() {
        return lvl * EXP_per_lvl;
    }
}
