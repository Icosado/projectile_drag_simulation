package graphics.ui;

import javax.swing.*;
import java.awt.*;

public class Viewer {
    protected JFrame frame;

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 100;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 100;

    public static final Font FONT = new Font("Monospaced", Font.PLAIN, HEIGHT / 40);

    public Viewer(String title) {
        frame = new JFrame();

        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.getContentPane().setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }

    public Viewer() {
        this("Viewer");
    }

    public void repaint() {
        frame.repaint();
    }
}
