package seeBattle.model;

import java.util.Random;

public final class Coordinates {
    public final int x;
    public final int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final String toString() {
        return "[" + x + ", "+ y + "]";
    }

    public static Coordinates random(final int length, final int height) {
        final Random random = new Random();
        return new Coordinates(random.nextInt(length), random.nextInt(height));
    }
}
