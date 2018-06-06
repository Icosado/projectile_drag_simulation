package simulations;

import graphics.Paintable;
import graphics.ui.ControlWindow;
import graphics.ui.SimulationWindow;
import physics.Environment;
import physics.Projectile;
import physics.quantities.Time;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulator {
    public static final int GLOBAL_TICK_MS = 33; // 33 ms tick rate. 30 frames per second

    public ActionListener updater;
    public SimulationWindow simulationViewer;
    public Simulation simulation;
    private Timer simulationTimer;

    public Simulator(Simulation sim) {
        simulationViewer = new SimulationWindow();
        this.simulation = sim;
        simulationViewer.addPaintable(simulation.timeCounter);

        for (Paintable paintable: sim.getProjectiles()) {
            simulationViewer.addPaintable(paintable);
            System.out.println(paintable);
        }

        updater = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulationViewer.repaint();
                sim.tickSimulation();
            }
        };
        simulationTimer = new Timer(Simulator.GLOBAL_TICK_MS, updater);
    }

    public void start() {
        simulationTimer.start();
    }

    public void stop() {
        simulationTimer.stop();
    }

    public static Time timePerTick() {
        double t = ((double) GLOBAL_TICK_MS) / 1000;
        return new Time(t);
    }

    public static void main(String[] args) {
        ControlWindow control = new ControlWindow();
        control.setSimulationEnvironment(Environment.EARTH_SEA);
    }
}
