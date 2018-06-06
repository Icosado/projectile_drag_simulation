package graphics;

import graphics.ui.Viewer;
import physics.quantities.Time;
import simulations.Simulator;

import java.awt.*;

public class TimeCounter implements Paintable {
    public Time time;
    public TimeCounter() {
        time = new Time(); // t = 0;
    }
    public void paintOnto(Graphics g) {
        g.setFont(Viewer.HALF_FONT);
        g.setColor(new Color(255, 255, 255));
        g.drawString("t=" + time, 0, Viewer.HALF_FONT.getSize() * 3);
    }

    public void updateTime() {
        time.advanceTime(Simulator.timePerTick());
    }

    public void resetTime() {
        time = new Time();
    }
}
