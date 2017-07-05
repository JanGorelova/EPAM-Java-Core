package seeBattle.players;

import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public final class SmartComputer implements Player {
    @Override
    public final Coordinates getCoordinates() {
        // TODO: Do after
        throw new RuntimeException("No No!");
    }

    @Override
    public Field createField() {
        //TODO: Implement
        return null;
    }

    @Override
    public final String getName() {
        return "Smart computer #" + (int) (Math.random() * 100);
    }
}
