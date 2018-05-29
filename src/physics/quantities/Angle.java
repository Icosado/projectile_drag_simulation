package physics.quantities;

/**
 * In degrees, because we can always convert to radians later.
 */
public class Angle {
    private double degrees;

    public static final int MODE_DEGREES = 0;
    public static final int MODE_RADIANS = 1;
    public static final int MODE_GRADIANS = 2;
    public static final int MODE_REVOLUTIONS = 3;

    public Angle(double angle, int mode) {
        setAngle(angle, mode);
    }

    public Angle(double degrees) {
        setAngle(degrees, MODE_DEGREES);
    }

    public Angle() {
        this(0);
    }

    public void setAngle(double angle, int mode) {
        switch (mode) {
            case MODE_DEGREES:
                this.degrees = angle;
                break;
            case MODE_RADIANS:
                this.degrees = 180 * angle / Math.PI;
                break;
            case MODE_GRADIANS:
                this.degrees = 360 * angle / 400;
                break;
            case MODE_REVOLUTIONS:
                this.degrees = 360 * angle;
                break;
            default:
                this.degrees = angle;
                break;
        }
    }

    public void setAngle(double angle) {
        setAngle(angle, MODE_DEGREES);
    }

    /**
     * The standard.
     * @return Angle in degrees; 360 to a revolution.
     */
    public double degrees() {
        return degrees;
    }

    /**
     * For the theory nerd in all of us.
     * @return Angle in radians; 2PI to a revolution.
     */
    public double radians() {
        return Math.PI * degrees() / 180;
    }

    /**
     * Because I'm a madman.
     * @return Angle in gradians; 400 to a revolution.
     */
    public double gradians() {
        return 400 * degrees() / 360;
    }

    /**
     * I don't know; this might be useful some time.
     * @return Angle in revolutiosn; 1 to a revolution (duh.)
     */
    public double revolutions() {
        return degrees() / 360;
    }
}
