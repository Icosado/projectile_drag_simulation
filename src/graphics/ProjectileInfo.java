package graphics;

import graphics.ui.Viewer;
import physics.Projectile;

import java.awt.*;

public class ProjectileInfo implements Paintable {
    private Projectile projectile;

    public static final int X_LEFT = Viewer.HEIGHT - Viewer.HALF_FONT.getSize() * 70;
    public static int Y_COUNT = Viewer.HALF_FONT.getSize() * 2;

    private int y;

    public ProjectileInfo(Projectile projectile) {
        this.projectile = projectile;
        this.y = Y_COUNT;
        Y_COUNT += Viewer.HALF_FONT.getSize() * 2;
    }

    @Override
    public void paintOnto(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(Viewer.HALF_FONT);
        g.drawString(line1(), X_LEFT, y);
        g.drawString(line2(), X_LEFT, y + Viewer.HALF_FONT.getSize());
    }

//    public String projectileInformation() {
//        String line1 =
//                "position: " + projectile.position() +
//                " velocity: " + projectile.velocity() +
//                " mass: " + projectile.mass();
//        String line2 =
//                " drag coefficient: " + projectile.dragCoefficient() +
//                " cross section: " + projectile.crossSection() +
//                " " + projectile.maxHeightInformation() +
//                " " + projectile.xInterceptInformation();
//        return line1 + "\n" + line2;
//    }

    public String line1() {
        return  projectile + ": " +
                "position: " + projectile.position() +
                " velocity: " + projectile.velocity() +
                " mass: " + projectile.mass() +
                " drag coefficient: " + projectile.dragCoefficient();
    }
    public String line2() {
        return  pad() +
                "cross section: " + projectile.crossSection() +
                " " + projectile.maxHeightInformation() +
                " " + projectile.xInterceptInformation();
    }
    public String pad() {
        String s = "  "; // a space for a colon plus a space
        for (int i = 0; i < projectile.toString().length(); ++i) {
            s += " "; // pad out for each letter of the name
        }
        return s;
    }
}
