package seeBattle.model;

import java.util.Random;

public enum Direction {
    Up(0, -1),
    Down(0, 1),
    Left(-1, 0),
    Right(1, 0);

    private final int dx;
    private final int dy;

    Direction(final int dx, final int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public final int getDx() {
        return dx;
    }

    public final int getDy() {
        return dy;
    }

    public static Direction random() {
        final Random random = new Random();

        return Direction.values()[random.nextInt(Direction.values().length)];
    }
}