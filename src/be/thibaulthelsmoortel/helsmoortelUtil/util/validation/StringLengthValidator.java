/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.validation;

/**
 * Class for validating Strings on their lengths.
 *
 * @author Thibault Helsmoortel
 */
public class StringLengthValidator extends ValidationObject {

    private String string;
    private int minLength, maxLength;

    /**
     * Constructor initializing string, minLength and maxLength.
     *
     * @param string    the String to use in the validator for validation
     * @param minLength the minimum string length
     * @param maxLength the maximum string length
     */
    public StringLengthValidator(String string, int minLength, int maxLength) {
        this.string = string;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * Returns the minimum length of the string.
     *
     * @return the minimum length of the string
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the minimum length of the string.
     *
     * @param minLength the new minimum length of the string
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * Returns the maximum length of the string.
     *
     * @return the maximum length of the string
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the maximum length of the string.
     *
     * @param maxLength the new maximum length of the string
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Validates the string on minimum length, returns the string when valid.
     *
     * @return the string when valid
     */
    public String validateMinLength() {
        return Validator.validateMinLength(string, minLength);
    }

    /**
     * Validates the string on minimum length, returns the string when valid.
     *
     * @param errorMessage the custom message to pass to the exception
     * @return the string when valid
     */
    public String validateMinlength(String errorMessage) {
        return Validator.validateMinLength(string, minLength, errorMessage);
    }

    /**
     * Returns true when the string is valid based on it's minimum length.
     *
     * @return true when valid
     */
    public boolean tryValidateMinLength() {
        return Validator.tryValidateMinLength(string, minLength);
    }

    /**
     * Validates the string on maximum length, returns the string when valid.
     *
     * @return the string when valid
     */
    public String validateMaxLength() {
        return Validator.validateMaxLength(string, maxLength);
    }

    /**
     * Validates the string on maximum length, returns the string when valid.
     *
     * @param errorMessage the custom message to pass to the exception
     * @return the string when valid
     */
    public String validateMaxlength(String errorMessage) {
        return Validator.validateMaxLength(string, maxLength, errorMessage);
    }

    /**
     * Returns true when the string is valid based on it's maximum length.
     *
     * @return true when valid
     */
    public boolean tryValidateMaxLength() {
        return Validator.tryValidateMaxLength(string, maxLength);
    }

    @Override
    public Object validate() {
        return Validator.validateLength(string, minLength, maxLength);
    }

    @Override
    public Object validate(String errorMessage) {
        return Validator.validateLength(string, minLength, maxLength, errorMessage);
    }

    @Override
    public boolean tryValidate() {
        return Validator.tryValidateLength(string, minLength, maxLength);
    }
}
