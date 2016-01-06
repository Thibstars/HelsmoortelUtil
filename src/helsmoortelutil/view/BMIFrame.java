/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view;

import helsmoortelutil.view.interfaces.Viewable;

import javax.swing.*;
import java.awt.*;


//TODO add JavaDoc
public class BMIFrame extends JFrame implements Viewable {
    private BMIPanel panel;

    public BMIFrame() throws HeadlessException {
        super("Body Mass Index");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initialiseComponents();
        addComponents();
        addListeners();
        createLayout();
        setVisible(true);
        pack();
    }

    @Override
    public void initialiseComponents() {
        panel = new BMIPanel();
    }

    @Override
    public void addComponents() {
        add(panel);
    }

    @Override
    public void addListeners() {

    }

    @Override
    public void createLayout() {
    }

    public static void main(String[] args) {
        new BMIFrame();
    }
}