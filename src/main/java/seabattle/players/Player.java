package seabattle.players;

import seabattle.model.Coordinates;
import seabattle.model.Field;

public abstract class Player {
    private final String name;

    public Player(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract Coordinates getCoordinates();
    public abstract Field createField();
}
