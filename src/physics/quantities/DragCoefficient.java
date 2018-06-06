package physics.quantities;


import graphics.ui.Viewer;

import java.text.DecimalFormat;

public class DragCoefficient {
    private final double dragCoefficient;

    public DragCoefficient(double dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public double getCoefficient() {
        return this.dragCoefficient;
    }

    public String toString() {
        String s = Viewer.FLOAT_4.format(this.dragCoefficient);
        return s;
    }
}
