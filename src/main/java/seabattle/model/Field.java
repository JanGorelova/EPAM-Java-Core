package seabattle.model;

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

    public final int getHeight() {
        return cells[0].length;
    }

    public final int getLength() {
        return cells.length;
    }

    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder("  ");

        for (int column = 0; column < getLength(); column++)
            builder.append(column).append(" ");
        builder.append("\n");

        for (int row = 0; row < getHeight(); row++) {
            builder.append(row).append(" ");

            for (int column = 0; column < getLength(); column++)
                switch (cells[column][row]) {
                    case Water:
                        builder.append("~ ");
                        break;
                    case ShotedWater:
                        builder.append(". ");
                        break;
                    case DamagedShip:
                        builder.append("X ");
                        break;
                    case Ship:
                        builder.append("~ ");
                        break;
                }

            builder.append("\n");
        }

        return builder.toString();
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
                return ShotResult.Hit;
        }

        throw new RuntimeException("Something went wrong");
    }

    public final Cell getCell(final Coordinates coordinates) {
        return cells[coordinates.x][coordinates.y];
    }

    public final void setCell(final Coordinates coordinates, final Cell cell) {
        cells[coordinates.x][coordinates.y] = cell;
    }

    public final boolean hasShips() {
        for (int row = 0; row < getLength(); row++)
            for (int col = 0; col < getHeight(); col++)
                if (cells[row][col] == Cell.Ship) {
                    return true;
                }
        return false;
    }
}

