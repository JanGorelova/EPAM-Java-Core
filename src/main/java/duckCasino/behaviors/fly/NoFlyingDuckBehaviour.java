package duckCasino.behaviors.fly;

public final class NoFlyingDuckBehaviour implements FlyBehavior {
    @Override
    public double fly(int time) {
        return 0;
    }
}
