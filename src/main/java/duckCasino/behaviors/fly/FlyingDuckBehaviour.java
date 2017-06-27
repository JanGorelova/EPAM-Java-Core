package duckCasino.behaviors.fly;

public final class FlyingDuckBehaviour implements FlyBehavior {
    private static final int MAXIMAL_VELOCITY = 100;

    @Override
    public double fly(int time) {
        double distance = 0.0;
        for (int i = 0; i < time; i++)
            distance += getCurrentVelocity();

        return distance;
    }

    private double getCurrentVelocity() {
        return 10 + Math.random() * (MAXIMAL_VELOCITY - 10);
    }
}
