package graphics.appearances;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DefaultProjectileAppearance implements Appearance {
    protected BufferedImage appearanceImage;

    public static final int APPEARANCE_HEIGHT = 20;
    public static final int APPEARANCE_WIDTH = 20;

    public DefaultProjectileAppearance() {
        this.appearanceImage = new BufferedImage(APPEARANCE_WIDTH, APPEARANCE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2D = appearanceImage.createGraphics();
        g2D.setColor(new Color(128, 128, 128));
        g2D.fill(new Rectangle(0, 0, appearanceImage.getWidth(), appearanceImage.getHeight()));
        g2D.dispose();
    }

    public BufferedImage getAppearance() {
        return appearanceImage;
    }

    public String toString() {
        return "Default Appearance";
    }
}