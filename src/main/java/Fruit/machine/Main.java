package Fruit.machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//The player starts with £1 credit, with each go costing 20 p.
//If the Fruit Machine “rolls” two of the same symbol, the user wins 50 p.
//The player wins £1 for three of the same and £5 for 3 Bells.
//The player loses £1 if two skulls are rolled and all of his/her money if three skulls are rolled.
//The player can choose to quit with the winnings after each roll or keep playing until there is no money left.

public class Main {

    private static final String CHERRY = "cherry";
    private static final String ORANGE = "orange";
    private static final String LEMON = "lemon";
    private static final String BELL = "bell";
    private static final String STAR = "star";
    private static final String SKULL = "skull";
    private static final Random random = new Random();
    private static final double credit = 1.00;

    double cost = 0.20;
    double twoSymWin = 0.50;
    double threeSymWin = 1.00;
    double threeBellWin = 5.00;
    double twoSkullLoss = -1.00;

    public static void main(String[] args) {
        String[] symbols = new String[3];
        pickRandomSymbolsForReels(symbols);
        displayReels(symbols);
        Map<String, Integer> symbolCounts = new HashMap<>();
        checkResults(symbols, symbolCounts);
        displayResults(symbolCounts);
    }


    private static void checkResults(String[] symbols, Map<String, Integer> symbolCounts) {
        // for each symbol
       
        if (symbolCounts.get(CHERRY) == null) {
            symbolCounts.put(CHERRY, 1);
        } else {
            int incrementedValue = symbolCounts.get(CHERRY) + 1;
            symbolCounts.put(CHERRY, incrementedValue);
        }
        if (symbolCounts.get(ORANGE) == null) {
            symbolCounts.put(ORANGE, 2);
        } else {
            int incrementedValue = symbolCounts.get(ORANGE) + 1;
            symbolCounts.put(ORANGE, incrementedValue);
        }
        if (symbolCounts.get(LEMON) == null) {
            symbolCounts.put(LEMON, 3);
        } else {
            int incrementedValue = symbolCounts.get(LEMON) + 1;
            symbolCounts.put(LEMON, incrementedValue);
        }
        if (symbolCounts.get(BELL) == null) {
            symbolCounts.put(BELL, 4);
        } else {
            int incrementedValue = symbolCounts.get(BELL) + 1;
            symbolCounts.put(BELL, incrementedValue);
        }
        if (symbolCounts.get(STAR) == null) {
            symbolCounts.put(STAR, 5);
        } else {
            int incrementedValue = symbolCounts.get(STAR) + 1;
            symbolCounts.put(STAR, incrementedValue);
        }
        if (symbolCounts.get(SKULL) == null) {
            symbolCounts.put(SKULL, 6);
        } else {
            int incrementedValue = symbolCounts.get(SKULL) + 1;
            symbolCounts.put(SKULL, incrementedValue);
        }
    }


    private static String[] pickRandomSymbolsForReels(String[] symbols) {

        for (int reelIndex = 0; reelIndex < symbols.length; reelIndex++) {
            int choice = random.nextInt(6);
            switch (choice) {
                case 0 -> symbols[reelIndex] = CHERRY;
                case 1 -> symbols[reelIndex] = ORANGE;
                case 2 -> symbols[reelIndex] = LEMON;
                case 3 -> symbols[reelIndex] = BELL;
                case 4 -> symbols[reelIndex] = STAR;
                case 5 -> symbols[reelIndex] = SKULL;
            }
        }

        return symbols;
    }

    private static void displayReels(String[] symbols) {
        for (String symbol : symbols) {
            System.out.print(symbol + " ");
        }
        System.out.println();
    }

    private static void displayResults(Map<String, Integer> symbolCounts) {
        /**
         * Here you'll need to understand the logic of various events.
         * e.g
         * 3 skulls - instantly lose all credit - game over
         * 2 skulls - decreaseBalance(1.00)
         * 3 Bells - increaseBalance(amount)
         * 3 of any other symbol - increaseBalance(amount)
         * 2 of any thing else - increaseBalance(amount)
         * .. etc
         */
        //if (hasThreeSkulls(symbolCounts.get(SKULL)) ){
        //gameOver();
        // } else if (hasTwoSkulls(symbolCounts.get(SKULL)) {
        //   decreaseBalance(100) // note when working with money, store pence amount only and display the value as pounds and pence.. otherwise you'll have issues
        // } etc ..
    }

}