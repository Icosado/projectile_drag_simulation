package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Viewer {
    private JFrame frame;
    private JPanel panel;

    public static final int WIDTH = 1080;
    public static final int HEIGHT = 1920;

    public Viewer(String title) {
        frame = new JFrame();
        panel = new JPanel();

        frame.getContentPane().setBackground(new Color(32, 32, 32));
        panel.setBackground(new Color(32, 32, 32));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Viewer window = new Viewer("Projectile Motion & Drag!");
    }
}
