package physics;


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
        String s = "Drag Coefficient: ";
        DecimalFormat df = new DecimalFormat(".####");
        s += df.format(this.dragCoefficient);
        return s;
    }
}
