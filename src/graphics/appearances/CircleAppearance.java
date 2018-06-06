package graphics.appearances;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CircleAppearance extends DefaultProjectileAppearance {
    public CircleAppearance() {
        this.appearanceImage = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2D = appearanceImage.createGraphics();
        g2D.setColor(new Color(255, 255, 255));
        g2D.fill(new Ellipse2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT));
        g2D.dispose();
    }

    @Override
    public BufferedImage getAppearance() {
        return appearanceImage;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
