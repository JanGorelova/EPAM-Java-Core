package duckCasino.ducks;

import duckCasino.behaviors.fly.FlyingDuckBehaviour;
import duckCasino.behaviors.quack.QuackingBehavior;

public final class AmazingDuck extends Duck {

    public AmazingDuck() {
        super(new FlyingDuckBehaviour(), new QuackingBehavior());

        }
}

