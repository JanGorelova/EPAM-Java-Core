package duckCasino.behaviors;

public final class NoFlyingDuckBehaviour implements FlyBehavior {
    @Override
    public double fly(int time) {
        return 0;
    }
}
