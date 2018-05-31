package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Viewer {
    private JFrame frame;

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final Font FONT = new Font("Monospaced", Font.PLAIN, HEIGHT / 32);

    public Viewer(String title) {
        frame = new JFrame();

        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }

    public Viewer() {

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

    public void repaint(int x, int y, int width, int height) {
        frame.repaint(x, y, width, height);
    }
}
