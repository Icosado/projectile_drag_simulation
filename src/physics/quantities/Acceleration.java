package physics.quantities;

import graphics.ui.Viewer;

public class Acceleration extends Velocity {

    public static Acceleration GRAVITY_SEA = new Acceleration(0, -9.81);
    public static Acceleration GRAVITY_NONE = new Acceleration(0, 0);
    public static Acceleration GRAVITY_MOON = new Acceleration(0, -1.62);

    public Acceleration(double xAcceleration, double yAcceleration) {
        super(xAcceleration, yAcceleration);
    }
    public Acceleration(double speed, Angle angle) {
        super(speed, angle);
    }
    public Acceleration(double speed) {
        this(speed, new Angle());
    }

    public Acceleration() {
        this(0,0);
    }

    public void updateVelocity(Velocity v, Time seconds) {
        v.setxVelocity(
                v.xVelocity + this.xVelocity * seconds.value()
        );

        v.setyVelocity(
                v.yVelocity + this.yVelocity * seconds.value()
        );
    }

    public String toString() {
        return "X: " + Viewer.FLOAT_4.format(xVelocity()) + ". Y: " + Viewer.FLOAT_4.format(yVelocity()) + ".";
    }
}