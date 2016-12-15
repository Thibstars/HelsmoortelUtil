/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.view;

/**
 * Global interface for view classes.
 *
 * @author Thibault Helsmoortel
 */
public interface Viewable {

    /**
     * Method to initialise components
     */
    void initComponents();

    /**
     * Method to create and add layout
     */
    void createLayout();

    /**
     * Method to add components
     */
    void addComponents();

    /**
     * Method to add listeners
     */
    void addListeners();
}
