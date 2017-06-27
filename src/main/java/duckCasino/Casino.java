package duckCasino;


import duckCasino.ducks.AmazingDuck;
import duckCasino.ducks.Duck;
import duckCasino.ducks.RubberDuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public final class Casino {
    private static final int CASH_STARTUP = 500;
    private static final int COMPETITION_TIME = 10;
    private static final int DUCKS_COUNT = 5;

    private static final Random random = new Random();

    public static void main(final String[] args) throws IOException {
        int cash = CASH_STARTUP;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to duck casino! There are " + DUCKS_COUNT + " ducks. Let's win some money!");
        while (cash != 0) {
            System.out.println("You have $" + cash + ". Please choose duck (1 - " + DUCKS_COUNT + ") and bet (1 - $" + cash + "). Type \"quit\" if you want to stop the game");
            final String line = reader.readLine();
            if (line.equalsIgnoreCase("quit"))
                break;

            final String[] parameters = line.split(" ");
            if (parameters.length != 2) {
                System.out.println("Please, use following format: duck bet");
                continue;
            }

            final int duck = Integer.parseInt(parameters[0]);
            if (duck < 1 || duck > DUCKS_COUNT) {
                System.out.println("The Duck number is invalid, the number must be from 1 to " + DUCKS_COUNT);
                continue;
            }

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

        for (int i = 0; i < ducks.length; i++) {
            final double currentDuckDistance = ducks[i].performFly(COMPETITION_TIME);
            if (currentDuckDistance > maximalDistance) {
                maximalDistance = currentDuckDistance;
                bestDuckNumber = i;
            }
        }

        return bestDuckNumber + 1;
    }
}
