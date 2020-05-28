package com.capgemini.koen.models;

import com.capgemini.koen.enums.Sex;

/**
 * Special case of {@link Contestant}. This type of Contestant has a buff in defence.
 */
public class DistrictContestant extends Contestant {
    public DistrictContestant(String name, Sex sex, int health, int attackLevel, int defenceLevel, BattleItem battleItem) {
        super(name, sex, health, attackLevel, defenceLevel, battleItem);
        // Give district contestants a 2 point bonus in defence.
        this.setDefenceLevel(defenceLevel + 2);
    }
}
