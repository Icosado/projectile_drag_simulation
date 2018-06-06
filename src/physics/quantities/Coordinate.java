package physics.quantities;

import graphics.Scale;
import graphics.ui.Viewer;

public class Coordinate {
    private double x;
    private double y;

    public double x() {
        return x;
    }
    public double y() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
        this(0, 0);
    }

    public Coordinate paintingCoordinate() {
        Coordinate newCoordinate = new Coordinate(x * Scale.GLOBAL_SCALE() + Scale.ORIGIN.x(), -y * Scale.GLOBAL_SCALE() + Scale.ORIGIN.y());
        return newCoordinate;
    }

    public String toString() {
        return "(" + Viewer.FLOAT_4.format(x()) + ", " + Viewer.FLOAT_4.format(y()) + ")";
    }
}
