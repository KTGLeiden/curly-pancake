package com.capgemini.koen.util;

import com.capgemini.koen.enums.Sex;

import java.util.Random;

/**
 * Random utilities
 */
public class RandomUtil {
    private static final long SEED = 41;
    private static final int MAX_ATTACK_LEVEL = 5;
    private static final int MAX_DEFENCE_LEVEL = 5;
    private static final Random random = new Random(SEED);

    /**
     * Returns a random value for attack level
     */
    public static int getRandomAttackLevel() {
        return getRandomIntInclusive(MAX_ATTACK_LEVEL);
    }

    /**
     * Returns a random value for defence level
     */
    public static int getRandomDefenceLevel() {
        return getRandomIntInclusive(MAX_DEFENCE_LEVEL);
    }

    /**
     * Gets a random int between 1 and the {@code inclusiveBound}.
     * @param inclusiveBound The upper bound of the random value. (inclusive)
     */
    public static int getRandomIntInclusive(int inclusiveBound) {
        return random.nextInt(inclusiveBound) + 1;
    }

    /**
     * Gets a random int between 0 and the {@code exclusiveBound}.
     * @param exclusiveBound The upper bound of the random value. (exclusive)
     */
    public static int getRandomIntExclusive(int exclusiveBound) {
        return random.nextInt(exclusiveBound);
    }

    /**
     * Gets a random name based on the index of a contestant.
     */
    public static String getName(Sex sex, int contestantIndex) throws Exception {
        String[] names = sex == Sex.male ? RandomNames.maleNames : RandomNames.femaleNames;
        if(contestantIndex >= names.length) {
            throw new Exception("That contestant does not exist!");
        }
        return names[contestantIndex];
    }

    /**
     * @return a random boolean
     */
    public static boolean getNextBool() {
        return random.nextBoolean();
    }
}
