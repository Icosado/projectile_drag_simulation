package simulations;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import graphics.TimeCounter;
import physics.forces.DragForce;
import physics.Environment;
import physics.forces.GravityForce;
import physics.Projectile;
import physics.quantities.CrossSection;
import physics.quantities.DragCoefficient;
import physics.quantities.Mass;
import physics.quantities.Velocity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Simulation {
    private Environment environment;
    private ArrayList<Projectile> projectiles;
    private DragForce dragForce;
    private GravityForce gravityForce;

    public TimeCounter timeCounter;

    public Simulation() {
        timeCounter = new TimeCounter();
        projectiles = new ArrayList<>();
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.dragForce = new DragForce(environment);
        this.gravityForce = new GravityForce(environment);
    }

    public Simulation(Environment environment, Projectile projectile) {
        this();
        this.environment = environment;
        this.projectiles.add(projectile);
        this.dragForce = new DragForce(environment);
        this.gravityForce = new GravityForce(environment);
    }


    public Simulation(Environment environment, ArrayList<Projectile> projectiles) {
        this(environment);
        for (Projectile p: projectiles) {
            addProjectile(p);
        }
    }

    public Simulation(Environment environment, Projectile... projectiles) {
        this(environment, Projectile.CIRCLE());
        for (Projectile p: projectiles) {
            addProjectile(p);
        }
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    public void tickSimulation() {
        timeCounter.updateTime();
        for (Projectile projectile: projectiles) {
            projectile.updatePosition();
            dragForce.tickOnProjectile(projectile);
            gravityForce.tickOnProjectile(projectile);
        }
    }

    public Projectile getProjectile() {
        return projectiles.get(0);
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

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void clearProjectiles() {
        projectiles.clear();
    }
}
