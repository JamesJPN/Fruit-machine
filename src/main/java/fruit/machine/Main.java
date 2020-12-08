package fruit.machine;

import java.util.HashMap;
import java.util.Map;

import static fruit.machine.FruitMachineGame.NUMBER_OF_REELS;

//The player starts with £1 credit, with each go costing 20 p.
//If the Fruit Machine “rolls” two of the same symbol, the user wins 50 p.
//The player wins £1 for three of the same and £5 for 3 Bells.
//The player loses £1 if two skulls are rolled and all of his/her money if three skulls are rolled.
//The player can choose to quit with the winnings after each roll or keep playing until there is no money left.

public class Main {

    public static void main(String[] args) {
        FruitMachineGame game = new FruitMachineGame();
        Symbol[] reelSymbols = game.pickRandomSymbolsForReels(new Symbol[NUMBER_OF_REELS]);
        game.displayReels(reelSymbols);
        Map<Symbol, Integer> symbolCounts = game.getResults(reelSymbols, new HashMap<>());
        game.displayResults(symbolCounts);
    }
}