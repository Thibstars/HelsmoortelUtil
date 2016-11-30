/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.io;

/**
 * Interface for writing Objects
 *
 * @author Thibault Helsmoortel
 */

public interface Writable {

    /**
     * Method to write an Object
     *
     * @param o the Object to write
     */
    public void write(Object o);
}
