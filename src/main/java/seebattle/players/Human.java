package seebattle.players;

import seebattle.console.Console;
import seebattle.fieldconstructors.RandomConstructor;
import seebattle.model.Coordinates;
import seebattle.model.Field;

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
