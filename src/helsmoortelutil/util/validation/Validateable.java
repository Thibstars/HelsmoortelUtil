/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.validation;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Interface supporting validation.
 */
public interface Validateable {

    /**
     * Validates and returns an Object.
     * @return an Object
     */
     Object validate();

    /**
     * Validates and returns an Object, takes an error message.
     * @param errorMessage the error message
     * @return an Object
     */
     Object validate(String errorMessage);

    /**
     * Returns true when valid.
     * @return true when valid
     */
    boolean tryValidate();
}
