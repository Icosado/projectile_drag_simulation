package physics.quantities;

import graphics.ui.Viewer;

/**
 * Area is in m^2.
 */
public class CrossSection {
    private double area;

    public CrossSection(double area) {
        this.area = area;
    }

    public CrossSection() {
        this(0);
    }

    public double area() {
        return area;
    }

    public String toString() {
        return Viewer.FLOAT_4.format(area) + " m";
    }
}
