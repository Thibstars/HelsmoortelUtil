/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for nullable objects.
 * @param <T> the type of the nullable object
 */
public class NullableObject<T> {
    private T nullableObject;
    private boolean isNull;

    /**
     * Default constructor setting the nullable object.
     * @param nullableObject the nullable object
     */
    public NullableObject(T nullableObject) {
        this.nullableObject = nullableObject;
        this.isNull = nullableObject == null;
    }

    /**
     * Returns the nullable object.
     * @return the nullable object
     */
    public T getNullableObject() {
        return nullableObject;
    }

    /**
     * Sets the nullable object.
     * @param nullableObject the new nullable object
     */
    public void setNullableObject(T nullableObject) {
        this.nullableObject = nullableObject;
        this.isNull = nullableObject == null;
    }

    /**
     * Returns true if the nullable object is null.
     * @return true if the nullable object is null.
     */
    public boolean isNull() {
        return isNull;
    }

    /**
     * Sets the nullable object to be null.
     */
    public void setNull() {
        this.nullableObject = null;
        this.isNull = true;
    }
}
