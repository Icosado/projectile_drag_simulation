package physics;

import physics.quantities.*;

public class DragForce implements Force {
    private Environment environment;

    public DragForce(Environment e) {
        this.environment = e;
    }

    public DragForce() {
        this.environment = Environment.NONE;
    }

    public void onProjectile(Projectile projectile, Time t) {
        Velocity velocity = projectile.velocity();
        DragCoefficient drag = projectile.dragCoefficient();
        Atmosphere atmosphere = environment.atmosphere();
        CrossSection area = projectile.crossSection();

        // a = Fnet / m
        // Fd = 0.5 p v^2 Cd A
        //    where p is density,
        //    v is velocity relative to fluid,
        //    Cd is the drag coefficient,
        //    and A is the cross-sectional area.

        double combinedCoefficient = 0.5 * atmosphere.density() * drag.getCoefficient() * area.area();

        double xAcceleration =
                combinedCoefficient *
                velocity.xVelocity() * velocity.xVelocity();

        double yAcceleration =
                combinedCoefficient *
                velocity.yVelocity() * velocity.yVelocity();

        Acceleration acceleration = new Acceleration(
                xAcceleration / projectile.mass().mass(),
                yAcceleration / projectile.mass().mass()
        );

        acceleration.updateVelocity(projectile.velocity(), t);
    }
}
