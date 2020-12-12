package fruit.machine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitMachineGameTest {

    FruitMachineGame testObject;

    /**
     * This is run before each test to initialise objects ready
     * for each test to be run
     */
    @BeforeEach
    void setUp() {
        testObject = new FruitMachineGame();
    }

    /**
     * tests follow the same format
     * - given (some preconditions)
     * - when (we call method x on testObject)
     * - then (expect the following results)
     * Tests state what we want to happen when each method
     * is called with different inputs. Think: Input->Some Process->Output
     */
    @Test
    void shouldReturnThreeSymbols_WhenThreeSymbolsAreProvided() {
        // given
        Symbol[] reels = new Symbol[3];
        reels[0] = Symbol.BELL;
        reels[1] = Symbol.BELL;
        reels[2] = Symbol.BELL;

        // when - method we want to test - typically call a method on 'testObject'
        String gameResult = testObject.getGameResult(reels);

        // then - expect some outcome - specify what we want to happen
        assertEquals("bell bell bell ", gameResult);
    }
}