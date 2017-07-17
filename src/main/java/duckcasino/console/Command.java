package duckcasino.console;


import duckcasino.constants.Constants;

public final class Command {
    private final int bet;
    private final int duckNumber;

    public Command(final int duckNumber, final int bet) {
        if (duckNumber <= 0 || duckNumber > Constants.DUCKS_COUNT)
            throw new RuntimeException("Duck number must be from 1 to 5!");

        this.bet = bet;
        this.duckNumber = duckNumber;
    }

    public final int getDuckNumber() {
        return duckNumber;
    }

    public final int getBet() {
        return bet;
    }
}
