package duckcasino.ducks;

import duckcasino.behaviors.fly.FlyingDuckBehaviour;
import duckcasino.behaviors.quack.QuackingBehavior;

public final class AmazingDuck extends Duck {

    public AmazingDuck() {
        super(new FlyingDuckBehaviour(), new QuackingBehavior());

        }
}

