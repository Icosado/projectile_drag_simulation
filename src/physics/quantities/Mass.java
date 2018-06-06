package physics.quantities;

import graphics.ui.Viewer;

public class Mass {
    private final double mass;

    public Mass(double mass) {
        this.mass = mass;
    }

    public double mass() {
        return mass;
    }

    public String toString() {
        return Viewer.FLOAT_4.format(mass) + " kg";
    }
}
