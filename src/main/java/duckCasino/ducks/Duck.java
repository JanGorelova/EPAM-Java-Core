package duckCasino.ducks;

import duckCasino.behaviors.fly.FlyBehavior;
import duckCasino.behaviors.quack.QuackBehavior;

public abstract class Duck {
    private final FlyBehavior flyBehavior;
    private final QuackBehavior quackBehavior;

    public Duck(final FlyBehavior flyBehavior,final QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public final int performFly(int time) {
        return flyBehavior.fly(time);
    }

    public final void performQuack() {
        quackBehavior.quack();
    }
}
