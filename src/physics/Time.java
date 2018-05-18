package physics;

public class Time {
    private double seconds;

    public Time(double seconds) {
        this.seconds = seconds;
    }

    public Time() {
        this(0);
    }

    public double value() {
        return seconds;
    }
}
