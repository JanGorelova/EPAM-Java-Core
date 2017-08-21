package duckcasino;

import duckcasino.ducks.AmazingDuck;
import duckcasino.ducks.Duck;
import duckcasino.ducks.RubberDuck;

import java.util.Random;

import static duckcasino.constants.Constants.COMPETITION_TIME;

public final class DuckCompetition {
    private final Duck[] ducks;
    private final Random random = new Random();

    /**
     * creates new competition with specified duck number
     *
     * @param duckNumber take part in competition
     */
    public DuckCompetition(final int duckNumber) {
        this.ducks = new Duck[duckNumber];
        for (int i = 0; i < duckNumber; i++)
            ducks[i] = getRandomDuck();
    }

    /**
     * creates on of two duck types
     *
     * @return random Duck
     */
    private Duck getRandomDuck() {
        if (random.nextBoolean())
            return new AmazingDuck();
        else
            return new RubberDuck();
    }

    /**
     * find winner in competition
     *
     * @return number of the winner
     */
    public final int findWinner() {
        int distance = 0;
        int winnerNumber = 0;
        for (int i = 0; i < ducks.length; i++) {
            final int currentDuckDistance = ducks[i].performFly(COMPETITION_TIME);
            if (currentDuckDistance > distance) {
                distance = currentDuckDistance;
                winnerNumber = i;
            }
        }
        return winnerNumber;
    }

}

