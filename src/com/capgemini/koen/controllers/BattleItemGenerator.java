package com.capgemini.koen.controllers;

import com.capgemini.koen.enums.BuffType;
import com.capgemini.koen.models.BattleItem;
import com.capgemini.koen.util.RandomUtil;

/**
 * Generator for {@link BattleItem}s.
 */
public class BattleItemGenerator {
    /** Generated using https://www.fantasynamegenerators.com/artifact-names.php */
    private String[] itemNames = {
            "Immortal Crown",
            "Light's Ring",
            "Shapeshifter Mantle",
            "Void Lamp",
            "Rebirth Ichor",
            "Statuette of Valor",
            "Instrument of the Titans",
            "Slab of Riddles",
            "Grimoire of Honesty",
            "Mirror of Oblivion"
    };

    /**
     * Generates one random battle item.
     */
    public BattleItem generateRandomBattleItem() {
        int randomIndex = RandomUtil.getRandomIntExclusive(itemNames.length);
        // Spread buff types evenly over the items.
        // This way, we make sure that each item always gives the same buff.
        BuffType randomBuffType = randomIndex % 2 == 0 ? BuffType.attack : BuffType.defence;

        return new BattleItem(itemNames[randomIndex], randomBuffType);
    }
}
