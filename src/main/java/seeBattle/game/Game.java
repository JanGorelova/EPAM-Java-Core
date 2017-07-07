package seeBattle.game;

import seeBattle.model.*;
import seeBattle.players.Player;

public final class Game {
    private final Player player1;
    private final Player player2;

    private final Field field1;
    private final Field field2;

    private Turn turn;

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
                case AlreadyShoted:
                    System.out.println("You have already shoot this cell!");
                    break;
                case Miss:
                    System.out.println("You miss!");
                    turn = nextPlayer();
                    break;
                case Hit:
                    System.out.println("You damaged the ship!");
                    //TODO: Check if ship has been sank
                    //if (isSank())
                    break;
            }
        }

        System.out.println("The game is over! The winner is:" + currentPlayer.getName());
    }

    private void isSank(final Coordinates coordinates, final Field field) {
       // // TODO: finish this

//        if (getNeighbour(coordinates, Direction.Up,field)!= Cell.Ship
//                || getNeighbour(coordinates, Direction.Down,field)!= Cell.Ship
//                || getNeighbour(coordinates, Direction.Left,field)!= Cell.Ship
//                || getNeighbour(coordinates, Direction.Right,field)!= Cell.Ship) {
//            if




    }

    private Cell getNeighbour(final Coordinates coordinates, final Direction direction, final Field field) {
        return field.getCell(new Coordinates(coordinates.x + direction.getDx(), coordinates.y + direction.getDy()));
    }

    private Turn nextPlayer() {
        return turn == Turn.Player1 ? Turn.Player2 : Turn.Player1;
    }
}
