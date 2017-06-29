package duckCasino;

import duckCasino.console.Command;
import duckCasino.console.NumberReader;
import duckCasino.ducks.DuckCompetition;

import java.io.IOException;
import java.util.Random;


import static duckCasino.constants.Constants.CASH_STARTUP;
import static duckCasino.constants.Constants.DUCKS_COUNT;


public final class Casino {

    private static final Random random = new Random();

    public static void main(final String[] args) throws IOException {
        final NumberReader reader = new NumberReader();
        final Account playerAccount = new Account(CASH_STARTUP);
        final DuckCompetition competition = new DuckCompetition(DUCKS_COUNT);

        System.out.println("Welcome to duck casino! There are " + DUCKS_COUNT + " ducks. Let's win some money!");

        while (playerAccount.getCash() != 0) {
            System.out.println("You have $" + playerAccount.getCash() + ". Please choose duck (1 - " + DUCKS_COUNT + ") " +
                    "and bet (1 - $" + playerAccount.getCash() + "). Type \"quit\" if you want to stop the game");
            Command currentCommand = reader.getCommand();

            if (competition.findWinner() != currentCommand.getDucknumber())
                System.out.println("You loose! Your cash: $ " + playerAccount.withdraw(currentCommand.getBet()));
            else System.out.println("You won! Your cash: $ " + playerAccount.debit(currentCommand.getBet()));
        }
        System.out.println("You loose, bye-bye");
    }
}
