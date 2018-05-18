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

        panel.setBackground(new Color(32, 32, 32));
        panel.setSize(WIDTH, HEIGHT);

        frame.getContentPane().add(panel);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();

        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Viewer window = new Viewer("Projectile Motion & Drag!");
    }
}
