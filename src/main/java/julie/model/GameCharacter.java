package julie.model;

import julie.util.Dice;

public abstract class GameCharacter {
    private final String name;
    private int HP;
    private final int maxHP;
    private final int ATK;
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
        HP = Math.min(maxHP, HP + amount);
        return HP - before;
    }

    public AttackRecord attack(GameCharacter target) {
        AttackRecord dmg = Dice.damage(ATK, CR);
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
}
