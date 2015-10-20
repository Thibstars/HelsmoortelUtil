/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.tests;

import helsmoortelutil.view.NotificationLabel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thibault Helsmoortel
 */

public class TestFrame extends JFrame {

    public TestFrame() throws HeadlessException {
        super("Test Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        NotificationLabel notificationLabel =
                new NotificationLabel("Test notification message", NotificationLabel.State.DEFAULT);
        add(notificationLabel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
