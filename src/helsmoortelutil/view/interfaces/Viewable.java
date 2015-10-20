/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view.interfaces;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Interface meant to be implemented by JFrames, JPanels,... to simplify their creation.
 */
public interface Viewable {

    /**
     * Method to initialise components
     */
    void initialiseComponents();


    /**
     * Method to add components
     */
    void addComponents();

    /**
     * Method to add listeners
     */
    void addListeners();

    /**
     * Method to create and add layout
     */
    void createLayout();
}
