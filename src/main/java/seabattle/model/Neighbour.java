package seabattle.model;

public enum Neighbour implements Directional {
    Up(0, -1),
    Down(0, 1),
    Left(-1, 0),
    Right(1, 0),
    UpLeft(-1, -1),
    UpRight(1, -1),
    DownLeft(-1, 1),
    DownRight(1, 1);

    private final int dx;
    private final int dy;

    /**
     * creates new neighbour of the cell
     *
     * @param dx x - bias
     * @param dy y - bias
     */
    Neighbour(final int dx, final int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public final int getDx() {
        return dx;
    }

    @Override
    public final int getDy() {
        return dy;
    }
}
