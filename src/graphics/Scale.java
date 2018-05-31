package graphics;

import physics.quantities.Coordinate;

import java.awt.*;

public class Scale implements Paintable {
    public static final int THICKNESS = 1;
    public static final double GLOBAL_SCALE = 40;
    public static final Coordinate ORIGIN = new Coordinate(150, Viewer.HEIGHT - 150);

    private Coordinate origin;
    private double scale;
    public Scale(Coordinate origin, double scale) {
        this.origin = origin;
        this.scale = scale;
    }

    public void paintOnto(Graphics g) {
        int x = (int) origin.x();
        int y = (int) origin.y();

        g.setColor(new Color(255, 255, 255));
        g.setFont(Viewer.FONT);

        g.fillRect(x, 0, THICKNESS, Viewer.HEIGHT);
        g.fillRect(0, y, Viewer.WIDTH, THICKNESS);

        for (int i = 10; i < Viewer.WIDTH; i += 10) {
            int displacement = (int) (i * scale);
            g.fillRect((int) (origin.x() - scale), (int) (origin.y() - displacement), (int) (2 * scale + THICKNESS), THICKNESS);
            g.drawString(Integer.toString(i) + "m", (int) (origin.x() - 60), (int) (origin.y() - displacement));
            g.fillRect((int) (origin.x() + displacement), (int) (origin.y() - scale), THICKNESS, (int) (2 * scale + THICKNESS));
            g.drawString(Integer.toString(i) + "m", (int) (origin.x() + displacement ), (int) (origin.y() + 36));
        }
    }
}
