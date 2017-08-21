package seabattle.fieldconstructors;

import seabattle.SeaBattle;
import seabattle.model.*;

public final class RandomConstructor implements FieldConstructor {
    /**
     * constructs new Field with random ship location
     *
     * @return new Field
     */
    @Override
    public final Field construct() {
        final Field field = new Field(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);

        for (int size = 4; size >= 1; size--)
            for (int count = 0; count < 4 - size + 1; count++) {
                Coordinates coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
                Direction direction = Direction.random();

                while (!isShipPlaced(field, coordinates, direction, size)) {
                    coordinates = Coordinates.random(SeaBattle.FIELD_LENGTH, SeaBattle.FIELD_HEIGHT);
                    direction = Direction.random();
                }

                placeShip(field, coordinates, direction, size);
            }

        return field;
    }

    /**
     * places ship in the field
     *
     * @param field to be considered
     * @param coordinates of the installed ship
     * @param direction of the ship location
     * @param size
     */
    private void placeShip(final Field field, final Coordinates coordinates, final Direction direction, final int size) {
        for (int i = 0; i < size; i++)
            field.setCell(new Coordinates(coordinates.x + i * direction.getDx(), coordinates.y + i * direction.getDy()), Cell.Ship);
    }

    private boolean isShipPlaced(final Field field, final Coordinates coordinates, final Direction direction, final int size) {
        for (int i = 0; i < size; i++)
            if (!isCellAvailable(field, new Coordinates(coordinates.x + i * direction.getDx(), coordinates.y + i * direction.getDy())))
                return false;

        return true;
    }

    private boolean isCellAvailable(final Field field, final Coordinates coordinates) {
        if (!field.contains(coordinates))
            return false;

        for (final Neighbour neighbour : Neighbour.values()) {
            final Coordinates neighbourCoordinates = Coordinates.getNeighbour(coordinates, neighbour);
            if (field.contains(neighbourCoordinates) && (field.getCell(neighbourCoordinates) != Cell.Water))
                return false;
        }

        return field.getCell(coordinates) == Cell.Water;
    }
}
