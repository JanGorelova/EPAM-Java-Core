package seabattle.players;

import seabattle.console.Console;
import seabattle.fieldconstructors.RandomConstructor;
import seabattle.model.Coordinates;
import seabattle.model.Field;

import java.io.IOException;

public final class Human extends Player {
    public Human() throws IOException {
        super(new Console().getName());
    }

    @Override
    public final Coordinates getCoordinates() {
        return new Console().getCoordinates();
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
