package duckCasino;

import duckCasino.ducks.DuckCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static duckCasino.Constants.CASH_STARTUP;
import static duckCasino.Constants.COMPETITION_TIME;
import static duckCasino.Constants.DUCKS_COUNT;

public final class Casino {

    private static final Random random = new Random();

    public static void main(final String[] args) throws IOException {
        int cash = CASH_STARTUP;
        final NumberReader reader = new NumberReader();
        final Account playerAccount = new Account(CASH_STARTUP);
        final DuckCompetition competition = new DuckCompetition(DUCKS_COUNT);

        System.out.println("Welcome to duck casino! There are " + DUCKS_COUNT + " ducks. Let's win some money!");

        while (playerAccount.getCash()!= 0) {
            System.out.println("You have $" + playerAccount.getCash() + ". Please choose duck (1 - " + DUCKS_COUNT + ") " +
                    "and bet (1 - $" + cash + "). Type \"quit\" if you want to stop the game");

            reader.getCommand();
            System.out.println("Your cash: $" + cash + ". Bye-bye!");
        }
            }


}
