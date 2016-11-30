/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.converters;

/**
 * Class for converting Strings.
 *
 * @author Thibault Helsmoortel
 */
public class StringConverter {

    /**
     * Converts and returns a short.
     *
     * @param string the String to convert
     * @return the converted short
     */
    public static short toShort(String string) {
        return Short.parseShort(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param s the short to convert
     * @return the converted String
     */
    public static String fromShort(short s) {
        return "" + s;
    }

    /**
     * Converts and returns a byte.
     *
     * @param string the String to convert
     * @return the converted byte
     */
    public static byte toByte(String string) {
        return Byte.parseByte(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param b the byte to convert
     * @return the converted String
     */
    public static String fromByte(byte b) {
        return "" + b;
    }

    /**
     * Converts and returns an integer.
     *
     * @param string the String to convert
     * @return the converted integer
     */
    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param i the integer to convert
     * @return the converted String
     */
    public static String fromInt(int i) {
        return "" + i;
    }

    /**
     * Converts and returns a long.
     *
     * @param string the String to convert
     * @return the converted long
     */
    public static long toLong(String string) {
        return Long.parseLong(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param l the long to convert
     * @return the converted String
     */
    public static String fromLong(long l) {
        return "" + l;
    }

    /**
     * Converts and returns a float.
     *
     * @param string the String to convert
     * @return the converted float
     */
    public static float toFloat(String string) {
        return Float.parseFloat(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param f the float to convert
     * @return the converted String
     */
    public static String fromFloat(float f) {
        return "" + f;
    }

    /**
     * Converts and returns a double.
     *
     * @param string the String to convert
     * @return the converted double
     */
    public static double toDouble(String string) {
        return Double.parseDouble(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param d the double to convert
     * @return the converted String
     */
    public static String fromDouble(double d) {
        return "" + d;
    }

    /**
     * Converts and returns a char array.
     *
     * @param string the String to convert
     * @return the converted char array
     */
    public static char[] toCharArray(String string) {
        char[] chars = new char[string.length()];
        for (int i = 0; i < string.length(); i++) chars[i] = string.charAt(i);
        return chars;
    }

    /**
     * Converts and returns a String.
     *
     * @param chars the char array to convert
     * @return the converted String
     */
    public static String fromCharArray(char[] chars) {
        String string = "";
        for (char aChar : chars) string += aChar;
        return string;
    }

    /**
     * Converts and returns a StringBuilder.
     *
     * @param string the String to convert
     * @return the converted StringBuilder
     */
    public static StringBuilder toStringBuilder(String string) {
        return new StringBuilder(string);
    }

    /**
     * Converts and returns a String.
     *
     * @param stringBuilder the StringBuilder to convert
     * @return the converted String
     */
    public static String fromStringBuilder(StringBuilder stringBuilder) {
        return stringBuilder.toString();
    }

    /**
     * Converts and returns a String.
     *
     * @param string the String to convert
     * @return the converted String.
     */
    public static String toTitleCase(String string) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : string.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }
}
