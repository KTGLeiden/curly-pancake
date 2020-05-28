package com.capgemini.koen.models;

import com.capgemini.koen.controllers.BattleItemGenerator;
import com.capgemini.koen.enums.Sex;

/**
 * Class for the special Career case of {@link Contestant}.
 * Has an item right at the start, and has more attack.
 */
public class CareerContestant extends Contestant {
    public CareerContestant(String name, Sex sex, int health, int attackLevel, int defenceLevel, BattleItem battleItem) {
        super(name, sex, health, attackLevel, defenceLevel, battleItem);
        // Give careers a battle item and increase attack
        this.setAttackLevel(attackLevel + 2);
        BattleItemGenerator battleItemGenerator = new BattleItemGenerator();
        this.setBattleItem(battleItemGenerator.generateRandomBattleItem());
    }
}
