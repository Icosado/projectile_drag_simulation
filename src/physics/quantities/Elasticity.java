package physics.quantities;

public class Elasticity {
    public static final Elasticity PERFECTLY_ELASTIC = new Elasticity(1.0);
    public static final Elasticity PERFECTLY_INELASTIC = new Elasticity(0.0);
    public static final Elasticity PARTIALLY_ELASTIC = new Elasticity(0.5);

    private double proportionOfEnergyConserved;
    public Elasticity(double elasticity) {
        this.proportionOfEnergyConserved = elasticity;
    }

    public Elasticity() {
        this(1.0);
    }

    public double elasticity() {
        return proportionOfEnergyConserved;
    }
}
