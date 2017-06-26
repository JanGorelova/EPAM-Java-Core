package duckCasino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CasinoTest {
    public static void main(String[] args) throws IOException {

        int cash = 500;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to duck casino! There are 5 ducks. Let's win some money!");
        while (cash != 0) {
            System.out.println("You have $" + cash + ". Please choose duck (1 - 5) and bet (1 - $" + cash + "). Type \"quit\" if you want to stop the game");
            final String line = reader.readLine();
            if (line.equalsIgnoreCase("quit"))
                break;

            final String[] parameters = line.split(" ");
            if (parameters.length != 2) {
                System.out.println("Please, use following format: duck bet");
                continue;
            }

            final int duck = Integer.parseInt(parameters[0]);
            if (duck < 1 || duck > 5) {
                System.out.println("The Duck number is invalid, the number must be from 1 to 5");
                continue;
            }

            final int bet = Integer.parseInt(parameters[1]);
            if (bet < 1 || bet > cash) {
                System.out.println("The amount is invalid, it must be from 1 to " + cash);
                continue;
            }
        }

        System.out.println("Your cash: $" + cash + ". Bye-bye!");
    }
}
