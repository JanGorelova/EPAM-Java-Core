package seabattle.players;

import seabattle.SeaBattle;
import seabattle.fieldconstructors.RandomConstructor;
import seabattle.model.Coordinates;
import seabattle.model.Field;

public final class StupidComputer extends Player {
    public StupidComputer() {
        super("Smart computer #" + (int) (Math.random() * 100));
    }

    /**
     * @return random coordinates from field
     */
    @Override
    public final Coordinates getCoordinates() {
        return Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
    }

    @Override
    public final Field createField() {
        return new RandomConstructor().construct();
    }
}
