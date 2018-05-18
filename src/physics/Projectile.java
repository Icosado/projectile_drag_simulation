package physics;

public class Projectile {
    private Mass mass;
    private Velocity velocity;
    private DragCoefficient dragCoefficient;

    public static Projectile CIRCLE = new Projectile(new Mass(1.0), new Velocity(30.0, 30.0), new DragCoefficient(0.47));
    public static Projectile SQUARE = new Projectile(new Mass(1.0), new Velocity(30.0, 30.0), new DragCoefficient(1.05));
    public static Projectile COFFEE_FILTER = new Projectile(new Mass(0.01), new Velocity(40.0, 50.0), new DragCoefficient(1.60));


    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient) {
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
}
