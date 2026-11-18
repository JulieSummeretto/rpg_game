package julie.model;

import java.util.ArrayList;
import java.util.List;

public class Hero extends GameCharacter{
    private int lvl;
    private int exp;
    private int gold;

    private final List<Item> inventory = new ArrayList<>();
    private Item equipped;

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

    private void applyLvlUp() {
        increaseStats(10, 4);
        restoreHealth(getMaxHP());
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean equip(Item item) {
        if (!inventory.remove(item)) {
            return false;
        }
        if (equipped != null) {
            inventory.add(equipped);
        }
        clampHealth();
        equipped = item;
        return true;
    }

    public void unequip() {
        if (equipped != null) {
            inventory.add(equipped);
            equipped = null;
        }
        clampHealth();
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

    public List<Item> getInventory() {
        return List.copyOf(inventory);
    }

    @Override
    public int getATK() {
        return super.getATK() + (equipped == null ? 0 : equipped.getAtkBonus());
    }

    @Override
    public int getCR() {
        return super.getCR() + (equipped == null ? 0 : equipped.getCritChanceBonus());
    }

    @Override
    public int getMaxHP() {
        return super.getMaxHP() + (equipped == null ? 0 : equipped.getHpBonus());
    }


    public Hero(String name, int HP, int ATK, int lvl, int CR){
        super(name, HP, ATK, CR);
        this.lvl = lvl;
    }
}
