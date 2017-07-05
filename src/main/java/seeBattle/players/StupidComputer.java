package seeBattle.players;

import seeBattle.fieldconstructors.RandomConstructor;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class StupidComputer implements Player {
    @Override
    public final Coordinates getCoordinates() {
        //TODO: Implement
        return null;
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }

    public final String getName() {
        return "Stupid computer #" + (int) (Math.random() * 100);
    }
}
