package seeBattle.players;

import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class SmartComputer extends Player {
    public SmartComputer() {
        super("Smart computer #" + (int) (Math.random() * 100));
    }

    @Override
    public final Coordinates getCoordinates() {
        // TODO: Do after
        throw new RuntimeException("No No!");
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
