package graphics.appearances;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class SquareAppearance extends DefaultProjectileAppearance {

    public SquareAppearance() {
        appearanceImage = new BufferedImage(APPEARANCE_WIDTH, APPEARANCE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = appearanceImage.createGraphics();
        g2d.setColor(new Color(255, 255, 255));
        g2d.fill(new Rectangle2D.Double(0, 0, appearanceImage.getWidth(), appearanceImage.getHeight()));
        g2d.dispose();
    }

    @Override
    public BufferedImage getAppearance() {
        return super.getAppearance();
    }

    @Override
    public String toString() {
        return "Square";
    }
}
