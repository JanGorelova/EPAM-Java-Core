package seeBattle.fieldconstructors;

import seeBattle.SeaBattle;
import seeBattle.model.Cell;
import seeBattle.model.Coordinates;
import seeBattle.model.Direction;
import seeBattle.model.Field;

import java.util.Random;

public final class RandomConstructor implements FieldConstructor {
    @Override
    public final Field construct() {
        final Field field = new Field(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);

        for (int size = 4; size >= 1; size--)
            for (int count = 0; count < 4 - size + 1; count++) {
                Coordinates coordinates = selectFreeCell(field);
                Direction direction     = Direction.random();

                while (!isShipPlaced(coordinates, direction, size)) {
                    coordinates = selectFreeCell(field);
                    direction = Direction.random();
                }

                placeShip(coordinates, direction, size);
            }

        return field;
    }

    private void placeShip(final Coordinates coordinates, final Direction direction, final int size) {

    }

    private boolean isShipPlaced(final Coordinates coordinates, final Direction direction, final int size) {
        return false;
    }

    private Coordinates selectFreeCell(final Field field) {
        Coordinates coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
        while (field.getCell(coordinates) != Cell.Water)
            coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);

        return coordinates;
    }
}
