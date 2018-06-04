package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Viewer {
    private JFrame frame;
    private CanvasPanel panel;

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 2;

    public Viewer(String title) {
        frame = new JFrame();
        panel = new CanvasPanel();

        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }

    public Viewer() {
        this("Projectile Motion & Drag!");
    }

    public void addPaintable(Paintable paintable) {
        panel.addPaintable(paintable);
    }

    public void addPaintable(Paintable... paintables) {
        panel.addPaintable(paintables);
    }

    public void addPaintable(ArrayList<Paintable> paintables) {
        panel.addPaintable(paintables);
    }

    public void repaint() {
        frame.repaint();
    }
}
