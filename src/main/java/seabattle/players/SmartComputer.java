package seabattle.players;

import seabattle.fieldconstructors.RandomConstructor;
import seabattle.model.Coordinates;
import seabattle.model.Field;

public final class SmartComputer extends Player {
    public SmartComputer() {
        super("Smart computer #" + (int) (Math.random() * 100));
    }

    @Override
    public final Coordinates getCoordinates() {
        throw new RuntimeException("No No!");
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
