package duckCasino.ducks;

import duckCasino.behaviors.fly.NoFlyingDuckBehaviour;
import duckCasino.behaviors.quack.NoQuackingBehavior;

public final class RubberDuck extends Duck {

    public RubberDuck() {
        super(new NoFlyingDuckBehaviour(), new NoQuackingBehavior());
    }
}
