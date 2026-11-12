package julie;

import julie.model.Hero;
import julie.model.Monster;
import julie.service.BattleService;
import julie.util.BattleResult;
import julie.model.MonsterType;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Julie", 20, 10, 1, 15);
        Monster goblin = new Monster("Гоблин", 20, 5, 1, 12, 1);

        BattleService battle = new BattleService();
        BattleResult result = battle.fight(hero, new Monster(MonsterType.GOBLIN));

        switch (result) {
            case VICTORY -> System.out.println("Победа!");
            case DEFEAT -> System.out.println("Герой пал...");
            case FLEE -> System.out.println("Вы унесли ноги.");
        }
    }
}