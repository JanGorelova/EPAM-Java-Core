package duckCasino;


public final class Command {
    private final int bet;
    private final int duckNumber;

    public Command(final int duckNumber, final int bet) {
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
