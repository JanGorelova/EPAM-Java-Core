package duckCasino.ducks;

import java.util.Random;

import static duckCasino.constants.Constants.COMPETITION_TIME;

public final class DuckCompetition {
    private final Duck[] ducks;
    private final Random random = new Random();

    public DuckCompetition(final int duckNumber) {
        this.ducks = new Duck[duckNumber];
        for (int i = 0; i < duckNumber ; i++)
            ducks[i]= getRandomDuck();
    }

    private final Duck getRandomDuck() {
        if (random.nextBoolean())
            return new AmazingDuck();
        else
            return new RubberDuck();
    }

    public final int findWinner() {
        int distance = 0;
        int winnerNumber = 0;
        for (int i = 0; i< ducks.length; i++) {
            final int currentDuckDistance = ducks[i].performFly(COMPETITION_TIME);
            if ( currentDuckDistance > distance) {
                distance = currentDuckDistance;
                winnerNumber = i;
            }
        }
        return winnerNumber;
    }

}

