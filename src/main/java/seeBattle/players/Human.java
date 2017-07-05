package seeBattle.players;

import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Human implements Player, AutoCloseable {
    private final InputStreamReader streamReader;
    private final BufferedReader reader;
    private final String name;

    public Human() throws IOException {
        this.streamReader = new InputStreamReader(System.in);
        this.reader = new BufferedReader(streamReader);

        System.out.println("Hello, put your name, please");
        this.name = reader.readLine();
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
    public final Field createField() {
        return new RandomConstructor().construct();
    }

    @Override
    public final String getName() {
        return name;
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
