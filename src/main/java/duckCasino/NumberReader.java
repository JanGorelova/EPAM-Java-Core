package duckCasino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberReader {
    private final BufferedReader reader;
    private int bet;
    private int duckNumber;

    public NumberReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.bet = 0;
        this.duckNumber = 0;
    }

    public final void getCommand() throws IOException {
        final String line = reader.readLine();
        if (line.equalsIgnoreCase("QUIT"))
            System.out.println();;
        String[] paramerers = line.split(" ");

        if (paramerers.length != 2)
            System.out.println();
        this.bet = Integer.parseInt(paramerers[0]);
        this.duckNumber = Integer.parseInt(paramerers[0]);
    }

}
