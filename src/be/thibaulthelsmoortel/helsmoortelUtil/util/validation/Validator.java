/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.validation;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for validation purposes.
 */
public class Validator {
    private static final String ERROR_PREFIX = "[Validator} ";

    //region Primary methods

    /**
     * Validates a ValidationObject and returns an Object when valid.
     * @param validationObject the ValidationObject to validate
     * @return Object when valid
     */
    public static Object validate(ValidationObject validationObject) {
        return validationObject.validate();
    }

    /**
     * Validates a Validateable and returns an Object when valid.
     * @param validateable the Validateable to validate
     * @return Object when valid
     */
    public static Object validate(Validateable validateable) {
        return validateable.validate();
    }

    /**
     * Returns true on a successful validation of a ValidationObject.
     * @param validationObject the ValidationObject to try to validate
     * @return true when valid
     */
    public static boolean tryValidate(ValidationObject validationObject) {
        return validationObject.tryValidate();
    }

    /**
     * Returns true on a successful validation of a Validateable.
     * @param validateable the Validateable to try to validate.
     * @return true when valid
     */
    public static boolean tryValidate(Validateable validateable) {
        return validateable.tryValidate();
    }

    //endregion

    /**
     * Validates and returns an Object when it's null.
     * @param o the Object to validate
     * @return the Object when valid
     */
    public static Object validateNull(Object o) {
        return validateNull(o, ERROR_PREFIX + o + " is not null.");
    }

    /**
     * Validates and returns an Object when it's null.
     * @param o the Object to validate
     * @param errorMessage the errorMessage for the IllegalArgumentException when invalid
     * @return the Object when valid
     */
    public static Object validateNull(Object o, String errorMessage) {
        if (tryValidateNull(o)) return o;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an Object.
     * @param o the Object to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNull(Object o) {
        return o == null;
    }

    /**
     * Validates and returns an Object when it's not null.
     * @param o the Object to validate
     * @return the Object when valid
     */
    public static Object validateNotNull(Object o) {
        return validateNotNull(o, ERROR_PREFIX + o + " can't be null.");
    }

    /**
     * Validates and returns an Object when it's not null.
     * @param o the Object to validate
     * @param errorMessage the errorMessage for the IllegalArgumentException when invalid
     * @return the Object when valid
     */
    public static Object validateNotNull(Object o, String errorMessage) {
       if (tryValidateNotNull(o)) return o;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an Object.
     * @param o the Object to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNotNull(Object o) {
        return o != null;
    }

    /**
     * Validates and returns a String when it's valid.
     * @param string the String to validate
     * @param minLength the minimum length for the string
     * @return the string when valid
     */
    public static String validateMinLength(String string, int minLength) {
        return validateMinLength(string, minLength,
                ERROR_PREFIX + string + " minimum length not achieved.");
    }

    /**
     * Validates and returns a String when it's valid.
     * @param string the String to validate
     * @param minLength the minimum length for the string
     * @param errorMessage the error message
     * @return the string when valid
     */
    public static String validateMinLength(String string, int minLength, String errorMessage) {
        if (tryValidateMinLength(string, minLength)) return string;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a String.
     * @param string the String to try to validate
     * @param minLength the minimum length for the string
     * @return true when valid
     */
    public static boolean tryValidateMinLength(String string, int minLength) {
        return string.length() >= minLength;
    }

    /**
     * Validates and returns a String when its valid.
     * @param string the String to validate
     * @param maxLength the maximum length for the string
     * @return the string when valid
     */
    public static String validateMaxLength(String string, int maxLength) {
        return validateMaxLength(string, maxLength,
                ERROR_PREFIX + string + " maximum length exceeded.");
    }

    /**
     * Validates and returns a String when it's valid.
     * @param string the String to validate
     * @param maxLength the maximum length for the string
     * @param errorMessage the error message
     * @return the string when valid
     */
    public static String validateMaxLength(String string, int maxLength, String errorMessage) {
        if (tryValidateMaxLength(string, maxLength)) return string;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a String.
     * @param string the String to try to validate
     * @param maxLength the maximum length for the string
     * @return true when valid
     */
    public static boolean tryValidateMaxLength(String string, int maxLength) {
        return string.length() <= maxLength;
    }

    /**
     * Validates and returns a String when it's valid.
     * @param string the String to validate
     * @param minLength the minimum length for the string
     * @param maxLength the maximum length for the string
     * @return the string when valid
     */
    public static String validateLength(String string, int minLength, int maxLength) {
        return validateLength(string, minLength, maxLength,
                ERROR_PREFIX + string + " length does not match.");
    }

    /**
     * Validates and returns a String when it's valid.
     * @param string the String to validate
     * @param minLength the minimum length for the string
     * @param maxLength the maximum length for the string
     * @param errorMessage the error message
     * @return the string when valid
     */
    public static String validateLength(String string, int minLength, int maxLength, String errorMessage) {
        if (tryValidateLength(string, minLength, maxLength)) return string;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a String.
     * @param string the String to try to validate
     * @param minLength the minimum length for the string
     * @param maxLength the maximum length for the string
     * @return true when valid
     */
    public static boolean tryValidateLength(String string, int minLength, int maxLength) {
        return tryValidateMinLength(string, minLength) && tryValidateMaxLength(string, maxLength);
    }

    /**
     * Validates an returns a byte when it's valid.
     * @param b the byte to validate
     * @return the byte when valid
     */
    public static byte validatePositive(byte b) {
        return validatePositive(b, ERROR_PREFIX + b + " is not positive.");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validatePositive(byte b, String errorMessage) {
        if (tryValidatePositive(b)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(byte b) {
        return b >= 0;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @return the short when valid
     */
    public static short validatePositive(short s) {
       return validatePositive(s, ERROR_PREFIX + s + " is not positive.");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validatePositive(short s, String errorMessage) {
        if (tryValidatePositive(s)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(short s) {
        return s >= 0;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @return the integer when valid
     */
    public static int validatePositive(int i) {
        return validatePositive(i, ERROR_PREFIX + i + " is not positive.");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validatePositive(int i, String errorMessage) {
        if (tryValidatePositive(i)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(int i) {
        return i >= 0;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @return the long when valid
     */
    public static long validatePositive(long l) {
        return validatePositive(l, ERROR_PREFIX + l + " is not positive.");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validatePositive(long l, String errorMessage) {
        if (tryValidatePositive(l)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(long l) {
        return l >= 0L;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @return the float when valid
     */
    public static float validatePositive(float f) {
        return validatePositive(f, ERROR_PREFIX + f + " is not positive.");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validatePositive(float f, String errorMessage) {
        if (tryValidatePositive(f)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(float f) {
        return f >= 0.0f;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @return the double when valid
     */
    public static double validatePositive(double d) {
        return validatePositive(d, ERROR_PREFIX + d + " is not positive.");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validatePositive(double d, String errorMessage) {
        if (tryValidatePositive(d)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @return true when valid
     */
    public static boolean tryValidatePositive(double d) {
        return d >= 0.0d;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @return the byte when valid
     */
    public static byte validateNegative(byte b) {
        return validateNegative(b, ERROR_PREFIX + b + " is not negative.");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateNegative(byte b, String errorMessage) {
        if (tryValidateNegative(b)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(byte b) {
        return b < 0;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @return the short when valid
     */
    public static short validateNegative(short s) {
        return validateNegative(s, ERROR_PREFIX + s + " is not negative.");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateNegative(short s, String errorMessage) {
        if (tryValidateNegative(s)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(short s) {
        return s < 0;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @return the integer when valid
     */
    public static int validateNegative(int i) {
        return validateNegative(i, ERROR_PREFIX + i + " is not negative.");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateNegative(int i, String errorMessage) {
        if (tryValidateNegative(i)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(int i) {
        return i < 0;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @return the long when valid
     */
    public static long validateNegative(long l) {
        return validateNegative(l, ERROR_PREFIX + l + " is not negative.");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param errorMessage the error message
     * @return te long when valid
     */
    public static long validateNegative(long l, String errorMessage) {
        if (tryValidateNegative(l)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(long l) {
        return l < 0L;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @return the float when valid
     */
    public static float validateNegative(float f) {
        return validateNegative(f, ERROR_PREFIX + f + " is not negative.");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateNegative(float f, String errorMessage) {
        if (tryValidateNegative(f)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(float f) {
        return f < 0.0f;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @return the double when valid
     */
    public static double validateNegative(double d) {
        return validateNegative(d, ERROR_PREFIX + d + " is not negative.");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateNegative(double d, String errorMessage) {
        if (tryValidateNegative(d)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @return true when valid
     */
    public static boolean tryValidateNegative(double d) {
        return d < 0.0d;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @return the short when valid
     */

    public static short validateSmaller(short s, short val) {
        return validateSmaller(s, val,
                ERROR_PREFIX + s + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateSmaller(short s, short val, String errorMessage) {
        if (tryValidateSmaller(s, val)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(short s, short val) {
        return s < val;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate.
     * @param val the value to validate with
     * @return the byte when valid
     */
    public static byte validateSmaller(byte b, byte val) {
        return validateSmaller(b, val,
                ERROR_PREFIX + b + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateSmaller(byte b, byte val, String errorMessage) {
        if (tryValidateSmaller(b, val)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(byte b, byte val) {
        return b < val;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @return the integer when valid
     */
    public static int validateSmaller(int i, int val) {
        return validateSmaller(i, val,
                ERROR_PREFIX + i + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateSmaller(int i, int val, String errorMessage) {
        if (tryValidateSmaller(i, val)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(int i, int val) {
        return i < val;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @return the long when valid
     */
    public static long validateSmaller(long l, long val) {
        return validateSmaller(l, val,
                ERROR_PREFIX + l + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateSmaller(long l, long val, String errorMessage) {
        if (tryValidateSmaller(l, val)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(long l, long val) {
        return l < val;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @return the float when valid
     */
    public static float validateSmaller(float f, float val) {
        return validateSmaller(f, val,
                ERROR_PREFIX + f + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateSmaller(float f, float val, String errorMessage) {
        if (tryValidateSmaller(f, val)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(float f, float val) {
        return f < val;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @return the double when valid
     */
    public static double validateSmaller(double d, double val) {
        return validateSmaller(d, val,
                ERROR_PREFIX + d + " is not smaller than " + val + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateSmaller(double d, double val, String errorMessage) {
        if (tryValidateSmaller(d, val)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmaller(double d, double val) {
        return d < val;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @return the short when valid
     */
    public static short validateSmallerOrEqual(short s, short val) {
        return validateSmallerOrEqual(s, val,
                ERROR_PREFIX + s + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateSmallerOrEqual(short s, short val, String errorMessage) {
        if (tryValidateSmallerOrEqual(s, val)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(short s, short val) {
        return s <= val;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @return the byte when valid
     */
    public static byte validateSmallerOrEqual(byte b, byte val) {
        return validateSmallerOrEqual(b, val,
                ERROR_PREFIX + b + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateSmallerOrEqual(byte b, byte val, String errorMessage) {
        if (tryValidateSmallerOrEqual(b, val)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(byte b, byte val) {
        return b <= val;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @return the integer when valid
     */
    public static int validateSmallerOrEqual(int i, int val) {
        return validateSmallerOrEqual(i, val,
                ERROR_PREFIX + i + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateSmallerOrEqual(int i, int val, String errorMessage) {
        if (tryValidateSmallerOrEqual(i, val)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @param val teh value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(int i, int val) {
        return i <= val;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @return the long when valid
     */
    public static long validateSmallerOrEqual(long l, long val) {
        return validateSmallerOrEqual(l, val,
                ERROR_PREFIX + l + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateSmallerOrEqual(long l, long val, String errorMessage) {
        if (tryValidateSmallerOrEqual(l, val)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(long l, long val) {
        return l <= val;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @return the float when valid
     */
    public static float validateSmallerOrEqual(float f, float val) {
        return validateSmallerOrEqual(f, val,
                ERROR_PREFIX + f + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateSmallerOrEqual(float f, float val, String errorMessage) {
        if (tryValidateSmallerOrEqual(f, val)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(float f, float val) {
        return f <= val;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @return the double when valid
     */
    public static double validateSmallerOrEqual(double d, double val) {
        return validateSmallerOrEqual(d, val,
                ERROR_PREFIX + d + " is not smaller than or equal to" + val + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateSmallerOrEqual(double d, double val, String errorMessage) {
        if (tryValidateSmallerOrEqual(d, val)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateSmallerOrEqual(double d, double val) {
        return d <= val;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @return the short when valid
     */
    public static short validateGreater(short s, short val) {
        return validateGreater(s, val,
                ERROR_PREFIX + s + " is not greater than " + val + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateGreater(short s, short val, String errorMessage) {
        if (tryValidateGreater(s, val)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(short s, short val) {
        return s > val;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @return the byte when valid
     */
    public static byte validateGreater(byte b, byte val) {
        return validateGreater(b, val,
                ERROR_PREFIX + b + " is not greater than " + val + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateGreater(byte b, byte val, String errorMessage) {
        if (tryValidateGreater(b, val)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(byte b, byte val) {
        return b > val;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @return the integer when valid
     */
    public static int validateGreater(int i, int val) {
        return validateGreater(i, val,
                ERROR_PREFIX + i + " is not greater than " + val + ".");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateGreater(int i, int val, String errorMessage) {
        if (tryValidateGreater(i, val)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successfull validation of an integer.
     * @param i the integer to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(int i, int val) {
        return i > val;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @return the long when valid
     */
    public static long validateGreater(long l, long val) {
        return validateGreater(l, val,
                ERROR_PREFIX + l + " is not greater than " + val + ".");
    }

    /**
     * Validates an returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateGreater(long l, long val, String errorMessage) {
        if (tryValidateGreater(l, val)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(long l, long val) {
        return l > val;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @return the float when valid
     */
    public static float validateGreater(float f, float val) {
        return validateGreater(f, val,
                ERROR_PREFIX + f + " is not greater than " + val + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateGreater(float f, float val, String errorMessage) {
        if (tryValidateGreater(f, val)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(float f, float val) {
        return f > val;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @return the double when valid
     */
    public static double validateGreater(double d, double val) {
        return validateGreater(d, val,
                ERROR_PREFIX + d + " is not greater than " + val + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateGreater(double d, double val, String errorMessage) {
        if (tryValidateGreater(d, val)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreater(double d, double val) {
        return d > val;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @return the short when valid
     */
    public static short validateGreaterOrEqual(short s, short val) {
        return validateGreaterOrEqual(s, val,
                ERROR_PREFIX + s + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateGreaterOrEqual(short s, short val, String errorMessage) {
        if (tryValidateGreaterOrEqual(s, val)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(short s, short val) {
        return s >= val;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @return the byte when valid
     */
    public static byte validateGreaterOrEqual(byte b, byte val) {
        return validateGreaterOrEqual(b, val,
                ERROR_PREFIX + b + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateGreaterOrEqual(byte b, byte val, String errorMessage) {
        if (tryValidateGreaterOrEqual(b, val)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(byte b, byte val) {
        return b >= val;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @return the integer when valid
     */
    public static int validateGreaterOrEqual(int i, int val) {
        return validateGreaterOrEqual(i, val,
                ERROR_PREFIX + i + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateGreaterOrEqual(int i, int val, String errorMessage) {
        if (tryValidateGreaterOrEqual(i, val)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(int i, int val) {
        return i >= val;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @return the long when valid
     */
    public static long validateGreaterOrEqual(long l, long val) {
        return validateGreaterOrEqual(l, val,
                ERROR_PREFIX + l + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateGreaterOrEqual(long l, long val, String errorMessage) {
        if (tryValidateGreaterOrEqual(l, val)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(long l, long val) {
        return l >= val;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @return the float when valid
     */
    public static float validateGreaterOrEqual(float f, float val) {
        return validateGreaterOrEqual(f, val,
                ERROR_PREFIX + f + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateGreaterOrEqual(float f, float val, String errorMessage) {
        if (tryValidateGreaterOrEqual(f, val)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(float f, float val) {
        return f >= val;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @return the double when valid
     */
    public static double validateGreaterOrEqual(double d, double val) {
        return validateGreaterOrEqual(d, val,
                ERROR_PREFIX + d + " is not greater than or equal to" + val + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param val the value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateGreaterOrEqual(double d, double val, String errorMessage) {
        if (tryValidateGreaterOrEqual(d, val)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param val the value to validate with
     * @return true when valid
     */
    public static boolean tryValidateGreaterOrEqual(double d, double val) {
        return d >= val;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the short when valid
     */
    public static short validateBetween(short s, short lo, short hi) {
        return validateBetween(s, lo, hi,
                ERROR_PREFIX + s + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateBetween(short s, short lo, short hi, String errorMessage) {
        if (tryValidateBetween(s, lo, hi)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(short s, short lo, short hi) {
        return s > lo && s < hi;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the byte when valid
     */
    public static byte validateBetween(byte b, byte lo, byte hi) {
        return validateBetween(b, lo, hi,
                ERROR_PREFIX + b + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateBetween(byte b, byte lo, byte hi, String errorMessage) {
        if (tryValidateBetween(b, lo, hi)) return b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(byte b, byte lo, byte hi) {
        return b > lo && b < hi;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the integer when valid
     */
    public static int validateBetween(int i, int lo, int hi) {
        return validateBetween(i, lo, hi,
                ERROR_PREFIX + i + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateBetween(int i, int lo, int hi, String errorMessage) {
        if (tryValidateBetween(i, lo, hi)) return i;
       else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(int i, int lo, int hi) {
        return i > lo && i < hi;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the long when valid
     */
    public static long validateBetween(long l, long lo, long hi) {
        return validateBetween(l, lo, hi,
                ERROR_PREFIX + l + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateBetween(long l, long lo, long hi, String errorMessage) {
        if (tryValidateBetween(l, lo, hi)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(long l, long lo, long hi) {
        return l > lo && l < hi;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the float when valid
     */
    public static float validateBetween(float f, float lo, float hi) {
        return validateBetween(f, lo, hi,
                ERROR_PREFIX + f + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateBetween(float f, float lo, float hi, String errorMessage) {
        if (tryValidateBetween(f, lo, hi)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(float f, float lo, float hi) {
        return f > lo && f < hi;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the double when valid
     */
    public static double validateBetween(double d, double lo, double hi) {
        return validateBetween(d, lo, hi,
                ERROR_PREFIX + d + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateBetween(double d, double lo, double hi, String errorMessage) {
        if (tryValidateBetween(d, lo, hi)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetween(double d, double lo, double hi) {
        return d > lo && d < hi;
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the short when valid
     */
    public static short validateBetweenIncluding(short s, short lo, short hi) {
        return validateBetweenIncluding(s, lo, hi,
                ERROR_PREFIX + s + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a short when it's valid.
     * @param s the short to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the short when valid
     */
    public static short validateBetweenIncluding(short s, short lo, short hi, String errorMessage) {
        if (tryValidateBetweenIncluding(s, lo, hi)) return s;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a short.
     * @param s the short to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetweenIncluding(short s, short lo, short hi) {
        return s >= lo && s <= hi;
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the byte when valid
     */
    public static byte validateBetweenIncluding(byte b, byte lo, byte hi) {
        return validateBetweenIncluding(b, lo, hi,
                ERROR_PREFIX + b + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a byte when it's valid.
     * @param b the byte to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the byte when valid
     */
    public static byte validateBetweenIncluding(byte b, byte lo, byte hi, String errorMessage) {
        if (tryValidateBetweenIncluding(b, lo, hi)) return  b;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a byte.
     * @param b the byte to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetweenIncluding(byte b, byte lo, byte hi) {
        return b >= lo && b <= hi;
    }

    /**
     * Validates and returns an integer when it's valid.
     * @param i the integer to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the integer when valid
     */
    public static int validateBetweenIncluding(int i, int lo, int hi) {
        return validateBetweenIncluding(i, lo, hi,
                ERROR_PREFIX + i + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns an integer whent it's valid.
     * @param i the integer to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the integer when valid
     */
    public static int validateBetweenIncluding(int i, int lo, int hi, String errorMessage) {
        if (tryValidateBetweenIncluding(i, lo, hi)) return i;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of an integer.
     * @param i the integer to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when walid
     */
    public static boolean tryValidateBetweenIncluding(int i, int lo, int hi) {
        return i >= lo && i <= hi;
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the long when valid
     */
    public static long validateBetweenIncluding(long l, long lo, long hi) {
        return validateBetweenIncluding(l, lo, hi,
                ERROR_PREFIX + l + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a long when it's valid.
     * @param l the long to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the long when valid
     */
    public static long validateBetweenIncluding(long l, long lo, long hi, String errorMessage) {
        if (tryValidateBetweenIncluding(l, lo, hi)) return l;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a long.
     * @param l the long to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetweenIncluding(long l, long lo, long hi) {
        return l >= lo && l <= hi;
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the float when valid
     */
    public static float validateBetweenIncluding(float f, float lo, float hi) {
        return validateBetweenIncluding(f, lo, hi,
                ERROR_PREFIX + f + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a float when it's valid.
     * @param f the float to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the float when valid
     */
    public static float validateBetweenIncluding(float f, float lo, float hi, String errorMessage) {
        if (tryValidateBetweenIncluding(f, lo, hi)) return f;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a float.
     * @param f the float to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetweenIncluding(float f, float lo, float hi) {
        return f >= lo && f <= hi;
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return the double when valid
     */
    public static double validateBetweenIncluding(double d, double lo, double hi) {
        return validateBetweenIncluding(d, lo, hi,
                ERROR_PREFIX + d + " is not between " + lo + " and " + hi + ".");
    }

    /**
     * Validates and returns a double when it's valid.
     * @param d the double to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @param errorMessage the error message
     * @return the double when valid
     */
    public static double validateBetweenIncluding(double d, double lo, double hi, String errorMessage) {
        if (tryValidateBetweenIncluding(d, lo, hi)) return d;
        else throw new IllegalArgumentException(errorMessage);
    }

    /**
     * Returns true on a successful validation of a double.
     * @param d the double to try to validate
     * @param lo the lower value to validate with
     * @param hi the upper value to validate with
     * @return true when valid
     */
    public static boolean tryValidateBetweenIncluding(double d, double lo, double hi) {
        return d >= lo && d <= hi;
    }
}
