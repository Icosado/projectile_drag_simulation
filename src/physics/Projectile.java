package physics;

import graphics.Paintable;
import graphics.Scale;
import graphics.appearances.Appearance;
import graphics.appearances.CircleAppearance;
import graphics.appearances.DefaultProjectileAppearance;
import graphics.appearances.SquareAppearance;
import physics.quantities.*;
import simulations.Simulator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile implements Paintable {
    private Mass mass;
    private Velocity velocity;
    private Velocity initialVelocity; // not to be modified
    private DragCoefficient dragCoefficient;
    private CrossSection area;
    private Coordinate position;
    private Coordinate initialPosition; // not to be modified
    private Appearance appearance;
    private String name;

    private Coordinate maxHeight;
    private Coordinate xIntercept;


//    public static Projectile CIRCLE = new Projectile(
//            new Mass(5.0),
//            new Velocity(30.0, 100.0),
//            new DragCoefficient(0.47),
//            new CrossSection(1.0),
//            "Circle"
//    );
//    public static Projectile SQUARE = new Projectile(
//            new Mass(1.0),
//            new Velocity(30.0, 300.0),
//            new DragCoefficient(1.05),
//            new CrossSection(1.0),
//            "Square"
//    );
//    public static Projectile COFFEE_FILTER = new Projectile(
//            new Mass(0.01),
//            new Velocity(40.0, 500.0),
//            new DragCoefficient(1.60),
//            new CrossSection(0.01),
//            "Coffee Filter"
//    );

    public static Projectile[] ALL_DEFAULT_PROJECTILES = {CIRCLE(), SQUARE(), COFFEE_FILTER()};

    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area, Appearance appearance, String name, Coordinate initialPosition) {
        this.mass = mass;
        this.velocity = velocity;
        this.dragCoefficient = dragCoefficient;
        this.area = area;
        this.position = initialPosition;
        this.appearance = appearance;
        this.name = name;

        this.maxHeight = new Coordinate(position.x(), position.y());
        this.initialPosition = initialPosition;
        this.initialVelocity = velocity;
    }

    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area, Appearance appearance, String name) {
        this(mass, velocity, dragCoefficient, area, appearance, name, new Coordinate());
    }
    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area, Appearance appearance) {
        this(mass, velocity, dragCoefficient, area, appearance, "default");
    }
    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area, String name) {
        this(mass, velocity, dragCoefficient, area, new DefaultProjectileAppearance(), name);
    }
    public Projectile(Mass mass, Velocity velocity, DragCoefficient dragCoefficient, CrossSection area) {
        this(mass, velocity, dragCoefficient, area, new DefaultProjectileAppearance());
    }

    public void setAppearance(Appearance a) {
        this.appearance = a;
    }
    public void setPosition(Coordinate position) {
        this.position = position;
    }
    public void updatePosition() {
        this.velocity().updatePosition(this.position, Simulator.timePerTick());
        newMaxHeight();
        xIntercept();
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
    public Coordinate position() {
        return position;
    }

    public void paintOnto(Graphics g) {
        BufferedImage buffered = appearance.getAppearance();
        Coordinate drawPosition = position.paintingCoordinate();
        g.drawImage(buffered,
                (int) drawPosition.x() - buffered.getWidth() / 2, (int) drawPosition.y() - buffered.getHeight() / 2, // image position
//                (int) (buffered.getWidth() * Scale.GLOBAL_SCALE()), (int) (buffered.getHeight() * Scale.GLOBAL_SCALE()), // image scaling
                null
        );
//        System.out.println("X: " + (int) (drawPosition.x()) + ". Y: " + (int) (drawPosition.y()));
    }

    public Projectile copy() {
        return new Projectile(
                new Mass(this.mass.mass()),
                new Velocity(this.initialVelocity.xVelocity(), this.initialVelocity.yVelocity()),
                new DragCoefficient(this.dragCoefficient.getCoefficient()),
                new CrossSection(this.area.area()),
                this.appearance, this.name,
                new Coordinate(this.initialPosition.x(), this.initialPosition.y()));
    }

    public String toString() {
        return name;
    }

    private boolean newMaxHeight() {
        if (position.y() > maxHeight.y()) {
            maxHeight.setX(position.x());
            maxHeight.setY(position.y());
            return true;
        }
        return false;
    }
    private boolean xIntercept() {
        if (position.y() < 0) {
            if (xIntercept == null) {
                xIntercept = new Coordinate(position.x(), position.y());
                return true;
            }
        }
        return false;
    }

    public Coordinate getMaxHeight() {
        return maxHeight;
    }
    public Coordinate getxIntercept() {
        return xIntercept;
    }
    public String maxHeightInformation() {
        String s = "max height at: " + getMaxHeight();
        return s;
    }
    public String xInterceptInformation() {
        if (getxIntercept() == null) {
            return "Haven't reached X intercept yet.";
        } else {
            return "X-Intercept closest to " + getxIntercept();
        }
    }

    public static Projectile CIRCLE() {
        return new Projectile(
                new Mass(5.0),
                new Velocity(30.0, 100.0),
                new DragCoefficient(0.47),
                new CrossSection(1.0),
                new CircleAppearance(),
                "Circle"
        );
    }
    public static Projectile SQUARE() {
        return new Projectile(
                new Mass(10.0),
                new Velocity(30.0, 100.0),
                new DragCoefficient(1.05),
                new CrossSection(1.0),
                new SquareAppearance(),
                "Square"
        );
    }
    public static Projectile COFFEE_FILTER() {
        return new Projectile(
                new Mass(0.01),
                new Velocity(0.5, 0.5),
                new DragCoefficient(1.60),
                new CrossSection(0.01),
                new DefaultProjectileAppearance(),
                "Coffee Filter"
        );
    }
}