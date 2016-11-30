/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class for notification labels
 *
 * @author Thibault Helsmoortel
 */

public class NotificationLabel extends JLabel{

    public static final Color SUCCESS_COLOR = Color.GREEN;
    public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
    public static final Color WARNING_COLOR = Color.RED;
    private String notificationMessage;

    /**
     * Class constructor specifying the notification message.
     *
     * @param notificationMessage the notification message
     */
    public NotificationLabel(String notificationMessage) {
        super(notificationMessage);
        this.notificationMessage = notificationMessage;
        setBackground(DEFAULT_COLOR);
        setOpaque(true);
        setVisible(true);
    }

    /**
     * Class constructor specifying the notification message.
     *
     * @param notificationMessage the notification message
     * @param state               the notification state
     */
    public NotificationLabel(String notificationMessage, State state) {
        super(notificationMessage);
        this.notificationMessage = notificationMessage;
        switch (state) {
            case SUCCESS:
                setBackground(SUCCESS_COLOR);
                break;
            case WARNING:
                setBackground(WARNING_COLOR);
                break;
            case DEFAULT:
                setBackground(DEFAULT_COLOR);
                break;
            default:
                setBackground(DEFAULT_COLOR);
                break;
        }
        setOpaque(true);
        setVisible(true);
    }

    public enum State {SUCCESS, DEFAULT, WARNING}

    //TODO add 'X' icon to remove the notification from its parent container
}
