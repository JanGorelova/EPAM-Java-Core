package seabattle.model;

import java.util.Random;

public enum Direction implements Directional {
    Up(0, -1),
    Down(0, 1),
    Left(-1, 0),
    Right(1, 0);

    private final int dx;
    private final int dy;

    /**
     * Creates direction
     * @param dx horizontal direction
     * @param dy vertical direction
     */
    Direction(final int dx, final int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public final int getDx() {
        return dx;
    }

    @Override
    public final int getDy() {
        return dy;
    }

    /**
     * @return random direction
     */
    public static Direction random() {
        final Random random = new Random();

        return Direction.values()[random.nextInt(Direction.values().length)];
    }
}
