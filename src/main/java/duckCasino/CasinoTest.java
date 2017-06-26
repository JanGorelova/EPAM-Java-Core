package duckCasino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CasinoTest {
    public static void main(String[] args) throws IOException {

        int cash = 500;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to duck casino! There are 5 ducks. Let's win some money!");
        while(cash != 0) {
            System.out.println("You have $" + cash + ". Please choose duck (1 - 5) and bet (1 - $" + cash + "). Type \"quit\" if you want to stop the game");
            final String line = reader.readLine();
            if (line.equalsIgnoreCase("quit"))
                break;
        }

        System.out.println("Your cash: $" + cash + ". Bye-bye!");
    }
}
