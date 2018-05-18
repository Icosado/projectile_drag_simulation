package physics;

public class DragForce implements Force {
    private Environment environment;

    public DragForce(Environment e) {
        this.environment = e;
    }

    public DragForce() {
        this.environment = Environment.NONE;
    }

    public void onProjectile(Projectile p, Time t) {
        Velocity v = p.velocity();
        DragCoefficient dc = p.dragCoefficient();

        // a = Fnet / m

    }
}
