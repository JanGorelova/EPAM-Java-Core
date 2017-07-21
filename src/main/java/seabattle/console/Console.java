package seabattle.console;

import seabattle.model.Coordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Console implements AutoCloseable {
    private final InputStreamReader streamReader;
    private final BufferedReader reader;

    public Console() {
        this.streamReader = new InputStreamReader(System.in);
        this.reader       = new BufferedReader(streamReader);
    }

    public final Coordinates getCoordinates() {
        try{
            final String line = reader.readLine();
            final String[] parameters = line.split(" ");

            if (parameters.length != 2) {
                throw new RuntimeException("6");
            }

            return new Coordinates(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("The exception :",e);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final String getName() throws IOException {
        System.out.println("Please put your name");
        return reader.readLine();
    }

    @Override
    public final void close() throws IOException {
        reader.close();
        streamReader.close();
    }
}
