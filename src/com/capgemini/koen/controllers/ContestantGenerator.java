package com.capgemini.koen.controllers;

import com.capgemini.koen.enums.Sex;
import com.capgemini.koen.models.CareerContestant;
import com.capgemini.koen.models.Contestant;
import com.capgemini.koen.models.DistrictContestant;
import com.capgemini.koen.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Generator for contestants
 */
public class ContestantGenerator {
    /**
     * Generates a list of random {@link Contestant}s.
     */
    public List<Contestant> generateRandomContestants(int amount) throws Exception {
        ArrayList<Contestant> contestants = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            contestants.add(createRandomContestant(i, i % 2 == 0 ? Sex.male : Sex.female));
        }
        return contestants;
    }

    /**
     * Creates a random Contestant. This can be a {@link DistrictContestant} or a {@link CareerContestant}.
     */
    private Contestant createRandomContestant(int index, Sex sex) throws Exception {
        if(index % 4 == 0) {
            return new CareerContestant(
                    RandomUtil.getName(sex, index),
                    sex,
                    100,
                    RandomUtil.getRandomAttackLevel(),
                    RandomUtil.getRandomDefenceLevel(),
                    null
            );
        }
        else {
            return new DistrictContestant(
                    RandomUtil.getName(sex, index),
                    sex,
                    100,
                    RandomUtil.getRandomAttackLevel(),
                    RandomUtil.getRandomDefenceLevel(),
                    null
            );
        }
    }

}
