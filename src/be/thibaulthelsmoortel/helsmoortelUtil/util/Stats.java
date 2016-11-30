/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util;

/**
 * @author Thibault Helsmoortel
 */

public final class Stats {

    /**
     * Unavailable constructor
     */
    private Stats() {
    }

    /**
     * Returns the maximum value in the array a[], -infinity if no such value.
     * @param a array of double values
     * @return the maximum value of the given array
     */
    public static double max(double[] a) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    /**
     * Returns the maximum value in the subarray a[lo..hi], -infinity if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return the maximum value of the given array
     */
    public static double max(double[] a, int lo, int hi) {
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        double max = Double.NEGATIVE_INFINITY;
        for (int i = lo; i <= hi; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    /**
     * Returns the maximum value in the array a[], Integer.MIN_VALUE if no such value.
     * @param a array of integer values
     * @return the maximum value of the given array
     */
    public static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    /**
     * Returns the minimum value in the array a[], +infinity if no such value.
     * @param a array of double values
     * @return the minimum value of the given array
     */
    public static double min(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    /**
     * Returns the minimum value in the subarray a[lo..hi], +infinity if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return the minimum value of the given array
     */
    public static double min(double[] a, int lo, int hi) {
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; i++) {
            if (Double.isNaN(a[i])) return Double.NaN;
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    /**
     * Returns the minimum value in the array a[], Integer.MAX_VALUE if no such value.
     * @param a array of integer values
     * @return the minimum value of the given array
     */
    public static int min(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    /**
     * Returns the average value in the array a[], NaN if no such value.
     * @param a array of double values
     * @return the average value in the array
     */
    public static double mean(double[] a) {
        if (a.length == 0) return Double.NaN;
        double sum = sum(a);
        return sum / a.length;
    }

    /**
     * Returns the average value in the subarray a[lo..hi], NaN if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return the average value in the array
     */
    public static double mean(double[] a, int lo, int hi) {
        int length = hi - lo + 1;
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        if (length == 0) return Double.NaN;
        double sum = sum(a, lo, hi);
        return sum / length;
    }

    /**
     * Returns the average value in the array a[], NaN if no such value.
     * @param a array of integer values
     * @return the average value in the array
     */
    public static double mean(int[] a) {
        if (a.length == 0) return Double.NaN;
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

    /**
     * Returns the sample variance in the array a[], NaN if no such value
     * @param a array of double values
     * @return sample variance in the array
     */
    public static double var(double[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }
    /**
     * Returns the sample variance in the subarray a[lo..hi], NaN if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return sample variance in the array
     */
    public static double var(double[] a, int lo, int hi) {
        int length = hi - lo + 1;
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        if (length == 0) return Double.NaN;
        double avg = mean(a, lo, hi);
        double sum = 0.0;
        for (int i = lo; i <= hi; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (length - 1);
    }

    /**
     * Returns the sample variance in the array a[], NaN if no such value.
     * @param a array of integer values
     * @return sample variance in the array
     */
    public static double var(int[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (a.length - 1);
    }

    /**
     * Returns the population variance in the array a[], NaN if no such value.
     * @param a array of double values
     * @return population variance in the array
     */
    public static double varp(double[] a) {
        if (a.length == 0) return Double.NaN;
        double avg = mean(a);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / a.length;
    }

    /**
     * Returns the population variance in the subarray a[lo..hi], NaN if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return population variance in the array
     */
    public static double varp(double[] a, int lo, int hi) {
        int length = hi - lo + 1;
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        if (length == 0) return Double.NaN;
        double avg = mean(a, lo, hi);
        double sum = 0.0;
        for (int i = lo; i <= hi; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / length;
    }

    /**
     * Returns the sample standard deviation in the array a[], NaN if no such value.
     * @param a array of double values
     * @return sample standar ddeviation in the array
     */
    public static double stddev(double[] a) {
        return java.lang.Math.sqrt(var(a));
    }
    /**
     * Returns the sample standard deviation in the subarray a[lo..hi], NaN if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return sample standard deviation in the array
     */
    public static double stddev(double[] a, int lo, int hi) {
        return java.lang.Math.sqrt(var(a, lo, hi));
    }

    /**
     * Returns the sample standard deviation in the array a[], NaN if no such value.
     * @param a array of integer values
     * @return sample standard deviation in the array
     */
    public static double stddev(int[] a) {
        return java.lang.Math.sqrt(var(a));
    }

    /**
     * Returns the population standard deviation in the array a[], NaN if no such value.
     * @param a array of double values
     * @return population standard deviation in the array
     */
    public static double stddevp(double[] a) {
        return java.lang.Math.sqrt(varp(a));
    }

    /**
     * Returns the population standard deviation in the subarray a[lo..hi], NaN if no such value.
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return population standard deviation in the array
     */
    public static double stddevp(double[] a, int lo, int hi) {
        return java.lang.Math.sqrt(varp(a, lo, hi));
    }

    /**
     * Returns the sum of all values in the array a[].
     * @param a array of double values
     * @return sum of all values in the array
     */
    public static double sum(double[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     *  Returns the sum of all values in the subarray a[lo..hi].
     * @param a array of double values
     * @param lo index of the first item in the array
     * @param hi index of the last item in the array
     * @return sum of all values in the array
     */
    public static double sum(double[] a, int lo, int hi) {
        if (lo < 0 || hi >= a.length || lo > hi)
            throw new RuntimeException("Subarray indices out of bounds");
        double sum = 0.0;
        for (int i = lo; i <= hi; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     * Returns the sum of all values in the array a[].
     * @param a array of integer values
     * @return sum of all values in the array
     */
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
