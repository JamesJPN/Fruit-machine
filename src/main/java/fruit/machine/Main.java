package fruit.machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//The player starts with £1 credit, with each go costing 20 p.
//If the Fruit Machine “rolls” two of the same symbol, the user wins 50 p.
//The player wins £1 for three of the same and £5 for 3 Bells.
//The player loses £1 if two skulls are rolled and all of his/her money if three skulls are rolled.
//The player can choose to quit with the winnings after each roll or keep playing until there is no money left.

public class Main {

    private static final Random random = new Random();
    private static final double credit = 1.00;
    public static final int NUMBER_OF_REELS = 3;

    double costToPlay = 0.20;
    double twoSymbolWin = 0.50;
    double threeSymbolWin = 1.00;
    double threeBellWin = 5.00;
    double twoSkullLoss = -1.00;

    public static void main(String[] args) {
        Symbol[] reelSymbols = pickRandomSymbolsForReels(new Symbol[NUMBER_OF_REELS]);
        displayReels(reelSymbols);
        Map<Symbol, Integer> symbolCounts = new HashMap<>();
        getResults(reelSymbols, symbolCounts);
        displayResults(symbolCounts);
    }

    private static void getResults(Symbol[] symbols, Map<Symbol, Integer> symbolCounts) {
        // for each symbol
        for (Symbol symbol : symbols) {
            incrementSymbolCounter(symbol, symbolCounts);
        }
    }

    private static void incrementSymbolCounter(Symbol symbol, Map<Symbol, Integer> symbolCounts) {
        if (symbolCounts.get(symbol) == null) {
            symbolCounts.put(symbol, 1);
        } else {
            int incrementedValue = symbolCounts.get(symbol) + 1;
            symbolCounts.put(symbol, incrementedValue);
        }
    }

    private static Symbol[] pickRandomSymbolsForReels(Symbol[] symbols) {
        for (int reelIndex = 0; reelIndex < symbols.length; reelIndex++) {
            int choice = random.nextInt(6);
            switch (choice) {
                case 0 -> symbols[reelIndex] = Symbol.CHERRY;
                case 1 -> symbols[reelIndex] = Symbol.ORANGE;
                case 2 -> symbols[reelIndex] = Symbol.LEMON;
                case 3 -> symbols[reelIndex] = Symbol.BELL;
                case 4 -> symbols[reelIndex] = Symbol.STAR;
                case 5 -> symbols[reelIndex] = Symbol.SKULL;
            }
        }
        return symbols;
    }

    private static void displayReels(Symbol[] symbols) {
        for (Symbol symbol : symbols) {
            System.out.print(symbol + " ");
        }
        System.out.println();
    }

    private static void displayResults(Map<Symbol, Integer> symbolCounts) {
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