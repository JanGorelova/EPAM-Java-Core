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
        return null;
    }

    @Override
    public String toString() {
        // shows the field view
        return null;
    }
}

