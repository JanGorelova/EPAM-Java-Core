package seabattle;

import seabattle.game.Game;
import seabattle.players.StupidComputer;

import java.io.IOException;

public final class SeaBattle {
    public static final int FIELD_LENGTH = 10;
    public static final int FIELD_HEIGHT = 10;

    public static void main(final String[] args) throws IOException {
        final Game ourGame = new Game(new StupidComputer(), new StupidComputer());
        ourGame.play();
    }
}
