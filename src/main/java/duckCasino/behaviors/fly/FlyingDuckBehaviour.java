package duckCasino.behaviors.fly;

import java.util.Random;

public final class FlyingDuckBehaviour implements FlyBehavior {
    private static final int MAXIMAL_VELOCITY = 100;

    @Override
    public int fly(int time) {
        int distance = 0;
        for (int i = 0; i < time; i++)
            distance += getCurrentVelocity();

        return distance;
    }

    private double getCurrentVelocity() {
        Random random = new Random();
        return 10 + random.nextInt(100) * (MAXIMAL_VELOCITY - 10) << 1;    }
}
