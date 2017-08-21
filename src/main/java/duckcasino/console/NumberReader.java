package duckcasino.console;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberReader {
    private final BufferedReader reader;

    public NumberReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * creates new command with parameters from console
     *
     * @return command from console
     * @throws IOException
     */
    public final Command getCommand() throws IOException {
        final String line         = reader.readLine();
        final String[] parameters = line.split(" ");
        final int duckNumber;

        try {
            duckNumber = Integer.parseInt(parameters[0]);
        } catch (final Exception e) {
            throw new RuntimeException("Specified duck number is incorrect");
        }

        final int bet;
        try {
             bet = Integer.parseInt(parameters[1]);
        } catch (final Exception e) {
            throw new RuntimeException("Specified bet is incorrect");
        }

        if (line.equalsIgnoreCase("quit"))
            System.exit(0);

        if (parameters.length != 2)
            System.out.println("Please, print the right format!");

        return new Command(duckNumber, bet);
    }
}
