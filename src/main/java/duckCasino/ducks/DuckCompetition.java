package duckCasino.ducks;

import java.util.Random;

import static duckCasino.Constants.COMPETITION_TIME;
import static duckCasino.Constants.DUCKS_COUNT;

public final class DuckCompetition {
    final Duck[] ducks;
    private final Random random;

    public DuckCompetition(final int duckNumber) {
        this.ducks = new Duck[duckNumber];
        for (int i = 0; i < duckNumber; i++)
            ducks[i]= getRandomDuck();
        this.random =  new Random();
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

