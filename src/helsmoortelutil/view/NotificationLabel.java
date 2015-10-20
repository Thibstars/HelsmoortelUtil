/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thibault Helsmoortel
 */

public class NotificationLabel extends JLabel{
    //TODO write JavaDoc

    public enum State {SUCCES, DEFAULT, WARNING};

    private String notificationMessage;
    public static final Color SUCCESS_COLOR = Color.GREEN;
    public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
    public static final Color WARNING_COLOR = Color.RED;

    public NotificationLabel(String notificationMessage) {
        super(notificationMessage);
        this.notificationMessage = notificationMessage;
        setBackground(DEFAULT_COLOR);
        setOpaque(true);
        setVisible(true);
    }

    public NotificationLabel(String notificationMessage, State state) {
        super(notificationMessage);
        this.notificationMessage = notificationMessage;
        switch (state) {
            case SUCCES:
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

    //TODO add 'X' icon to remove the notification from its parent container
}
