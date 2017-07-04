package seeBattle.players;

import seeBattle.model.Coordinates;
import seeBattle.model.Field;

public interface Player {
    Coordinates getCoordinates();
    Field createField();
}
