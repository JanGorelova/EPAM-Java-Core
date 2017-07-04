package seeBattle.game;

import seeBattle.model.Field;
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

        while (!gameIsOver()) {
            System.out.println("Hello, put the coordinates please!");
//TODO: work with play method
//            ourGame.gameTurnHuman(console.getCoordinates());
//            results.gameCurrentResultHuman();
//            ourGame.gameTurnComputer(player1.getCoordinates());
//            results.gameCurrentResultComputer();
        }
//        System.out.println("The game is over! The winner is" + results.getWinnerName());
    }
}
