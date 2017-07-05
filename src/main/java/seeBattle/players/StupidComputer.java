package seeBattle.players;

import seeBattle.SeaBattle;
import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

import java.util.Random;

public final class StupidComputer extends Player {
    public StupidComputer() {
        super("Smart computer #" + (int) (Math.random() * 100));
    }

    @Override
    public final Coordinates getCoordinates() {
        final Random random = new Random();

        return new Coordinates(random.nextInt(SeaBattle.FIELD_LENGTH), random.nextInt(SeaBattle.FIELD_HEIGHT));
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
