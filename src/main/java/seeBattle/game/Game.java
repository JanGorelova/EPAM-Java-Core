package seeBattle.game;

import seeBattle.model.Coordinates;
import seeBattle.model.Field;
import seeBattle.model.ShotResult;
import seeBattle.players.Player;

public final class Game {
    private final Player player1;
    private final Player player2;

    private final Field field1;
    private final Field field2;

    public Game(final Player player1, final Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.field1 = player1.createField();
        this.field2 = player2.createField();
    }

    private boolean gameIsOver() {
        //TODO: Implement
        return false;
    }

    public final void play() {
        Turn turn = Turn.Player1;

        Player currentPlayer = player1;
        Field currentField   = field2;

        while (!gameIsOver()) {
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

            System.out.println("Hello, " + currentPlayer.getName() + ", put the coordinates please!");
            final Coordinates currentCoordinates = currentPlayer.getCoordinates();

            if (!currentField.contains(currentCoordinates)) {
                System.out.println("Coordinates are out of the field boundaries!");
                continue;
            }

            final ShotResult result = currentField.shot(currentCoordinates);
            switch (result) {
                case AlreadyShoted:
                    System.out.println("You have already shoot this cell!");
                    // have an extra shot! or make a validation before every shot!
                    break;
                case Miss:
                    System.out.println("You miss!");
                    break;
//                case Hit:
//                    if (/* part of the ship was damaged*/)
//                        System.out.println("You damaged the ship!");
//                    continue; // wanna come back and this player has an extra shot!
//
//                    if (/*ship was sank */)
//                        System.out.println("The ship was sank! Congratulations!");
//                    break;
            }
        }

        System.out.println("The game is over! The winner is:" + currentPlayer.getName());
    }
}
