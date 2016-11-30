/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.view;

import be.thibaulthelsmoortel.helsmoortelUtil.view.interfaces.Viewable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class to sample a BMI calculator.
 */
public class BMIPanel extends JPanel implements Viewable {
    private ButtonGroup btnGroup;
    private JRadioButton rbMetric, rbImperial;
    private JLabel lblIntro, lblMass, lblHeight, lblResult;
    private JTextField tfMass, tfHeight;
    private JButton btnCalc;

    public BMIPanel() {
        initComponents();
        createLayout();
        addComponents();
        addListeners();
        setVisible(true);
    }

    @Override
    public void initComponents() {
        btnGroup = new ButtonGroup();
        rbMetric = new JRadioButton("Kg and metres");
        rbMetric.setSelected(true);
        rbImperial = new JRadioButton("Pounds and inches");
        btnGroup.add(rbMetric);
        btnGroup.add(rbImperial);

        lblIntro = new JLabel("Calculate your BMI");
        lblMass = new JLabel("Mass (kg):");
        lblHeight = new JLabel("Height (metres):");
        lblResult = new JLabel();

        tfMass = new JTextField();
        tfHeight = new JTextField();

        btnCalc = new JButton("Calculate!");
    }

    @Override
    public void addComponents() {
        add(lblIntro, BorderLayout.PAGE_START);

        JPanel pnlInput = new JPanel();
        pnlInput.setLayout(new GridLayout(2, 2));

        pnlInput.add(lblMass);
        pnlInput.add(tfMass);
        pnlInput.add(lblHeight);
        pnlInput.add(tfHeight);
        add(pnlInput, BorderLayout.CENTER);

        JPanel pnlResult = new JPanel();
        pnlResult.setLayout(new GridLayout(3, 1));

        JPanel pnlRadioButtons = new JPanel();
        pnlRadioButtons.add(rbMetric);
        pnlRadioButtons.add(rbImperial);

        pnlResult.add(pnlRadioButtons);
        pnlResult.add(btnCalc);
        pnlResult.add(lblResult);
        add(pnlResult, BorderLayout.PAGE_END);
    }

    @Override
    public void addListeners() {
        rbMetric.addActionListener(e -> {
            if (rbMetric.isSelected()) {
                lblMass.setText("Mass (kg):");
                lblHeight.setText("Height (metres):");
                tfMass.setText("");
                tfHeight.setText("");
                lblResult.setText("");
            }
        });
        rbImperial.addActionListener(e -> {
            if (rbImperial.isSelected()) {
                lblMass.setText("Mass (pounds):");
                lblHeight.setText("Height (inches):");
                tfMass.setText("");
                tfHeight.setText("");
                lblResult.setText("");
            }
        });
        btnCalc.addActionListener(e -> {
            if (tfMass.getText() != null && tfHeight.getText() != null) {
                double mass = Double.parseDouble(tfMass.getText());
                double height = Double.parseDouble(tfHeight.getText());
                boolean isMetric = rbMetric.isSelected();
                String bmi = String.format("%.2f", be.thibaulthelsmoortel.helsmoortelUtil.util.Math.bodyMassIndex(mass, height, isMetric));
                lblResult.setText("Your BMI value: " + bmi);
            }
        });
    }

    @Override
    public void createLayout() {
        this.setLayout(new BorderLayout());
    }
}
