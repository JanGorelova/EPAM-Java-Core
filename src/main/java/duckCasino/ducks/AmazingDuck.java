package duckCasino.ducks;

import duckCasino.Duck;
import duckCasino.behaviors.FlyBehavior;
import duckCasino.behaviors.FlyingDuckBehaviour;
import duckCasino.behaviors.QuackBehavior;

public final class AmazingDuck extends Duck {

    public AmazingDuck() {
        super(new FlyingDuckBehaviour(), new QuackBehavior() {
            @Override
            public void quack() {
            }
        });
    }
}
