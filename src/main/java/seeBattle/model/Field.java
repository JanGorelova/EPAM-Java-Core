package seeBattle.model;

public final class Field {
    private final int[][] field;

    public Field(final int length, final int height) {
        this.field = new int[length][height];
    }

    public final boolean contains(final Coordinates coordinates) {
        return between(coordinates.x, 0, getLength()) && between(coordinates.y, 0, getHeight());
    }

    private boolean between(final int value, final int min, final int max) {
        return value >= min && value < max;
    }

    private int getHeight() {
        return field[0].length;
    }

    private int getLength() {
        return field.length;
    }

    public final Field getFullField() {
        // TODO: implement
        return null;
    }

    @Override
    public String toString() {
        // TODO: Override toString
        return null;
    }
}

