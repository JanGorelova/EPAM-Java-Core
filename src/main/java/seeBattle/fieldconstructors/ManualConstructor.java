package seeBattle.fieldconstructors;

import seeBattle.model.Field;

public final class ManualConstructor implements FieldConstructor {
    @Override
    public final Field construct() {
        throw new RuntimeException("May be once I will decide to write it!");
    }
}
