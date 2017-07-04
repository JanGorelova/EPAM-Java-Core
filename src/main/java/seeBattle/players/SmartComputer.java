package seeBattle.players;

import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class SmartComputer implements Player {
    @Override
    public final Coordinates getCoordinates() {
        throw new RuntimeException("No No!");
    }

    @Override
    public Field createField() {
        return null;
    }
}
