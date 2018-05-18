package physics;

/**
 * Components.
 */
public class Velocity {
    protected double xVelocity;
    protected double yVelocity;

    public Velocity(double xVelocity, double yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public Velocity(double speed, Angle angle) {
        this(speed * Math.cos(angle.radians()), speed * Math.sin(angle.radians()));
    }

    public Velocity() {
        this(0, 0);
    }

    public double xVelocity() {
        return xVelocity;
    }

    public double yVelocity() {
        return yVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
}