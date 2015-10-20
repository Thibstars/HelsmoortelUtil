/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.converters;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting int values to boolean ones.
 */
public class IntToBooleanConverter {
    public static final String ERROR = "Integer value must be either 1 or 0. Given value was: ";

    /**
     * Converts int value to boolean one.
     * @param value integer value
     * @return boolean value of the integer
     */
    public static boolean convert(int value){
        if (value == 1) return true;
        else if (value == 0) return false;
        else throw new IllegalArgumentException(ERROR + value);
    }
}
