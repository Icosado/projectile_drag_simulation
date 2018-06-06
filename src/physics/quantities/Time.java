package physics.quantities;

import graphics.ui.Viewer;

public class Time {
    private double seconds;

    public Time(double seconds) {
        this.seconds = seconds;
    }

    public Time() {
        this(0);
    }

    public double value() {
        return seconds;
    }

    public String toString() {
        return Viewer.FLOAT_4.format(seconds) + " s";
    }
}
