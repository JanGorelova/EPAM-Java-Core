package duckCasino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberReader {
    private final BufferedReader reader;


    public NumberReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public final Command getCommand() throws IOException {
        final String line = reader.readLine();
        final String[] parameters = line.split(" ");

        if (line.equalsIgnoreCase("quit"))
            System.exit(0);

        if (parameters.length != 2)
            System.out.println("Please, print the right format!");

        return new Command(Integer.parseInt(parameters[0]),Integer.parseInt(parameters[1]));
    }

}
