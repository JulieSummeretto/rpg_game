package julie.model;

public class Hero extends GameCharacter{
    private int lvl;
    private int CR = 15;

    private int healPotions = 3;

    public boolean healing(int amount) {
        if (healPotions == 0 || getHP() == getMaxHP()) {
            return false;
        }
        restoreHealth(amount);
        healPotions--;
        return true;
    }


    public Hero(String name, int HP, int ATK, int lvl, int CR){
        super(name, HP, ATK, CR);
        this.lvl = lvl;
        this.CR = CR;
    }
}
