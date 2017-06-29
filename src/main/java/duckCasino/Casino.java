package duckCasino;

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


        System.out.println("Welcome to duck casino! There are " + DUCKS_COUNT + " ducks. Let's win some money!");
        while (playerAccount.getCash()!= 0) {
            System.out.println("You have $" + playerAccount.getCash() + ". Please choose duck (1 - " + DUCKS_COUNT + ") and bet (1 - $" + cash + "). Type \"quit\" if you want to stop the game");

            Command command = new Command();
            reader.getCommand();


            final int bet = Integer.parseInt(parameters[1]);
            if (bet < 1 || bet > cash) {
                System.out.println("The amount is invalid, it must be from 1 to " + cash);
                continue;
            }

            final Duck[] ducks = new Duck[DUCKS_COUNT];
            for (int i = 0; i < DUCKS_COUNT; i++)
                ducks[i] = getRandomDuck();

            if (duck == findWinner(ducks)){
                cash += bet;
                System.out.println("You won!");
            } else {
                cash -= bet;
                System.out.println("You loose!");
            }
        }

        System.out.println("Your cash: $" + cash + ". Bye-bye!");
    }

    private static Duck getRandomDuck() {
        if (random.nextBoolean())
            return new AmazingDuck();

        return new RubberDuck();
    }

    private static int findWinner(final Duck[] ducks) {
        double maximalDistance = 0;
        int bestDuckNumber = -1;

        System.out.println("Competition results:");
        for (int i = 0; i < ducks.length; i++) {
            final double currentDuckDistance = ducks[i].performFly(COMPETITION_TIME);

            System.out.println("Duck #" + (i + 1) + ": " + currentDuckDistance + " meters");
            if (currentDuckDistance > maximalDistance) {
                maximalDistance = currentDuckDistance;
                bestDuckNumber = i;
            }
        }

        return bestDuckNumber + 1;
    }
}
