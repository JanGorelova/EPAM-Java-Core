package duckCasino;


public final class Account {
    private int cash;

    public Account(final int cash) {
        this.cash = cash;
    }

    public final int debit(final int amount) {
        if (amount <= 0)
            throw new RuntimeException("The amount must be positive!");

        cash += amount;
        return cash;
    }

    public final int withdraw(final int amount) {
        if (amount > cash)
            throw new RuntimeException("You have not enough money!");

        if (amount < 0)
            throw new RuntimeException("The amount must be positive!");

        cash -= amount;
        return cash;
    }

    public final int getCash() {
        return cash;
    }
}
