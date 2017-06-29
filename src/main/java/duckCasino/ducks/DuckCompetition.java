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


}





}
