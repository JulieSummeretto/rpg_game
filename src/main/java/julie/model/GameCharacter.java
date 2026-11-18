package julie.model;

import julie.util.Dice;

public abstract class GameCharacter {
    private final String name;
    private int HP;
    private int maxHP;
    private int ATK;
    private int CR;

    protected GameCharacter(String name, int HP, int ATK, int CR){
        this.name = name;
        this.HP = HP;
        this.maxHP = HP;
        this.ATK = ATK;
        this.CR = CR;
    }
    private void takeHit(int amountATK){
        HP = Math.max(0, HP - amountATK);
    }

    protected int restoreHealth(int amount) {
        int before = HP;
        HP = Math.min(getMaxHP(), HP + amount);
        return HP - before;
    }

    protected void clampHealth() {
        HP = Math.min(HP, getMaxHP());
    }

    protected void increaseStats(int hpBonus, int atkBonus) {
        maxHP += hpBonus;
        ATK += atkBonus;
    }

    public AttackRecord attack(GameCharacter target) {
        AttackRecord dmg = Dice.damage(getATK(), getCR());
        target.takeHit(dmg.damage());
        return dmg;
    }

    public boolean isAlive(){
        return HP > 0;
    }

    public String getName(){ return name; }
    public int getHP(){ return HP; }

    public int getMaxHP() {
        return maxHP;
    }

    public int getATK() {
        return ATK;
    }

    public int getCR() {
        return CR;
    }
}
