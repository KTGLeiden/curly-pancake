package com.capgemini.koen;

import com.capgemini.koen.controllers.GamesController;

public class Main {

    public static void main(String[] args) {
        GamesController controller = new GamesController();
        controller.simulateGame();
    }
}
