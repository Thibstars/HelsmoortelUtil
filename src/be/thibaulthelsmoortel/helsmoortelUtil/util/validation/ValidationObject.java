/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.validation;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Abstract class representing an Object that supports validation.
 *
 * @author Thibault Helsmoortel
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
