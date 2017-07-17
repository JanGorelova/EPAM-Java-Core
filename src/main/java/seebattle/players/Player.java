package seebattle.players;

import seebattle.model.Coordinates;
import seebattle.model.Field;

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
