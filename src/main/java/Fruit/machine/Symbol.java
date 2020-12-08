package Fruit.machine;

/**
 * Enum is a 'type' in Java. Using a type rather than "String" adds better
 * compile type checking and reduces the chance we introduce hard to find/debug errors.
 */
public enum Symbol {
    CHERRY("cherry"),
    ORANGE("orange"),
    LEMON("lemon"),
    BELL("bell"),
    STAR("star"),
    SKULL("skull");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * this will be implicitly called
     * when we attempt to print the symbol
     * to the console using : System.out.println
     * @return
     */
    @Override
    public String toString() {
        return symbol;
    }
}
