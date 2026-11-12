package julie.model;

public class Hero extends GameCharacter{
    private int lvl;
    private int CR = 15;

    public Hero(String name, int HP, int ATK, int lvl, int CR){
        super(name, HP, ATK, CR);
        this.lvl = lvl;
        this.CR = CR;
    }
}
