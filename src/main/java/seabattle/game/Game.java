package seabattle.game;

import seabattle.model.*;
import seabattle.players.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class Game {
    private final Player player1;
    private final Player player2;

    private final Field field1;
    private final Field field2;

    private Turn turn;

    /**
     * constructs the game with two players
     *
     * @param player1 to take part in game
     * @param player2 to take part in game
     */
    public Game(final Player player1, final Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.field1 = player1.createField();
        this.field2 = player2.createField();

        this.turn = Turn.Player1;
    }

    private boolean hasShips() {
        return field1.hasShips() && field2.hasShips();
    }

    /**
     * starts the game and plays while it has ships
     */
    public final void play() {
        Player currentPlayer = player1;
        Field currentField;

        while (hasShips()) {
            switch (turn) {
                case Player1:
                    currentPlayer = player1;
                    currentField = field2;
                    break;
                case Player2:
                    currentPlayer = player2;
                    currentField = field1;
                    break;
                default:
                    throw new RuntimeException("Something went wrong. Can't determine current player");
            }

            System.out.println(currentPlayer.getName() + ", it's your turn. Please put the coordinates! Target field:");
            System.out.print(currentField);

            final Coordinates currentCoordinates = currentPlayer.getCoordinates();
            if (currentCoordinates == null) {
                System.out.println("Wrong coordinates have been specified!");
                continue;
            }

            if (!currentField.contains(currentCoordinates)) {
                System.out.println("Coordinates are out of the field boundaries!");
                continue;
            }

            System.out.println("Shooting at: " + currentCoordinates);

            final ShotResult result = currentField.shot(currentCoordinates);
            switch (result) {
                case AlreadyShoot:
                    System.out.println("You have already shoot this cell!");
                    break;
                case Miss:
                    System.out.println("You miss!");
                    turn = nextPlayer();
                    break;
                case Hit:
                    System.out.println("The ship has been damaged!");

                    if (sankShipIfPossible(currentCoordinates, currentField))
                        System.out.println("The ship has been sank!");
                    break;
            }
        }

        System.out.println("The game is over! The winner is:" + currentPlayer.getName());
    }

    /**
     *
     *
     * @param coordinates of the ship
     * @param field to be considered
     * @return List of coordinates
     */
    private List<Coordinates> getShipCellCoordinates(final Coordinates coordinates, final Field field) {
        final List<Coordinates> shipCells = new ArrayList<>();
        shipCells.add(coordinates);

        final Queue<Coordinates> queue = new LinkedList<>();
        queue.add(coordinates);

        while (!queue.isEmpty()) {
            final Coordinates currentCoordinates = queue.poll();

            for (final Direction direction : Direction.values()) {
                final Coordinates currentNeighbour = Coordinates.getNeighbour(currentCoordinates, direction);
                if (!field.contains(currentNeighbour))
                    continue;

                if (shipCells.contains(currentNeighbour))
                    continue;

                if (field.getCell(currentNeighbour) == Cell.Ship || field.getCell(currentNeighbour) == Cell.DamagedShip) {
                    shipCells.add(currentNeighbour);
                    queue.add(currentNeighbour);
                }
            }
        }

        return shipCells;
    }

    private boolean sankShipIfPossible(final Coordinates coordinates, final Field field) {
        final List<Coordinates> shipCellCoordinates = getShipCellCoordinates(coordinates, field);

        for (final Coordinates currentCellCoordinates : shipCellCoordinates)
            if (field.getCell(currentCellCoordinates) == Cell.Ship)
                return false;

        markNeighboursAsShoot(shipCellCoordinates, field);

        return true;
    }

    /**
     * Marks neighbours of the shoot cell
     *
     * @param shipCellCoordinates neighbours coordinates
     * @param field to be considered
     */
    private void markNeighboursAsShoot(final List<Coordinates> shipCellCoordinates, final Field field) {
        for (final Coordinates coordinates : shipCellCoordinates)
            for (final Neighbour neighbour : Neighbour.values()) {
                final Coordinates currentNeighbourCoordinates = Coordinates.getNeighbour(coordinates, neighbour);

                if (!field.contains(currentNeighbourCoordinates))
                    continue;

                if (field.getCell(currentNeighbourCoordinates) == Cell.Water)
                    field.setCell(currentNeighbourCoordinates, Cell.ShootWater);
            }
    }

    private Turn nextPlayer() {
        return turn == Turn.Player1 ? Turn.Player2 : Turn.Player1;
    }
}
