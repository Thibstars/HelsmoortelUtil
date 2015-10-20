/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.io;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Interface for writing Objects
 */

public interface Writable {

    /**
     * Method to write an Object
     * @param o the Object to write
     */
    public void write(Object o);
}
