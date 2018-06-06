package graphics.ui;

import graphics.Paintable;

import java.awt.*;
import java.util.ArrayList;

public class SimulationWindow extends Viewer{
    private CanvasPanel panel;

    public SimulationWindow(String title) {
        super(title);
        panel = new CanvasPanel();
        frame.getContentPane().add(panel);
        frame.pack();
    }

    public SimulationWindow() {
        this("Projectile Motion & Drag!");
    }

    public void addPaintable(Paintable paintable) {
        panel.addPaintable(paintable);
        repaint();
    }

    public void addPaintable(Paintable... paintables) {
        panel.addPaintable(paintables);
        repaint();
    }

    public void addPaintable(ArrayList<Paintable> paintables) {
        panel.addPaintable(paintables);
        repaint();
    }

    public void clearProjectiles() {
        panel.clearProjectiles();
        repaint();
    }
}
