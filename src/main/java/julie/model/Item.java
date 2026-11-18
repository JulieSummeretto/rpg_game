package julie.model;

import java.util.Objects;

public class Item {
    private final String itemName;
    private final int atkBonus;
    private final int critChanceBonus;
    private final int hpBonus;

    public Item(String itemName, int atkBonus, int critChanceBonus, int hpBonus) {
        this.itemName = itemName;
        this.atkBonus = atkBonus;
        this.critChanceBonus = critChanceBonus;
        this.hpBonus = hpBonus;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAtkBonus() {
        return atkBonus;
    }

    public int getCritChanceBonus() {
        return critChanceBonus;
    }

    public int getHpBonus() {
        return hpBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item other = (Item) o;
        return itemName.equals(other.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

    @Override
    public String toString() {
        return itemName + " (Атк: " + atkBonus + " Крит. шанс: " + critChanceBonus + " Макс. ХП: " + hpBonus + " )";
    }
}
