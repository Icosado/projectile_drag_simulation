package graphics;

import graphics.ui.Viewer;
import physics.quantities.Coordinate;

import java.awt.*;

public class Scale implements Paintable {
    public static final int THICKNESS = 1;

    public static final Coordinate ORIGIN = new Coordinate(150, Viewer.HEIGHT - 150);
    public static int INCREMENT = 15;
//    public static double GLOBAL_SCALE = INCREMENT * Viewer.HEIGHT / 1000;
    public static double SCALE = 15;
    public static double TICK_LENGTH = Viewer.HEIGHT / 150;

    private Coordinate origin;
//    private double scale;

    public Scale(Coordinate origin, double scale) {
        this.origin = origin;
//        this.scale = scale;
    }

    @Override
    public void paintOnto(Graphics g) {
        int x = (int) origin.x();
        int y = (int) origin.y();

        g.setColor(new Color(255, 255, 255));
        g.setFont(Viewer.FONT);

        g.fillRect(x, 0, THICKNESS, Viewer.HEIGHT);
        g.fillRect(0, y, Viewer.WIDTH, THICKNESS);

        for (int i = INCREMENT; i < Viewer.WIDTH; i += INCREMENT) {
            int displacement = (int) (i * SCALE);
            g.fillRect((int) (origin.x() - TICK_LENGTH), (int) (origin.y() - displacement), (int) (2 * TICK_LENGTH + THICKNESS), THICKNESS);
            g.drawString(Integer.toString(i) + "m", (int) (origin.x() - 75), (int) (origin.y() - displacement));
            g.fillRect((int) (origin.x() + displacement), (int) (origin.y() - TICK_LENGTH), THICKNESS, (int) (2 * TICK_LENGTH + THICKNESS));
            g.drawString(Integer.toString(i) + "m", (int) (origin.x() + displacement ), (int) (origin.y() + 36));
        }
    }

    public static double GLOBAL_SCALE() {
        return SCALE;
    }

    @Override
    public String toString() {
        return "Scale of scale " + SCALE + " and origin at " + origin;
    }
}
