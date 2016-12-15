/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.text;

import java.util.Random;

/**
 * Class for generating random Strings.
 *
 * @author Thibault Helsmoortel
 */
public final class RandomStringGenerator {
    public static final String NUM = "0123456789";
    private static final String AB_FULL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String AB_NONUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    /**
     * Returns a random alphanumeric String.
     *
     * @param length the length of the String
     * @return the random alphanumeric String
     */
    public static String randomAlphaNumericString(int length) {
        return getRandomString(length, AB_FULL).toString();
    }

    /**
     * Returns a random String (excluding numerical values).
     *
     * @param length the length of the String
     * @return the random String
     */
    public static String randomString(int length) {
        return getRandomString(length, AB_NONUM).toString();
    }

    /**
     * Returns a random numeric String.
     *
     * @param length the length of the String
     * @return the random String
     */
    public static String randomNumericString(int length) {
        return getRandomString(length, NUM).toString();
    }

    /**
     * Returns a StringBuilder instance with a random value, based on length and base String.
     *
     * @param length the length of the StringBuilder
     * @param base   the base String
     * @return a random StringBuilder
     */
    private static StringBuilder getRandomString(int length, String base) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(base.charAt(rnd.nextInt(base.length())));
        return sb;
    }
}
