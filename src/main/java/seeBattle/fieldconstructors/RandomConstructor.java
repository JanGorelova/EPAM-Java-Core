package seeBattle.fieldconstructors;

import seeBattle.SeaBattle;
import seeBattle.model.Field;

public final class RandomConstructor implements FieldConstructor {
    @Override
    public final Field construct() {
        //TODO: Implement random places for ships
        return new Field(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
    }
}
