package julie.util;

import julie.model.AttackRecord;
import julie.model.Monster;
import julie.model.MonsterType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dice {

    private static final Random rand = new Random();

    public static AttackRecord damage(int ATK, int CR) {
        int min = (int) (ATK * 0.8);
        int max = (int) (ATK * 1.2);
        int dmg = rand.nextInt(min, max + 1);

        boolean crit = chance(CR);
        if (crit) {
            dmg *= 2;
        }
        return new AttackRecord(dmg, crit);
    }

    public static MonsterType randomMonster(int heroLvl) {
        List<MonsterType> suitable = Arrays.stream(MonsterType.values())
                .filter(t -> t.getLvl() <= heroLvl + 1)
                .toList();
        return suitable.get(rand.nextInt(suitable.size()));
    }


    public static boolean chance(int percent){
        return rand.nextInt(100) < percent;
    }
}
