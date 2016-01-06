/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.converters;


/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting length measurements.
 */

public class LengthConverter {
    public enum Unit{
        INCH, FOOT, MILE, MILLIMETRE, CENTIMETRE, KILOMETRE, YARD
    }

    private static final double INCH_TO_METRE = 0.0254;
    private static final double FOOT_TO_METRE = 0.3048;
    private static final double MILE_TO_METRE = 1609.344;
    private static final double MM_TO_METRE = 0.001;
    private static final double CM_TO_METRE = 0.01;
    private static final double KM_TO_METRE = 1000;
    private static final double YD_TO_METRE = 0.914;

    private static double factor;

    /**
     * Converts a measurement to metres.
     * @param measurement the measurement to convert
     * @param unit the unit to convert from
     * @return the equivalent metres
     */
    public static double toMetres(double measurement, Unit unit) {
        findFactor(unit);
        return measurement * factor;
    }

    /**
     * Converts a measurement from metres.
     * @param measurement the measurement to convert
     * @param unit the unit to convert to
     * @return the equivalent value in the given unit
     */
    public static double fromMetres(double measurement, Unit unit) {
        findFactor(unit);
        return measurement / factor;
    }

    /**
     * Finds and sets the correct factor for the given unit.
     * @param unit the unit to find and set the factor for
     */
    private static void findFactor(Unit unit) {
        switch (unit) {
            case INCH:
                factor = INCH_TO_METRE;
                break;
            case FOOT:
                factor = FOOT_TO_METRE;
                break;
            case MILE:
                factor = MILE_TO_METRE;
                break;
            case MILLIMETRE:
                factor = MM_TO_METRE;
                break;
            case CENTIMETRE:
                factor = CM_TO_METRE;
                break;
            case KILOMETRE:
                factor = KM_TO_METRE;
                break;
            case YARD:
                factor = YD_TO_METRE;
                break;
        }
    }
}
