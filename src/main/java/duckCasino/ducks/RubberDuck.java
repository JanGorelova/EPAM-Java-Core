package duckCasino.ducks;

import duckCasino.Duck;
import duckCasino.behaviors.FlyBehavior;
import duckCasino.behaviors.NoFlyingDuckBehaviour;
import duckCasino.behaviors.QuackBehavior;

public final class RubberDuck extends Duck {

    public RubberDuck(NoFlyingDuckBehaviour flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior,quackBehavior);
    }
}
