package seeBattle.players;

import seeBattle.model.Coordinates;
import seeBattle.model.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Human implements Player, AutoCloseable {
    private final InputStreamReader streamReader;
    private final BufferedReader reader;

    public Human() {
        this.streamReader = new InputStreamReader(System.in);
        this.reader = new BufferedReader(streamReader);
    }

    @Override
    public final Coordinates getCoordinates() {
        final String line;

        //TODO: Move work with input to separate class
        // Command command = console.getCommand();
        // Command {
        //   String[] parameters;
        //   getParameter(int index)
        //   getParametersCount()
        // }
        //


        try {
            line = reader.readLine();
            final String[] parameters = line.split(" ");
            if (parameters.length != 2)
                System.out.println("Please, print the right format!");

            return new Coordinates(getParameter(parameters[0], "Specified X coordinate is incorrect"),
                                   getParameter(parameters[1], "Specified Y coordinate is incorrect"));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Field createField() {
        //TODO: Implement
        return null;
    }

    private int getParameter(final String parameter, final String message) {
        final int value;
        try {
            value = Integer.parseInt(parameter);
        } catch (final Exception e) {
            throw new RuntimeException(message);
        }

        return value;
    }

    @Override
    public final void close() throws IOException {
        reader.close();
        streamReader.close();
    }
}
