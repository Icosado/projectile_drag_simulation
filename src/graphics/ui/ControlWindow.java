package graphics.ui;

import graphics.appearances.Appearance;
import physics.Projectile;
import physics.quantities.CrossSection;
import physics.quantities.DragCoefficient;
import physics.quantities.Mass;
import physics.quantities.Velocity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlWindow extends Viewer {

    private ActionListener projectileCreationListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Mass m = new Mass(Double.valueOf(mass.getText()));
            mass.setText("");

            Velocity v = new Velocity(Double.valueOf(speed.getText()), Double.valueOf(angle.getText()));
            speed.setText("");
            angle.setText("");

            DragCoefficient dc = new DragCoefficient(Double.valueOf(dragCoefficient.getText()));
            dragCoefficient.setText("");

            CrossSection cs = new CrossSection(Double.valueOf(area.getText()));
            area.setText("");

            String n = name.getText();
            name.setText("");

            Appearance a = (Appearance) appearances.getSelectedItem();

            Projectile p = new Projectile(m, v, dc, cs, a, n);
            projectiles.addElement(p);
        }
    };

    private JPanel panel;

    private DefaultListModel<Projectile> projectiles;
    private JList<Projectile> projectileList;

    ArrayList<JLabel> labels;
    ArrayList<JTextField> textFields;
    ArrayList<JButton> buttons;

    private JButton createProjectileButton;
    private JButton addProjectileButton;

    private JLabel panelLabel;
    private JLabel massLabel;
    private JLabel speedLabel;
    private JLabel angleLabel;
    private JLabel dragLabel;
    private JLabel areaLabel;
    private JLabel nameLabel;
    private JLabel appearanceLabel;

    private JTextField mass;
    private JTextField speed;
    private JTextField angle;
    private JTextField dragCoefficient;
    private JTextField area;
    private JTextField name;

    private JComboBox<Appearance> appearances;

    public ControlWindow(String title) {
        super(title);
        frame.setLocation(Viewer.HEIGHT,0);
        panel = new JPanel();
        panel.setLayout(new GridLayout(15, 2));
        panel.setBackground(new Color(32, 32, 32));

        initializeLabels();
        initializeTextFields();
        initializeButtons();
        initializeListsAndAppearances();
        addComponents();

        frame.setPreferredSize(new Dimension(Viewer.WIDTH - Viewer.HEIGHT + 110, Viewer.HEIGHT));
        JScrollPane scrollPane = new JScrollPane(panel);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(scrollPane);
        frame.pack();
    }

    public ControlWindow() {
        this("Args");
    }

    private void initializeLabels() {
        labels = new ArrayList<>();
        panelLabel = new JLabel("new Projectile creator");
        massLabel = new JLabel("mass: ");
        speedLabel = new JLabel("speed: ");
        angleLabel = new JLabel("angle (degrees): ");
        dragLabel = new JLabel("drag coefficient: ");
        areaLabel = new JLabel("surface area: ");
        nameLabel = new JLabel("name: ");
        appearanceLabel = new JLabel("appearance: ");
        labels.add(panelLabel);
        labels.add(massLabel);
        labels.add(speedLabel);
        labels.add(angleLabel);
        labels.add(dragLabel);
        labels.add(areaLabel);
        labels.add(nameLabel);
        labels.add(appearanceLabel);
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

        textFields.add(mass);
        textFields.add(speed);
        textFields.add(angle);
        textFields.add(dragCoefficient);
        textFields.add(area);
        textFields.add(name);

        for (JTextField t : textFields) {
            t.setBackground(new Color(0, 0, 0));
            t.setForeground(new Color(255, 255, 255));
            t.setFont(Viewer.FONT);
        }
    }

    private void initializeButtons() {
        buttons = new ArrayList<>();
        createProjectileButton = new JButton("Create Projectile");
        addProjectileButton = new JButton("Add Selected Projectile");

        buttons.add(createProjectileButton);
        buttons.add(addProjectileButton);

        for (JButton b: buttons) {
            b.setBackground(new Color(128, 128, 128));
            b.setForeground(new Color(255, 255, 255));
            b.setFont(Viewer.FONT);
        }
    }

    private void addComponents() {
        panel.add(panelLabel);
        panel.add(createProjectileButton);

        panel.add(massLabel);
        panel.add(mass);

        panel.add(speedLabel);
        panel.add(speed);

        panel.add(angleLabel);
        panel.add(angle);

        panel.add(dragLabel);
        panel.add(dragCoefficient);

        panel.add(areaLabel);
        panel.add(area);

        panel.add(nameLabel);
        panel.add(name);

        panel.add(appearanceLabel);
        panel.add(appearances);

        panel.add(projectileList);
        panel.add(addProjectileButton);

        panel.add(new JLabel("1"));
        panel.add(new JLabel("2"));
        panel.add(new JLabel("3"));
    }

    private void initializeListsAndAppearances() {
        appearances = new JComboBox<>(Appearance.ALL_APPEARANCES);
        appearances.setBackground(new Color(64, 64, 64));
        appearances.setForeground(new Color(255, 255, 255));
        appearances.setFont(Viewer.FONT);
        projectiles = new DefaultListModel<>();
        projectileList = new JList<>(projectiles);
        projectileList.setBackground(new Color(64, 64, 64));
        projectileList.setForeground(new Color(255, 255, 255));
        projectileList.setFont(Viewer.FONT);
        projectiles.addElement(Projectile.CIRCLE);
        projectiles.addElement(Projectile.SQUARE);
        projectiles.addElement(Projectile.COFFEE_FILTER);
    }
}
