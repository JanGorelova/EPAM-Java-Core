package seeBattle;

import seeBattle.game.Game;
import seeBattle.players.Human;
import seeBattle.players.StupidComputer;

public final class SeaBattle {
    public static void main(final String[] args) {
        final int FIELD_LENGTH = 10;
        final int FIELD_WIDTH  = 10;

        final Game ourGame = new Game(new Human(), new StupidComputer(), FIELD_LENGTH, FIELD_WIDTH);
        ourGame.play();
    }
}
