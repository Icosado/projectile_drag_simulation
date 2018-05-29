package physics;

import physics.quantities.CrossSection;
import physics.quantities.DragCoefficient;
import physics.quantities.Mass;
import physics.quantities.Velocity;

public class Projectile {
    private Mass mass;
    private Velocity velocity;
    private DragCoefficient dragCoefficient;
    private CrossSection area;

    public static Projectile CIRCLE = new Projectile(new Mass(5.0), new Velocity(30.0, 30.0), new DragCoefficient(0.47), new CrossSection(1.0));
    public static Projectile SQUARE = new Projectile(new Mass(1.0), new Velocity(30.0, 30.0), new DragCoefficient(1.05), new CrossSection(1.0));
    public static Projectile COFFEE_FILTER = new Projectile(new Mass(0.01), new Velocity(40.0, 50.0), new DragCoefficient(1.60), new CrossSection(0.01));


    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area) {
        this.mass = mass;
        this.velocity = velocity;
        this.dragCoefficient = dragCoefficient;
    }

    public Velocity velocity() {
        return velocity;
    }

    public Mass mass() {
        return mass;
    }

    public DragCoefficient dragCoefficient() {
        return dragCoefficient;
    }

    public CrossSection crossSection() {
        return area;
    }
}
