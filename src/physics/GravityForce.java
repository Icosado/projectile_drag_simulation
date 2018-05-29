package physics;

import physics.quantities.Acceleration;
import physics.quantities.Time;

public class GravityForce implements Force{
    private Environment environment;
    public GravityForce(Environment environment) {
        this.environment = environment;
    }

    public void onProjectile(Projectile projectile, Time t) {
        Acceleration g = environment.acceleration();

        g.updateVelocity(projectile.velocity(), t);
    }
}
