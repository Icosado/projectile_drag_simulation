package simulations;

import physics.forces.DragForce;
import physics.Environment;
import physics.forces.GravityForce;
import physics.Projectile;

public class Simulation {
    private Environment environment;
    private Projectile projectile;
    private DragForce dragForce;
    private GravityForce gravityForce;

    public Simulation(Environment environment, Projectile projectile) {
        this.environment = environment;
        this.projectile = projectile;
        this.dragForce = new DragForce(environment);
        this.gravityForce = new GravityForce(environment);
    }

    public void tickSimulation() {
        projectile.updatePosition();
        dragForce.tickOnProjectile(projectile);
        gravityForce.tickOnProjectile(projectile);
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public DragForce getDragForce() {
        return dragForce;
    }

    public GravityForce getGravityForce() {
        return gravityForce;
    }
}
