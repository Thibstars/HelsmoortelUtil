/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util;

import java.util.List;

/**
 * Class for regularly used math methods.
 *
 * @author Thibault Helsmoortel
 */
public final class Math {

    public static final int BMI_CONVERSION_POUNDS_AND_INCHES = 703;

    /**
     * Unavailable constructor
     */
    private Math() {
    }

    /**
     * Returns the difference between two {@code int} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the difference between {@code a} and {@code b}
     */
    public static int difference(int a, int b) {
        if (a > b) return a - b;
        if (b > a) return b - a;
        else return 0;
    }

    /**
     * Returns the difference between two {@code long} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the difference between {@code a} and {@code b}
     */
    public static long difference(long a, long b) {
        if (a > b) return a - b;
        if (b > a) return b - a;
        else return 0;
    }

    /**
     * Returns the difference between two {@code float} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the difference between {@code a} and {@code b}
     */
    public static float difference(float a, float b) {
        if (a > b) return a - b;
        if (b > a) return b - a;
        else return 0;
    }

    /**
     * Returns the difference between two {@code double} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the difference between {@code a} and {@code b}
     */
    public static double difference(double a, double b) {
        if (a > b) return a - b;
        if (b > a) return b - a;
        else return 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code int} value is positive.
     *
     * @param i the value to check
     * @return a {@code boolean} indicating if the value is positive
     */
    public static boolean isPositive(int i) {
        return i >= 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code long} value is positive.
     *
     * @param l the value to check
     * @return a {@code boolean} indicating if the value is positive
     */
    public static boolean isPositive(long l) {
        return l >= 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code float} value is positive.
     *
     * @param f the value to check
     * @return a {@code boolean} indicating if the value is positive
     */
    public static boolean isPositive(float f) {
        return f >= 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code double} value is positive.
     *
     * @param d the value to check
     * @return a {@code boolean} indicating if the value is positive
     */
    public static boolean isPositive(double d) {
        return d >= 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code int} value is negative.
     *
     * @param i the value to check
     * @return a {@code boolean} indicating if the value is negative
     */
    public static boolean isNegative(int i) {
        return i < 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code long} value is negative.
     *
     * @param l the value to check
     * @return a {@code boolean} indicating if the value is negative
     */
    public static boolean isNegative(long l) {
        return l < 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code float} value is negative.
     *
     * @param f the value to check
     * @return a {@code boolean} indicating if the value is negative
     */
    public static boolean isNegative(float f) {
        return f < 0;
    }

    /**
     * Returns a {@code boolean} indicating whether a {@code double} value is negative.
     *
     * @param d the value to check
     * @return a {@code boolean} indicating if the value is negative
     */
    public static boolean isNegative(double d) {
        return d < 0;
    }

    /**
     * Returns a random value between two {@code int} values.
     *
     * @param lower minimum value
     * @param upper maximum value
     * @return a random value between {@code lower} and {@code upper}
     */
    public static double randomBetween(int lower, int upper) {
        return (java.lang.Math.random() * upper) + lower;
    }

    /**
     * Returns a random value between two {@code double} values.
     *
     * @param lower minimum value
     * @param upper maximum value
     * @return a random value between {@code lower} and {@code upper}
     */
    public static double randomBetween(double lower, double upper) {
        return (java.lang.Math.random() * upper) + lower;
    }

    /**
     * Returns the greatest common divisor of two {@code int} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the greatest common divisor of {@code a} and {@code b}
     */
    public static int greatestCommonDivisor(int a, int b) {
        if (b <= a && (a % b == 0)) return b;
        else if (a < b) return greatestCommonDivisor(b, a);
        else return greatestCommonDivisor(b, a % b);
    }

    /**
     * Returns the lowest common divisor of two {@code int} values.
     *
     * @param a an argument
     * @param b another argument
     * @return the lowest common divisor of {@code a} and {@code b}
     */
    public static int lowestCommonDivisor(int a, int b) {
        return a * (b / greatestCommonDivisor(a, b));
    }

    /**
     * Returns the average of an array of {@code int} values.
     *
     * @param values array of {@code int} values
     * @return the average of the given values
     */
    public static double average(int[] values) {
        int n = values.length, sum = 0, avg = 0;
        if (n != 0 || values != null) {
            for (int i = 0; i < n; i++) {
                sum += values[i];
            }
            avg = sum / n;
        }
        return avg;
    }

    /**
     * Returns the average of an array of {@code double} values.
     *
     * @param values array of {@code double} values
     * @return the average of the given values
     */
    public static double average(double[] values) {
        int n = values.length;
        double avg = 0.0, sum = 0.0;
        if (n != 0 || values != null) {
            for (int i = 0; i < n; i++) {
                sum += values[i];
            }
            avg = sum / n;
        }
        return avg;
    }

    /**
     * Returns the average of a list of {@code double} values.
     *
     * @param values list of {@code double} values
     * @return the average of the given values
     */
    public static double average(List<Double> values) {
        int n = values.size();
        double avg = 0.0, sum = 0.0;
        if (n != 0 || values != null) {
            for (int i = 0; i < n; i++) {
                sum += values.get(i);
            }
            avg = sum / n;
        }
        return avg;
    }

    /**
     * Returns the Body Mass Index (BMI) of an individual
     *
     * @param mass   mass of the individual in kilograms
     * @param height height of the individual metres
     * @return the BMI of the individual
     */
    public static double bodyMassIndex(double mass, double height) {
        return mass / java.lang.Math.pow(height, 2);
    }

    /**
     * Returns the Body Mass Index (BMI) of an individual
     *
     * @param mass                 mass of the individual in kilograms or pounds
     * @param height               height of the individual in metres or inches
     * @param isMetresAndKilograms {@code boolean} indicating if kilograms and metres are used (true) or pounds and inches (false)
     * @return the BMI of the individual
     */
    public static double bodyMassIndex(double mass, double height, boolean isMetresAndKilograms) {
        double baseFormula = bodyMassIndex(mass, height);
        if (isMetresAndKilograms) return baseFormula;
        else return baseFormula * BMI_CONVERSION_POUNDS_AND_INCHES;
    }

    /**
     * Returns whether 2 fractures are in proportion.
     *
     * @param a counter of the first fracture
     * @param b denominator of the first fracture
     * @param c counter of the second fracture
     * @param d denominator of the second fracture
     * @return {@code boolean} indicating if both fractures are in proportion (true when they are)
     */
    public static boolean isProportion(int a, int b, int c, int d) {
        return a * d == b * c;
    }

    /**
     * Returns whether 2 fractures are in proportion.
     *
     * @param a counter of the first fracture
     * @param b denominator of the first fracture
     * @param c counter of the second fracture
     * @param d denominator of the second fracture
     * @return {@code boolean} indicating if both fractures are in proportion (true when they are)
     */
    public static boolean isProportion(double a, double b, double c, double d) {
        return a * d == b * c;
    }
}
