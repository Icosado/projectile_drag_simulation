package physics;

public class Environment {
    private Acceleration acceleration;
    private Atmosphere atmosphere;

    public static Environment EARTH_SEA = new Environment(Acceleration.GRAVITY_SEA, Atmosphere.EARTH_SEA);
    public static Environment NONE = new Environment(Acceleration.GRAVITY_NONE, Atmosphere.VACUUM);

    public Environment(Acceleration acceleration, Atmosphere atmosphere) {
        this.acceleration = acceleration;
        this.atmosphere = atmosphere;
    }

    public Environment() {
        this.acceleration = Acceleration.GRAVITY_SEA;
        this.atmosphere = Atmosphere.EARTH_SEA;
    }
}
