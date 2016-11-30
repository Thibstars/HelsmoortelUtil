/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class containing basic and advanced counting features.
 */
public class Counter {
    //Error messages
    private static final String ERROR_BOUNDS = "Counter bounds exceeded!";
    public static final String ERROR_COUNT = "Count should be between minVal and maxVal!";
    public static final String ERROR_MIN_VAL = "Minimum value should be equal to or smaller than the initial count!";
    public static final String ERROR_MAX_VAL = "Maximum value should be equal to or greater than the initial count!";
    public static final String ERROR_VAL = "Value should be between minimum and maximum values!";
    public static final String ERROR__RESET = "Reset count must be between minVal and maxVal!";

    //The initial count the Counter was set to
    private int initialCount;
    //The main counter
    private int count;
    //Default in- or decrement value
    private int hop;
    //Minimum and maximum values
    private int minVal, maxVal;

    /**
     * Default constructor. Puts the initial count on 0 (like a regular Integer), the hop on 1 and
     * minimum and maximum values of Integers.
     */
    public Counter() {
        this.initialCount = 0;
        this.count = initialCount;
        this.hop = 1;
        this.minVal = Integer.MIN_VALUE;
        this.maxVal = Integer.MAX_VALUE;
    }

    /**
     * Constructor to create a counter that starts from a set count.
     * @param count the count to start from
     */
    public Counter(int count) {
        this.initialCount = count;
        this.count = initialCount;
        this.hop = 1;
        this.minVal = Integer.MIN_VALUE;
        this.maxVal = Integer.MAX_VALUE;
    }

    /**
     * Constructor to create a counter that starts from a set count and to set the size of hops.
     * @param count the count to start from
     * @param hop the default in- or decrement value
     */
    public Counter(int count, int hop) {
        this(count);
        this.hop = hop;
    }

    /**
     * Constructor to create a counter that starts from a set count, to set the size of hops and to set
     * minimum and maximum counter values.
     * @param count the count to start from
     * @param hop the default in- or decrement value
     * @param minVal the minimum value of the counter
     * @param maxVal the maximum value of the counter
     */
    public Counter(int count, int hop, int minVal, int maxVal) {
        this(count, hop);
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     * Returns the current count.
     * @return the current counter value
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count to a specific number.
     * @param count the new counter value
     */
    public void setCount(int count) {
        if (count >= minVal && count <= maxVal) this.count = count;
        else throw new IllegalArgumentException(ERROR_COUNT);
    }

    /**
     * Returns the initial count.
     * @return the initial counter value
     */
    public int getInitialCount() {
        return initialCount;
    }

    /**
     * Sets the initial count. Useful for the reset() method.
     * @param initialCount the initial counter value
     */
    public void setInitialCount(int initialCount) {
        if (initialCount >= minVal && initialCount <= maxVal) this.initialCount = initialCount;
        else throw new IllegalArgumentException(ERROR__RESET);
    }

    /**
     * Returns the default in- and decrement value.
     * @return the default in- and decrement value
     */
    public int getHop() {
        return hop;
    }

    /**
     * Sets the default in- and decrement value.
     * @param hop the default in- and decrement value
     */
    public void setHop(int hop) {
        this.hop = hop;
    }

    /**
     * Returns the minimum value of the counter.
     * @return the minimum value of the counter
     */
    public int getMinVal() {
        return minVal;
    }

    /**
     * Sets the minimum value of the counter.
     * @param minVal the minimum value of the counter
     */
    public void setMinVal(int minVal) {
        if(minVal <= initialCount) this.minVal = minVal;
        else throw new IllegalArgumentException(ERROR_MIN_VAL);
    }

    /**
     * Returns the maximum value of the counter.
     * @return the maximum value of the counter
     */
    public int getMaxVal() {
        return maxVal;
    }

    /**
     * Sets the maximum value of the counter.
     * @param maxVal the maximum value of the counter
     */
    public void setMaxVal(int maxVal) {
        if (maxVal >= initialCount) this.maxVal = maxVal;
        else throw new IllegalArgumentException(ERROR_MAX_VAL);
    }

    /**
     * Sets the minimum and maximum values of the counter.
     * @param minVal the minimum value of the counter
     * @param maxVal the maximum value of the counter
     */
    public void setMinAndMaxVal(int minVal, int maxVal) {
        setMinVal(minVal);
        setMaxVal(maxVal);
    }

    /**
     * Increments the counter (with the set hop value).
     *
     * Example: count = 5; hop = 1 (default hop value)
     * After method execution: count = 6 (similar to count++!)
     */
    public void increment() {
        if (count + hop >= minVal && count + hop <= maxVal) this.count += this.hop;
        else throw new IllegalArgumentException(ERROR_BOUNDS);
    }

    /**
     * Decrements the counter (with the set hop value).
     * Example: count = 5; hop = 1 (default hop value)
     * After method execution: count = 4 (similar to count--!)
     */
    public void decrement() {
        if (count - hop >= minVal && count - hop <= maxVal) this.count -= this.hop;
        else throw new IllegalArgumentException(ERROR_BOUNDS);
    }

    /**
     * Increments the counter and returns the new count.
     * @return the count after incrementing
     */
    public int incrementThenGet() {
        increment();
        return count;
    }

    /**
     * Decrements the counter and returns the new count.
     * @return the count after decrementing
     */
    public int decrementThenGet() {
        decrement();
        return count;
    }

    /**
     * Returns the count and increments it later.
     * @return the count before incrementing
     */
    public int getThenIncrement() {
        int temp = this.count;
        increment();
        return temp;
    }

    /**
     * Returns the count and decrements it later.
     * @return the count before decrementing
     */
    public int getThenDecrement() {
        int temp = this.count;
        decrement();
        return temp;
    }

    /**
     * Increments the counter with a given value (hop not used).
     * @param amount value to increment the counter with
     */
    public void incrementBy(int amount) {
        if (count + amount >= minVal && count + amount <= maxVal) this.count += amount;
        else throw new IllegalArgumentException(ERROR_BOUNDS);
    }

    /**
     * Decrements the counter with a given value (hop not used).
     * @param amount value to decrement the counter with
     */
    public void decrementBy(int amount) {
        if (count - amount >= minVal && count - amount <= maxVal) this.count -= amount;
        else throw new IllegalArgumentException(ERROR_BOUNDS);
    }

    /**
     * Increments the counter with a given value (hop not used) and returns the new count.
     * @param amount value to increment the counter with
     * @return the count after incrementing
     */
    public int incrementByThenGet(int amount) {
        incrementBy(amount);
        return count;
    }

    /**
     * Decrements the counter with a given value (hop not used) and returns the new count.
     * @param amount value to decrement the counter with
     * @return the count after decrementing
     */
    public int decrementByThenGet(int amount) {
        decrementBy(amount);
        return count;
    }

    /**
     * Returns the count and increments it with a given value (hop not used) later.
     * @param amount value to increment the counter with
     * @return the count before incrementing
     */
    public int getThenIncrementBy(int amount) {
        int temp =  this.count;
        incrementBy(amount);
        return temp;
    }

    /**
     * Returns the count and decrements it with a given value (hop not used) later.
     * @param amount value to decrement the counter with
     * @return the count before decrementing
     */
    public int getThenDecrementBy(int amount) {
        int temp = this.count;
        decrementBy(amount);
        return temp;
    }

    /**
     * Returns the distance from the current count to a given value.
     * @param value value to check the distance from
     * @return the distance from the current count to the given value
     */
    public int distanceToVal(int value) {
        int dist = 0;
        if (value >= minVal && value <= maxVal) dist = count >= value ? count - value : value - count;
        else throw new IllegalArgumentException(ERROR_VAL);
        return dist;
    }

    /**
     * Returns the distance from the current count to the minimum value.
     * @return the distance from the current count to the minimum value
     */
    public int distanceToMinVal() {
        return distanceToVal(minVal);
    }

    /**
     * Returns the distance from the current count to the maximum value.
     * @return the distance from the current count to the maximum value
     */
    public int distanceToMaxVal() {
        return distanceToVal(maxVal);
    }

    /**
     * Returns the current position of the counter as a percentage (where minVal = 0% and maxVal = 100%).
     * @return the current position of the counter as a percentage (where minVal = 0% and maxVal = 100%)
     */
    public float currentPosition() {
        long fullDist = minVal + maxVal;
        return (float) ((count * 100) / fullDist);
    }

    /**
     * Resets the counter to its initial count (0 by default).
     */
    public void reset() {
        this.count = initialCount;
    }

    /**
     * Resets the counter to a new value (does not change the initial count).
     * @param count the new counter value to reset the counter to
     */
    public void resetTo(int count) {
        if (count >= minVal && count <= maxVal) this.count = count;
        else throw new IllegalArgumentException(ERROR__RESET);
    }

    /**
     * Resets the counter to a new value. If the second parameter is true, the initial count will be changed
     * to this new value (if false, it doesn't).
     * @param count the new counter value to reset the counter to
     * @param initCount flag indicating whether to set the initial count or not
     */
    public void resetTo(int count, boolean initCount) {
        //If initCount is true, the initial count will be set to the new count
        // (if not, the regular resetTo() method will be used).
        if (initCount) setInitialCount(count);
        resetTo(count);
    }
}