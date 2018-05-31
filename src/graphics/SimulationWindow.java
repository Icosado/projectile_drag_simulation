package graphics;

public class SimulationWindow extends Viewer{
    private CanvasPanel panel;

    public SimulationWindow(String title) {
        super(title);
        panel = new CanvasPanel();
    }

    public SimulationWindow() {
        this("Projectile Motion & Drag!");
    }
}
