package duckcasino.behaviors.fly;

public final class NoFlyingDuckBehaviour implements FlyBehavior {
    @Override
    public int fly(int time) {
        return 0;
    }
}
