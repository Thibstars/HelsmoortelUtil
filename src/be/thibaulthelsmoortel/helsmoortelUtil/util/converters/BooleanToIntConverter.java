/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.converters;

/**
 * Class for converting boolean values to int ones.
 *
 * @author Thibault Helsmoortel
 */
public class BooleanToIntConverter {

    /**
     * Converts a boolean value into an int one.
     *
     * @param bool the boolean value to convert
     * @return the int value of the boolean
     */
    public static int convert(boolean bool) {
        return bool ? 1 : 0;
    }
}
