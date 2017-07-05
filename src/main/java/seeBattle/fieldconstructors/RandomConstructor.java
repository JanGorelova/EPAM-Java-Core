package seeBattle.fieldconstructors;

import seeBattle.SeaBattle;
import seeBattle.model.Cell;
import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class RandomConstructor implements FieldConstructor {
    @Override
    public final Field construct() {
        final Field field = new Field(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);

        //TODO: Implement random places for ships
        System.out.println(selectFreeCell(field));

        return field;
    }

    private Coordinates selectFreeCell(final Field field) {
        Coordinates coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
        while (field.getCell(coordinates) != Cell.Water)
            coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);

        return coordinates;
    }
}
