package simulations;

import graphics.ui.ControlWindow;
import graphics.ui.SimulationWindow;
import physics.Environment;
import physics.Projectile;
import physics.quantities.Time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulator {
    public static final int GLOBAL_TICK_MS = 50; // 33 ms tick rate. 30 frames per second

    public ActionListener updater;
    public SimulationWindow simulationViewer;

    public Simulator(Simulation sim) {
        simulationViewer = new SimulationWindow();
        simulationViewer.addPaintable(sim.getProjectile());

        updater = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulationViewer.repaint();
                sim.tickSimulation();
            }
        };
    }

    public void start() {
        new javax.swing.Timer(Simulator.GLOBAL_TICK_MS, updater).start();
    }

    public static Time timePerTick() {
        double t = ((double) GLOBAL_TICK_MS) / 1000;
        return new Time(t);
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(Environment.EARTH_SEA, Projectile.CIRCLE);
        Simulator simulator = new Simulator(simulation);
        ControlWindow control = new ControlWindow();
        simulator.start();
    }
}
