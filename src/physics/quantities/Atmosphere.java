package physics.quantities;

public class Atmosphere {
    /**
     * In kg/m^3.
     */
    private final double airDensity;
    public static Atmosphere EARTH_SEA = new Atmosphere(1.225);
    public static Atmosphere EARTH_EVEREST = new Atmosphere(0.42875);
    public static Atmosphere VACUUM = new Atmosphere(0.0);

    public Atmosphere(double airDensity) {
        this.airDensity = airDensity;
    }

    public double density() {
        return airDensity;
    }
}
