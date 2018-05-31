package physics;

import graphics.Paintable;
import graphics.appearances.Appearance;
import graphics.appearances.DefaultProjectileAppearance;
import physics.quantities.*;
import simulations.Simulator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile implements Paintable {
    private Mass mass;
    private Velocity velocity;
    private DragCoefficient dragCoefficient;
    private CrossSection area;
    private Coordinate position;
    private Appearance appearance;

    public static Projectile CIRCLE = new Projectile(new Mass(5.0), new Velocity(30.0, 100.0), new DragCoefficient(0.47), new CrossSection(1.0));
    public static Projectile SQUARE = new Projectile(new Mass(1.0), new Velocity(30.0, 300.0), new DragCoefficient(1.05), new CrossSection(1.0));
    public static Projectile COFFEE_FILTER = new Projectile(new Mass(0.01), new Velocity(40.0, 500.0), new DragCoefficient(1.60), new CrossSection(0.01));

    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area) {
        this.mass = mass;
        this.velocity = velocity;
        this.dragCoefficient = dragCoefficient;
        this.area = area;
        this.position = new Coordinate();
        this.appearance = new DefaultProjectileAppearance();
    }

    public void setAppearance(Appearance a) {
        this.appearance = a;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void updatePosition() {
//        System.out.println(this.velocity());
        this.velocity().updatePosition(this.position, Simulator.timePerTick());
    }

    public Velocity velocity() {
        return velocity;
    }

    public Mass mass() {
        return mass;
    }

    public DragCoefficient dragCoefficient() {
        return dragCoefficient;
    }

    public CrossSection crossSection() {
        return area;
    }

    public void paintOnto(Graphics g) {
        BufferedImage buffered = appearance.getAppearance();
        Coordinate drawPosition = position.paintingCoordinate();
//        System.out.println("painting: " + buffered);
        g.drawImage(buffered, (int) drawPosition.x(), (int) drawPosition.y(), null);

//        g.drawImage(buffered, 500, 500, null);

//        System.out.println("X: " + (int) (drawPosition.x()) + ". Y: " + (int) (drawPosition.y()));
    }
}
