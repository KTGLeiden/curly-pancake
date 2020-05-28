package com.capgemini.koen.controllers;

import com.capgemini.koen.models.BattleItem;
import com.capgemini.koen.models.Contestant;
import com.capgemini.koen.util.Constants;
import com.capgemini.koen.util.RandomUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simulator class for the games.
 */
public class GamesSimulator {
    /**
     * Simulates one round. Will randomize contestants into pairs, which will have a chance of having an encounter.
     * If they have an encounter, one of the two will die.
     * It will change the incoming array with contestants by removing those who died.
     */
    public List<Contestant> simulateRound(List<Contestant> contestants) {
        // Shuffle the contestants
        Collections.shuffle(contestants);

        // Divide contestants into pairs.
        // Every pair has a chance to get into a fight
        for (int i = 0; i < contestants.size() / 2; i++) {
            if(RandomUtil.getRandomIntInclusive(100) < Constants.ENCOUNTER_CHANCE_PERCENT) {
                Contestant contestant1 = contestants.get(i * 2);
                Contestant contestant2 = contestants.get(i * 2 + 1);
                simulateFight(contestant1, contestant2);
            }
        }

        // Filter out the living contestants
        contestants = contestants.stream().filter(contestant -> !contestant.isDead()).collect(Collectors.toList());
        // Set health to 100 for the rest.
        contestants.forEach(contestant -> contestant.setHealth(100));

        return contestants;
    }

    /**
     * Fight to the death.. will continue until one of the two dies.
     */
    private void simulateFight(Contestant contestant1, Contestant contestant2) {
        System.out.println(contestant1.getName() + " takes a fight with " + contestant2.getName());
        while(contestant1.getHealth() > 0 && contestant2.getHealth() > 0) {
            // Randomize who is the attacker and who is the defender
            Contestant attacker = RandomUtil.getNextBool() ? contestant1 : contestant2;
            Contestant defender = attacker == contestant1 ? contestant2 : contestant1;

            simulateBlow(attacker, defender);
        }
    }

    private void simulateBlow(Contestant attacker, Contestant defender) {
        if(Constants.SHOW_DEBUG) System.out.println(attacker.getName() + " takes a blow at " + defender.getName());

        // Get base attack and defence levels
        int baseAttackLevel = attacker.getAttackLevel();
        int baseDefenceLevel = defender.getDefenceStrength();

        // add random factor for this hit (5 - 25 x)
        int randomizedAttackValue = RandomUtil.getRandomIntInclusive(5) * baseAttackLevel * 10;
        int randomizedDefenceValue = RandomUtil.getRandomIntInclusive(5) * baseDefenceLevel * 10;

        if(randomizedAttackValue > randomizedDefenceValue / 2) {
            int damageDone = (randomizedAttackValue * 2) / randomizedDefenceValue;
            attacker.doDamage(damageDone);
            defender.receiveDamage(damageDone);
            if(Constants.SHOW_DEBUG) System.out.println(attacker.getName() + " hits " + defender.getName() + " doing " + damageDone + " damage.");
            if(defender.isDead()) {
                attacker.registerKill();
                System.out.println(attacker.getName() + " kills " + defender.getName());
            }
        } else {
            if(Constants.SHOW_DEBUG) System.out.println(defender.getName() + " deflects the blow from " + attacker.getName());
        }
    }

    public void simulateBattleItemDrops(List<Contestant> contestants, int findingChancePercent) {
        BattleItemGenerator battleItemGenerator = new BattleItemGenerator();

        for (Contestant contestant : contestants) {
            if(contestant.getBattleItem() == null && RandomUtil.getRandomIntExclusive(100) < findingChancePercent) {
                BattleItem randomBattleItem = battleItemGenerator.generateRandomBattleItem();
                contestant.setBattleItem(randomBattleItem);

                System.out.println(contestant.getName() + " picks up a " + randomBattleItem.getName());
            }
        }
    }
}
