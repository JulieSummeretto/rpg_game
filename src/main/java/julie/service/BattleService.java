package julie.service;

import julie.model.GameCharacter;

public class BattleService {
    public void battle(GameCharacter hero, GameCharacter monster){
        while(hero.isAlive() && monster.isAlive()){
            hero.attack(monster);
            System.out.println(hero.getName() + " бьёт " + monster.getName());

            if(monster.isAlive()){
                monster.attack(hero);
                System.out.println(monster.getName() + " бьёт " + hero.getName());
            }
        }
        System.out.println(hero.isAlive() ? "Победа!" : "Поражение...");
    };
}
