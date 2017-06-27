package duckCasino.ducks;

import duckCasino.behaviors.FlyBehavior;
import duckCasino.behaviors.QuackBehavior;

public abstract class Duck {
    private final FlyBehavior flyBehavior;
    private final QuackBehavior quackBehavior;

    public Duck(final FlyBehavior flyBehavior,final QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public final double performFly(int time) {
        return flyBehavior.fly(time);
    }

    public final void performQuack() {
        quackBehavior.quack();
    }
}
