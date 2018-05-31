package physics.forces;

import physics.Environment;
import physics.Projectile;
import physics.quantities.*;
import simulations.Simulator;

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

        if (sameSign(xAcceleration, velocity.xVelocity())) {
            xAcceleration = -xAcceleration;
        }

//        System.out.println("Drag X Acceleration: " + xAcceleration);

        double yAcceleration =
                combinedCoefficient *
                velocity.yVelocity() * velocity.yVelocity();

        if (sameSign(yAcceleration, velocity.yVelocity())) {
            yAcceleration = -yAcceleration;
        }

//        System.out.println("Drag Y Acceleration: " + yAcceleration);

        Acceleration acceleration = new Acceleration(
                xAcceleration / projectile.mass().mass(),
                yAcceleration / projectile.mass().mass()
        );

        acceleration.updateVelocity(projectile.velocity(), t);
    }

    public void tickOnProjectile(Projectile projectile) {
        Time t = Simulator.timePerTick();
        onProjectile(projectile, t);
    }

    private boolean sameSign(double a, double b) {
        return (a > 0 == b > 0);
        // p u r e    z e n
    }
}
