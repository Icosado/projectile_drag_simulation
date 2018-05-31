package physics.forces;

import physics.Environment;
import physics.Projectile;
import physics.forces.Force;
import physics.quantities.Acceleration;
import physics.quantities.Time;
import simulations.Simulator;

public class GravityForce implements Force {
    private Environment environment;
    public GravityForce(Environment environment) {
        this.environment = environment;
    }

    public void onProjectile(Projectile projectile, Time t) {
        Acceleration g = environment.acceleration();

        g.updateVelocity(projectile.velocity(), t);
    }

    public void tickOnProjectile(Projectile projectile) {
        Time t = Simulator.timePerTick();
        onProjectile(projectile, t);
    }
}
