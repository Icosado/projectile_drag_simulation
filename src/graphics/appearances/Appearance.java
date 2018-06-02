package graphics.appearances;

import java.awt.image.BufferedImage;

public interface Appearance {
    public static final Appearance[] ALL_APPEARANCES = {new DefaultProjectileAppearance()};
    public BufferedImage getAppearance();
    public String toString();
}
