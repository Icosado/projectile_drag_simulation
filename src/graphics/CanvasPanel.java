package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private ArrayList<Paintable> graphicsItems;
    public CanvasPanel() {
        super();
        this.setPreferredSize(new Dimension(Viewer.WIDTH, Viewer.HEIGHT));
        this.setBackground(new Color(32, 32, 32));
        graphicsItems = new ArrayList<>();
        graphicsItems.add(new Scale(Scale.ORIGIN, Scale.GLOBAL_SCALE));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Paintable p: graphicsItems) {
            p.paintOnto(g);
        }
    }
    public void addPaintable(Paintable component) {
        graphicsItems.add(component);
    }

    public void addPaintable(ArrayList<Paintable> components) {
        for (Paintable p: components) {
            addPaintable(p);
        }
    }

    public void addPaintable(Paintable... components) {
        for (Paintable p: components) {
            addPaintable(p);
        }
    }
}
