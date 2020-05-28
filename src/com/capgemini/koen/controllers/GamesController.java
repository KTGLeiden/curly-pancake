package com.capgemini.koen.controllers;

import com.capgemini.koen.models.Contestant;
import com.capgemini.koen.util.Constants;

import java.util.List;

/**
 * Controller for the games.
 * This is the main Games class, which is in charge of all the generation of contestants.
 */
public class GamesController {

    private int day = 1;
    private Contestant winner;

    private List<Contestant> contestants;

    /**
     * Simulates an entire game.
     */
    public void simulateGame()  {
        ContestantGenerator generator = new ContestantGenerator();
        try {
            contestants = generator.generateRandomContestants(Constants.AMOUNT_OF_CONTESTANTS);
        }
        catch (Exception e) {
            System.out.println("Something went wrong when generating the contestants. Please try again with " +
                    "a different number of contestants.");
            return;
        }

        GamesSimulator simulator = new GamesSimulator();

        printWelcomeMessage();

        while(contestants.size() > 1) {
            printDayHeader();
            contestants = simulator.simulateRound(contestants);
            simulator.simulateBattleItemDrops(contestants, 10);
            day++;
        }

        winner = contestants.get(0);
        printVictoryMessage();
    }

    private void printWelcomeMessage() {
        System.out.println("=======================================================================");
        System.out.println("========================== HUNGER GAMES ===============================");
        System.out.println("============= May the odds be forever in your favor ===================");
        System.out.println("=======================================================================");
    }

    private void printDayHeader() {
        System.out.println();
        System.out.println("========================================================================");
        System.out.println("========================================================================");
        System.out.println("========================================================================");
        System.out.println("Day " + day + ". There are still " + contestants.size() + " contestants alive.");
        System.out.println("========================================================================");
        System.out.println("========================================================================");
        System.out.println("========================================================================");
    }

    private void printVictoryMessage() {
        System.out.println("It is day " + day + ".");
        System.out.println("There is a sole survivor, " + winner.getName() + ".");
        System.out.println("He has killed " + winner.getKills() + " other contestants, has done " + winner.getDamageDone() +
                " damage and has received " + winner.getDamageTaken() + " damage.");
    }


}
