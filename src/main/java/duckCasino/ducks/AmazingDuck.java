package duckCasino.ducks;

import duckCasino.Duck;
import duckCasino.behaviors.*;

public final class AmazingDuck extends Duck {

    public AmazingDuck() {
        super(new FlyingDuckBehaviour(), new QuackingBehavior());

        }
    }

