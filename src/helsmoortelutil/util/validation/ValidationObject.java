/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.validation;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Abstract class representing an Object that supports validation.
 */
public abstract class ValidationObject implements Validateable {

    @Override
    public Object validate() {
        throw new NotImplementedException();
    }

    @Override
    public Object validate(String errorMessage) {
        throw new NotImplementedException();
    }

    @Override
    public boolean tryValidate() {
        throw new NotImplementedException();
    }
}
