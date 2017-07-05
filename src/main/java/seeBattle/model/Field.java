package seeBattle.model;

public final class Field {
    private final Cell[][] cells;

    public Field(final int length, final int height) {
        this.cells = new Cell[length][height];

        for (int column = 0; column < length; column++)
            for (int row = 0; row < height; row++)
                cells[column][row] = Cell.Water;
    }

    public final boolean contains(final Coordinates coordinates) {
        return between(coordinates.x, 0, getLength()) && between(coordinates.y, 0, getHeight());
    }

    private boolean between(final int value, final int min, final int max) {
        return value >= min && value < max;
    }

    private int getHeight() {
        return cells[0].length;
    }

    private int getLength() {
        return cells.length;
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

    public final ShotResult shot(final Coordinates coordinates) {
        switch (getCell(coordinates)) {
            case Water:
                setCell(coordinates, Cell.ShotedWater);
                return ShotResult.Miss;

            case ShotedWater:
                return ShotResult.AlreadyShoted;

            case DamagedShip:
                return ShotResult.AlreadyShoted;

            case Ship:
                setCell(coordinates, Cell.DamagedShip);
                //TODO: Check if ship has been sank
                return ShotResult.Hit;
        }

        throw new RuntimeException("Something went wrong");
    }

    private Cell getCell(final Coordinates coordinates) {
        return cells[coordinates.x][coordinates.y];
    }

    private void setCell(final Coordinates coordinates, final Cell cell) {
        cells[coordinates.x][coordinates.y] = cell;
    }
}

