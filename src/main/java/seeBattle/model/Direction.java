package seeBattle.model;

import java.util.Random;

public enum Direction {
    Up,
    Down,
    Left,
    Right;

    public static Direction random() {
        final Random random = new Random();

        return Direction.values()[random.nextInt(Direction.values().length)];
    }
}
