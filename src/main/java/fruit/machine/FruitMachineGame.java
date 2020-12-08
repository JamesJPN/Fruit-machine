package fruit.machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FruitMachineGame {

    private static final Random random = new Random();
    private static final int credit = 100;
    private static final int NUMBER_OF_REELS = 3;

    // Monetary values should be integers - when displaying them format them as dollars and cents.
    // using double for money will result in very strange results due to computational inaccuracy.
    private static final int costToPlay = 20;
    private static final int twoSymbolWin = 50;
    private static final int threeSymbolWin = 100;
    private static final int threeBellWin = 500;
    private static final int twoSkullLoss = -100;

    public FruitMachineGame() {
        Symbol[] reelSymbols = pickRandomSymbolsForReels(new Symbol[NUMBER_OF_REELS]);
        displayReels(reelSymbols);
        Map<Symbol, Integer> symbolCounts = new HashMap<>();
        getResults(reelSymbols, symbolCounts);
        displayResults(symbolCounts);
    }

    private void getResults(Symbol[] symbols, Map<Symbol, Integer> symbolCounts) {
        // for each symbol
        for (Symbol symbol : symbols) {
            incrementSymbolCounter(symbol, symbolCounts);
        }
    }

    private void incrementSymbolCounter(Symbol symbol, Map<Symbol, Integer> symbolCounts) {
        if (symbolCounts.get(symbol) == null) {
            symbolCounts.put(symbol, 1);
        } else {
            int incrementedValue = symbolCounts.get(symbol) + 1;
            symbolCounts.put(symbol, incrementedValue);
        }
    }

    private Symbol[] pickRandomSymbolsForReels(Symbol[] symbols) {
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

    private void displayReels(Symbol[] symbols) {
        for (Symbol symbol : symbols) {
            System.out.print(symbol + " ");
        }
        System.out.println();
    }

    private void displayResults(Map<Symbol, Integer> symbolCounts) {
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
