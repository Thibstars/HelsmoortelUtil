/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Class for conversions with collections.
 *
 * @author Thibault Helsmoortel
 */
public class CollectionConverter {

    /**
     * Converts an array to an existing collection.
     *
     * @param array      the array to convert
     * @param collection the destination collection
     * @param <T>        the type used
     */
    public static <T> void toCollection(T[] array, Collection<T> collection) {
        Collections.addAll(collection, array);
    }

    /**
     * Converts a collection into an array and returns the array.
     *
     * @param collection the collection to convert
     * @param <T>        the type used
     * @return the array result from the conversion
     */
    public static <T> T[] toArray(Collection<T> collection) {
        return (T[]) collection.toArray();
    }

    /**
     * Converts a collection into an ArrayList and returns the ArrayList.
     *
     * @param collection the collection to convert
     * @param <T>        the type used
     * @return the ArrayList result from the conversion
     */
    public static <T> ArrayList<T> toArrayList(Collection<T> collection) {
        ArrayList<T> arrayList = new ArrayList<>(collection.size());
        for (T object : collection) {
            arrayList.add(object);
        }
        return arrayList;
    }

    //TODO implement more methods
}
