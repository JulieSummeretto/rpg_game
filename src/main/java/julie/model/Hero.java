package julie.model;

public class Hero extends GameCharacter{
    private int lvl;
    private int CR;

    private int exp;
    private int gold;

    private int healPotions = 3;

    public boolean healing(int amount) {
        if (healPotions == 0 || getHP() == getMaxHP()) {
            return false;
        }
        restoreHealth(amount);
        healPotions--;
        return true;
    }

    public int expForNextLvl() {
        return lvl * 100;
    }

    public int receiveReward(int expAmount, int goldAmount) {
        gold += goldAmount;
        exp += expAmount;

        int lvlUps = 0;
        while (exp >= expForNextLvl()) {
            exp -= expForNextLvl();
            lvl++;
            lvlUps++;
            applyLvlUp();
        }
        return lvlUps;
    }

    public void applyLvlUp() {
        increaseStats(10, 4);
        restoreHealth(getMaxHP());
    }

    public int getLvl() {
        return lvl;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }

    public void refillPotions() {
        healPotions = 3;
    }


    public Hero(String name, int HP, int ATK, int lvl, int CR){
        super(name, HP, ATK, CR);
        this.lvl = lvl;
        this.CR = CR;
    }
}
