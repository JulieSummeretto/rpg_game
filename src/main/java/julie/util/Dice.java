package julie.util;

import julie.model.GameCharacter;

import java.util.Random;

public class Dice {

    private static final Random rand = new Random();
    public static int damage(int ATK, int CR){
        int min = (int) (ATK * 0.8);
        int max = (int) (ATK * 1.2);
        int dmg = rand.nextInt(min,max + 1);

        if(chance(CR)){
            dmg *= 2;
        }

        return dmg;
    }

    public static boolean chance(int percent){
        return rand.nextInt(100) > percent;
    }
}
