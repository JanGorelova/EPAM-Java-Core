package seeBattle;

import seeBattle.game.Game;
import seeBattle.players.Human;
import seeBattle.players.StupidComputer;

import java.io.IOException;

public final class SeaBattle {
    public static void main(final String[] args) throws IOException {
        final Game ourGame = new Game(new Human(), new StupidComputer());
        ourGame.play();
    }
}
