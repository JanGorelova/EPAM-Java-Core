package duckcasino;


public final class Account {
    private int cash;

    public Account(final int cash) {
        this.cash = cash;
    }

    /**
     * deposits the money to account
     *
     * @param amount money to be deposited
     */
    public final void debit(final int amount) {
        if (amount <= 0)
            throw new RuntimeException("The amount must be positive!");

        cash += amount;
    }

    /**
     * withdraws the money from account
     *
     * @param amount money to be withdrawn
     */
    public final void withdraw(final int amount) {
        if (amount > cash)
            throw new RuntimeException("You have not enough money!");

        if (amount < 0)
            throw new RuntimeException("The amount must be positive!");

        cash -= amount;
    }

    public final int getCash() {
        return cash;
    }
}
