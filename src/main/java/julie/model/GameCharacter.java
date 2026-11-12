package julie.model;

import julie.util.Dice;

public abstract class GameCharacter {
    private final String name;
    private int HP;
    private final int ATK;
    private int CR;

    protected GameCharacter(String name, int HP, int ATK, int CR){
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.CR = CR;
    }
    private void takeHit(int amountATK){
        HP = Math.max(0, HP - amountATK);
    }
    public void attack(GameCharacter target){
        int dmg = Dice.damage(ATK, CR);
        target.takeHit(dmg);
    }

    public boolean isAlive(){
        return HP > 0;
    }

    public String getName(){ return name; }
    public int getHP(){ return HP; }
}
