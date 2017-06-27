package duckCasino.ducks;

import duckCasino.behaviors.NoFlyingDuckBehaviour;
import duckCasino.behaviors.NoQuackingBehavior;

public final class RubberDuck extends Duck {

    public RubberDuck() {
        super(new NoFlyingDuckBehaviour(), new NoQuackingBehavior());
    }
}
