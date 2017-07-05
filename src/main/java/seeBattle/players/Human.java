package seeBattle.players;

import seeBattle.console.Console;
import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

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
