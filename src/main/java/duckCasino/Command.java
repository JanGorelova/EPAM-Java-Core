package duckCasino;


public final class Command {
    private final int bet;
    private final int duckNumber;

    public Command(final int bet, final int duckNumber) {
        this.bet = bet;
        this.duckNumber = duckNumber;
    }

}
