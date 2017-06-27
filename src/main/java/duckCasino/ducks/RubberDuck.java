package duckCasino.ducks;

import duckCasino.Duck;
import duckCasino.behaviors.FlyBehavior;
import duckCasino.behaviors.NoFlyingDuckBehaviour;
import duckCasino.behaviors.NoQuackingBehavior;
import duckCasino.behaviors.QuackBehavior;

public final class RubberDuck extends Duck {

    public RubberDuck() {
        super(new NoFlyingDuckBehaviour(), new NoQuackingBehavior());
    }
}
