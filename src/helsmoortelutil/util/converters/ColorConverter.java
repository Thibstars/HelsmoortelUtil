/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.converters;

import java.awt.*;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting colors.
 */
public class ColorConverter {

    /**
     * Converts a color and returns an hexadecimal rgb string.
     * @param color the color to convert
     * @return the hexadecimal rgb string corresponding to the color
     */
    public static String toHex(Color color) {
        return  "#"+Integer.toHexString(color.getRGB()).substring(2);
    }

    /**
     * Converts an argb color and returns an integer array.
     * @param hex the hexadecimal value of the color to convert
     * @return integer array of the argb color
     */
    public static int[] toARGB(String hex) {
        if (!hex.startsWith("#") || !(hex.length() == 7 || hex.length() == 9)) {
            throw new IllegalArgumentException("Hex color string is incorrect!");
        }

        int[] intARGB = new int[4];

        if (hex.length() == 9) {
            intARGB[0] = Integer.valueOf(hex.substring(1, 3), 16); //Alpha
            intARGB[1] = Integer.valueOf(hex.substring(3, 5), 16); //Red
            intARGB[2] = Integer.valueOf(hex.substring(5, 7), 16); //Green
            intARGB[3] = Integer.valueOf(hex.substring(7), 16); //Blue
        } else toARGB("#FF" + hex.substring(1));

        return intARGB;
    }

    /**
     * Converts a hexadecimal color value to a color.
     * @param hex the hexadecimal value of the color to obtain
     * @return the converted color
     */
    public static Color toColor(String hex) {
        return Color.decode(hex);
    }
}
