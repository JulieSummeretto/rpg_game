package julie;

import julie.model.Hero;
import julie.model.Monster;
import julie.service.BattleService;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Julie", 20, 10, 1, 15);
        Monster goblin = new Monster("Гоблин", 20, 5, 1, 12, 1);

        BattleService battleService = new BattleService();
        
        battleService.battle(hero, goblin);
    }
}