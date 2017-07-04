package seeBattle.model;

public final class Field {
    private final int length;
    private final int height;
    private final int[][] field;

    public Field(final int lengt, final int height) {
        this.height = height;
        this.length = lengt;
        this.field = new int[lengt][height];
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

