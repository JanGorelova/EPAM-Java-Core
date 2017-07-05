package seeBattle.players;

import seeBattle.SeaBattle;
import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class StupidComputer extends Player {
    public StupidComputer() {
        super("Smart computer #" + (int) (Math.random() * 100));
    }

    @Override
    public final Coordinates getCoordinates() {
        return Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
