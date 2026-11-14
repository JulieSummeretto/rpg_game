package julie;

import julie.model.Hero;
import julie.model.Monster;
import julie.service.BattleService;
import julie.util.BattleResult;
import julie.model.MonsterType;
import julie.util.Dice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero("Julie", 20, 10, 1, 15);
        BattleService battle = new BattleService(scanner);

        int victories = 0;

        while (hero.isAlive()) {
            Monster monster = new Monster(Dice.randomMonster(hero.getLvl()));
            BattleResult result = battle.fight(hero, monster);

            if (result == BattleResult.DEFEAT) {
                System.out.println("Герой пал...");
                break;
            }
            if (result == BattleResult.VICTORY) {
                victories++;
                System.out.println("Победа!");
            } else {
                System.out.println("Вы унесли ноги.");
            }

            if (!askContinue(scanner)) {
                break;
            }
        }

        System.out.println();
        System.out.println("Итог: уровень " + hero.getLvl()
                + ", золото " + hero.getGold() + ", побед " + victories);
    }

    private static boolean askContinue(Scanner scanner) {
        while (true) {
            System.out.print("Идти дальше? (д/н) > ");
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("д")) return true;
            if (line.equals("н")) return false;
            System.out.println("Введите д или н.");
        }
    }


}