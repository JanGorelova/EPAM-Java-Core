package seeBattle;

import seeBattle.game.Game;
import seeBattle.players.Human;
import seeBattle.players.StupidComputer;

public final class SeaBattle {
    public static void main(final String[] args) {
        final Game ourGame = new Game(new Human(), new StupidComputer());
        ourGame.play();
    }
}
