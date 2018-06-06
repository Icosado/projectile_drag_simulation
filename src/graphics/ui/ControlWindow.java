package graphics.ui;

import graphics.ProjectileInfo;
import graphics.Scale;
import graphics.appearances.Appearance;
import physics.Environment;
import physics.Projectile;
import physics.quantities.*;
import simulations.Simulation;
import simulations.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlWindow extends Viewer {

    private Simulator simulator;

    private ActionListener projectileCreationListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Coordinate c = new Coordinate(Double.valueOf(x.getText()), Double.valueOf(y.getText()));
                Mass m = new Mass(Double.valueOf(mass.getText()));
                Velocity v = new Velocity(Double.valueOf(speed.getText()), Double.valueOf(angle.getText()));
                DragCoefficient dc = new DragCoefficient(Double.valueOf(dragCoefficient.getText()));
                CrossSection cs = new CrossSection(Double.valueOf(area.getText()));
                String n = name.getText();
                Appearance a = (Appearance) appearances.getSelectedItem();

                Projectile p = new Projectile(m, v, dc, cs, a, n, c);
                projectiles.addItem(p);
                clearBoxes();
            } catch (NumberFormatException nfe) {
                System.err.println("That's not how you create a projectile!");
                clearBoxes();
            }
        }
    };
    private ActionListener projectileAdderListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Projectile projectile = ((Projectile) projectiles.getSelectedItem()).copy();
            System.out.println("Copied projectile: " + projectile);
            simulator.simulation.addProjectile(projectile);
            simulator.simulationViewer.addPaintable(projectile);
        }
    };
    private ActionListener clearProjectilesListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            simulator.simulation.clearProjectiles();
            simulator.simulationViewer.clearProjectiles();
            simulator.simulation.timeCounter.resetTime();
            simulator.stop();
            ProjectileInfo.Y_COUNT = Viewer.HALF_FONT.getSize() * 2;
        }
    };
    private ActionListener startSimulationListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            simulator.start();
        }
    };
    private ActionListener stopSimulationListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            simulator.stop();
        }
    };
    private ActionListener setScaleListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (Double.valueOf(scale.getText()) > 0) {
                    Scale.SCALE = Double.valueOf(scale.getText());
                } else {
                    System.err.println("Illegal value for scale.");
                }
                if (Integer.valueOf(increment.getText()) > 0) {
                    Scale.INCREMENT = Integer.valueOf(increment.getText());
                } else {
                    System.err.println("Illegal value for increment.");
                }
                simulator.simulationViewer.repaint();
//                scale.setText("10");
//                increment.setText("10");
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid scale.");
                System.err.println("Did you use a valid double for Scale and an integer for Increment?");
            }
        }
    };

    private JPanel panel;

    private JComboBox<Projectile> projectiles;

    private ArrayList<JLabel> labels;
    private ArrayList<JTextField> textFields;
    private ArrayList<JButton> buttons;

    private JButton createProjectileButton;
    private JButton addProjectileButton;
    private JButton startSimulationButton;
    private JButton stopSimulationButton;
    private JButton clearProjectilesButton;
    private JButton setScaleButton;

    private JLabel panelLabel;
    private JLabel massLabel;
    private JLabel speedLabel;
    private JLabel angleLabel;
    private JLabel dragLabel;
    private JLabel areaLabel;
    private JLabel nameLabel;
    private JLabel appearanceLabel;
    private JLabel xLabel;
    private JLabel yLabel;
    private JLabel scaleLabel;
    private JLabel incrementLabel;

    private JTextField mass;
    private JTextField speed;
    private JTextField angle;
    private JTextField dragCoefficient;
    private JTextField area;
    private JTextField name;
    private JTextField x;
    private JTextField y;
    private JTextField scale;
    private JTextField increment;

    private JComboBox<Appearance> appearances;

    public ControlWindow(String title) {
        super(title);

        Simulation simulation = new Simulation();
        simulator = new Simulator(simulation);

        frame.setLocation(Viewer.HEIGHT,0);
        panel = new JPanel();
        panel.setLayout(new GridLayout(15, 2));
        panel.setBackground(new Color(32, 32, 32));

        initializeComponents();

        frame.setPreferredSize(new Dimension(Viewer.WIDTH - Viewer.HEIGHT + 110, Viewer.HEIGHT));
        JScrollPane scrollPane = new JScrollPane(panel);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(scrollPane);
        frame.pack();
    }

    public ControlWindow() {
        this("Args");
    }

    public void setSimulationEnvironment(Environment environment) {
        this.simulator.simulation.setEnvironment(environment);
    }

    private void initializeComponents() {
        initializeLabels();
        initializeTextFields();
        initializeButtons();
        initializeListsAndAppearances();
        addComponents();
    }

    private void initializeLabels() {
        labels = new ArrayList<>();

        panelLabel = new JLabel("new Projectile creator");
        massLabel = new JLabel("mass (kg): ");
        speedLabel = new JLabel("speed (m/s): ");
        angleLabel = new JLabel("angle (degrees): ");
        dragLabel = new JLabel("drag coefficient: ");
        areaLabel = new JLabel("surface area (m^2): ");
        nameLabel = new JLabel("name: ");
        appearanceLabel = new JLabel("appearance: ");
        xLabel = new JLabel("initial x (m): ");
        yLabel = new JLabel("initial y (m): ");
        scaleLabel = new JLabel("scale: ");
        incrementLabel = new JLabel("increment: ");

        labels.add(panelLabel);
        labels.add(massLabel);
        labels.add(speedLabel);
        labels.add(angleLabel);
        labels.add(dragLabel);
        labels.add(areaLabel);
        labels.add(nameLabel);
        labels.add(appearanceLabel);
        labels.add(xLabel);
        labels.add(yLabel);
        labels.add(scaleLabel);
        labels.add(incrementLabel);

        for (JLabel l: labels) {
            l.setForeground(new Color(255, 255,255));
            l.setFont(Viewer.FONT);
        }
    }
    private void initializeTextFields() {
        textFields = new ArrayList<>();

        mass = new JTextField();
        speed = new JTextField();
        angle = new JTextField();
        dragCoefficient = new JTextField();
        area = new JTextField();
        name = new JTextField();
        x = new JTextField();
        y = new JTextField();
        scale = new JTextField();
        increment = new JTextField();


        textFields.add(mass);
        textFields.add(speed);
        textFields.add(angle);
        textFields.add(dragCoefficient);
        textFields.add(area);
        textFields.add(name);
        textFields.add(x);
        textFields.add(y);
        textFields.add(scale);
        textFields.add(increment);

        for (JTextField t : textFields) {
            t.setBackground(new Color(0, 0, 0));
            t.setForeground(new Color(255, 255, 255));
            t.setFont(Viewer.FONT);
        }
    }
    private void initializeButtons() {
        buttons = new ArrayList<>();
        createProjectileButton = new JButton("Create Projectile");
        createProjectileButton.addActionListener(projectileCreationListener);
        addProjectileButton = new JButton("Add Selected Projectile");
        addProjectileButton.addActionListener(projectileAdderListener);
        clearProjectilesButton = new JButton("Clear All Projectiles");
        clearProjectilesButton.addActionListener(clearProjectilesListener);
        startSimulationButton = new JButton("Start Simulation");
        startSimulationButton.addActionListener(startSimulationListener);
        stopSimulationButton = new JButton("Stop Simulation");
        stopSimulationButton.addActionListener(stopSimulationListener);
        setScaleButton = new JButton("Set Scale");
        setScaleButton.addActionListener(setScaleListener);

        buttons.add(createProjectileButton);
        buttons.add(addProjectileButton);
        buttons.add(clearProjectilesButton);
        buttons.add(startSimulationButton);
        buttons.add(stopSimulationButton);
        buttons.add(setScaleButton);

        for (JButton b: buttons) {
            b.setBackground(new Color(128, 128, 128));
            b.setForeground(new Color(255, 255, 255));
            b.setFont(Viewer.FONT);
        }
    }
    private void initializeListsAndAppearances() {
        appearances = new JComboBox<>(Appearance.ALL_APPEARANCES);
        appearances.setBackground(new Color(64, 64, 64));
        appearances.setForeground(new Color(255, 255, 255));
        appearances.setFont(Viewer.FONT);

        projectiles = new JComboBox<>(Projectile.ALL_DEFAULT_PROJECTILES);
        projectiles.setBackground(new Color(64, 64, 64));
        projectiles.setForeground(new Color(255, 255, 255));
        projectiles.setFont(Viewer.FONT);
    }
    private void addComponents() {
        panel.add(panelLabel);
        panel.add(createProjectileButton);

        panel.add(xLabel);
        panel.add(x);
        panel.add(yLabel);
        panel.add(y);

        panel.add(speedLabel);
        panel.add(speed);
        panel.add(angleLabel);
        panel.add(angle);

        panel.add(massLabel);
        panel.add(mass);
        panel.add(dragLabel);
        panel.add(dragCoefficient);
        panel.add(areaLabel);
        panel.add(area);

        panel.add(nameLabel);
        panel.add(name);
        panel.add(appearanceLabel);
        panel.add(appearances);

        panel.add(projectiles);
        panel.add(addProjectileButton);
        panel.add(startSimulationButton);
        panel.add(stopSimulationButton);

        panel.add(clearProjectilesButton);
        panel.add(setScaleButton);
        panel.add(incrementLabel);
        panel.add(increment);

        panel.add(scaleLabel);
        panel.add(scale);
    }
    private void clearBoxes() {
//        x.setText("");
//        y.setText("");
//        mass.setText("");
//        speed.setText("");
//        angle.setText("");
//        dragCoefficient.setText("");
//        area.setText("");
        name.setText("");
    }
}