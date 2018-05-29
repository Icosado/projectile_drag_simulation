package physics;

import physics.Projectile;
import physics.quantities.Time;

public interface Force {
    public void onProjectile(Projectile projectile, Time t);
}
