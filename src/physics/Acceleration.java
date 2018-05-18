package physics;

public class Acceleration extends Velocity {

    public Acceleration(double xAcceleration, double yAcceleration) {
        super(xAcceleration, yAcceleration);
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
}
