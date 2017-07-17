package duckcasino;

import duckcasino.console.Command;
import duckcasino.console.NumberReader;
import duckcasino.constants.Constants;

public final class Casino {
    public static void main(final String[] args) {
        final NumberReader reader = new NumberReader();
        final Account playerAccount = new Account(Constants.CASH_STARTUP);
        final DuckCompetition competition = new DuckCompetition(Constants.DUCKS_COUNT);

        System.out.println("Welcome to duck casino! There are " + Constants.DUCKS_COUNT + " ducks. Let's win some money!");

        while (playerAccount.getCash() != 0) {
            System.out.println("You have $" + playerAccount.getCash() + ". Please choose duck (1 - " + Constants.DUCKS_COUNT + ") " +
                    "and bet (1 - $" + playerAccount.getCash() + "). Type \"quit\" if you want to stop the game");

            try {
                final Command currentCommand = reader.getCommand();
                playerAccount.withdraw(currentCommand.getBet());

                if (competition.findWinner() != currentCommand.getDuckNumber())
                    System.out.println("You duck loose competition!");
                else {
                    playerAccount.debit(2 * currentCommand.getBet());
                    System.out.println("Your duck won competition!");
                }
            } catch (final Throwable e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("You loose, bye-bye");
    }
}
