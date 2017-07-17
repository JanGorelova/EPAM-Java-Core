package seebattle.model;

import java.util.Random;

public final class Coordinates {
    public final int x;
    public final int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates random(final int length, final int height) {
        final Random random = new Random();
        return new Coordinates(random.nextInt(length), random.nextInt(height));
    }

    public static Coordinates getNeighbour(final Coordinates coordinates, final Directional directional) {
        return new Coordinates(coordinates.x + directional.getDx(), coordinates.y + directional.getDy());
    }

    @Override
    public final boolean equals(final Object obj) {
        return (obj != null) && (obj instanceof Coordinates) && (((Coordinates) obj).x == this.x) && (((Coordinates) obj).y == this.y);
    }

    @Override
    public final String toString() {
        return "[" + x + ", " + y + "]";
    }
}
