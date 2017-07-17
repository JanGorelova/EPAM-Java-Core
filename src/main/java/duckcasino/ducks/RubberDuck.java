package duckcasino.ducks;

import duckcasino.behaviors.fly.NoFlyingDuckBehaviour;
import duckcasino.behaviors.quack.NoQuackingBehavior;

public final class RubberDuck extends Duck {

    public RubberDuck() {
        super(new NoFlyingDuckBehaviour(), new NoQuackingBehavior());
    }
}
