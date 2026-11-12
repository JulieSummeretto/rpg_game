package julie.service;

import julie.model.AttackRecord;
import julie.model.GameCharacter;
import julie.model.Hero;
import julie.model.Monster;
import julie.util.BattleResult;
import julie.util.Dice;

import java.util.Scanner;

public class BattleService {

    private final Scanner scanner = new Scanner(System.in);

    public BattleResult fight(Hero hero, Monster monster) {
        System.out.println("Вы встретили врага: " + monster.getName());

        while (hero.isAlive() && monster.isAlive()) {
            printStatus(hero, monster);

            switch (askAction()) {
                case 1 -> printAttack(hero, monster, hero.attack(monster));
                case 2 -> {
                    if (!hero.healing(30)) {
                        System.out.println("Лечиться нельзя: зелья кончились или здоровье полное.");
                        continue;
                    }
                    System.out.println("Вы выпили зелье.");
                }
                case 3 -> {
                    if (Dice.chance(50)) {
                        System.out.println("Вы сбежали!");
                        return BattleResult.FLEE;
                    }
                    System.out.println("Побег не удался!");
                }
            }

            if (monster.isAlive()) {
                printAttack(monster, hero, monster.attack(hero));
            }
        }

        return hero.isAlive() ? BattleResult.VICTORY : BattleResult.DEFEAT;

    }

    private void printStatus(Hero hero, Monster monster) {
        System.out.println();
        System.out.println(hero.getName() + ": " + hero.getHP() + "/" + hero.getMaxHP() + " HP");
        System.out.println(monster.getName() + ": " + monster.getHP() + "/" + monster.getMaxHP() + " HP");
    }

    private int askAction() {
        while (true) {
            System.out.println("1 - атаковать, 2 - лечиться, 3 - сбежать");
            System.out.print("> ");
            String line = scanner.nextLine().trim();

            if (line.equals("1") || line.equals("2") || line.equals("3")) {
                return Integer.parseInt(line);
            }
            System.out.println("Введите 1, 2 или 3.");
        }
    }

    private void printAttack(GameCharacter attacker, GameCharacter target, AttackRecord result) {
        System.out.println(attacker.getName() + " бьёт " + target.getName()
                + ": " + result.damage() + " урона"
                + (result.isCrit() ? " (КРИТ!)" : ""));
    }
}
