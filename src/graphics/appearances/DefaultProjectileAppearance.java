package graphics.appearances;

import graphics.appearances.Appearance;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class DefaultProjectileAppearance implements Appearance {
    protected BufferedImage appearanceImage;

    public static final int DEFAULT_HEIGHT = 25;
    public static final int DEFAULT_WIDTH = 25;

    public DefaultProjectileAppearance() {
        this.appearanceImage = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2D = appearanceImage.createGraphics();
        g2D.setColor(new Color(128, 128, 128));
        g2D.fill(new Rectangle(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT));
        g2D.dispose();
    }

    public BufferedImage getAppearance() {
        return appearanceImage;
    }

    public String toString() {
        return "Default Appearance";
    }
}