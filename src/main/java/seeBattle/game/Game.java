package seeBattle.game;

import seeBattle.model.Field;
import seeBattle.players.Player;
import seeBattle.model.Coordinates;

public final class Game {
    private final Player computerPlayer;
    private final Field humanField;
    private final Field computerField;
    private final Player humanPlayer;

    public Game(final Player humanPlayer, final Player computerPlayer, final int fieldLength, final int fieldWidth) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.humanField = new Field(fieldLength,fieldWidth).getFullField();
        this.computerField = new Field(fieldLength,fieldWidth).getFullField();
    }

    private boolean gameIsOver() {
        // игра закончена если все корабли погибли на поле
        return false;
    }

    public final Field gameTurnHuman(final Coordinates coordinates) {
        // проверить координаты, что не выходят за пределы поля
        return null;
    }

    public final Field gameTurnComputer(final Coordinates coordinates) {
        // проверить координаты, что не выходят за пределы поля
        return null;
    }

    public final void play() {
        Turn turn = Turn.Human;

        while (!gameIsOver()) {
            System.out.println("Hello, put the coordinates please!");

//            ourGame.gameTurnHuman(console.getCoordinates());
//            results.gameCurrentResultHuman();
//            ourGame.gameTurnComputer(computerPlayer.getCoordinates());
//            results.gameCurrentResultComputer();
        }
//        System.out.println("The game is over! The winner is" + results.getWinnerName());
    }
}
