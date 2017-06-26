package duckCasino.behaviors;

import duckCasino.Duck;
import duckCasino.behaviors.FlyBehavior;

public final class FlyingDuckBehaviour implements FlyBehavior {
    int maximalVelocity = 100;

    @Override
    public double fly(int time) {
        double distance = 0.0;
        for (int i = 0; i < time; i++)
            distance += getCurrentVelocity();

        return distance;
    }

    private double getCurrentVelocity() {
        return 10 + Math.random() * (maximalVelocity - 10);
    }
}
