package duckCasino;


public final class Command {
    private final int bet;
    private final int duckNumber;

    public Command(final int duckNumber, final int bet) {
        if (duckNumber <=0 || duckNumber > 5)
            throw new RuntimeException("Duck number maust be from 1 to 5!");
        this.bet = bet;
        this.duckNumber = duckNumber;
    }

    public final int getDucknumber() {
        return duckNumber;
    }

    public final int getBet() {
        return bet;
    }
}
