package be.thibaulthelsmoortel.helsmoortelUtil.globalization;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class that has the responsibility to provide correct application text based on the set locale.
 *
 * @author Thibault Helsmoortel
 */

public final class LanguageManager {
    private static String base = "StringResources";
    private static LanguageManager classInstance = new LanguageManager();
    private static Locale locale = new Locale(System.getProperty("user.language"));
    private static ResourceBundle bundle = updateBundle(locale);

    /**
     * Class constructor. Publicly unavailable.
     */
    private LanguageManager() {
        //Constructor not publicly available
    }

    /**
     * Updates the resource bundle according to the given locale.
     *
     * @param switchLocale the locale for which to update the resource bundle
     * @return the updated resource bundle
     */
    private static ResourceBundle updateBundle(Locale switchLocale) {
        LanguageManager.locale = switchLocale;
        try {
            bundle = ResourceBundle.getBundle(base, LanguageManager.locale);
        } catch (MissingResourceException e) {
            LanguageManager.getInstance().setLocale(Locale.ENGLISH);
        } finally {
            bundle = ResourceBundle.getBundle(base, LanguageManager.locale);
        }
        return bundle;
    }

    /**
     * Returns an instance of the manager.
     *
     * @return an instance of the manager
     */
    public static synchronized LanguageManager getInstance() {
        if (bundle == null) {
            updateBundle(locale);
        }
        return classInstance;
    }

    /**
     * Returns a translated String based on a given key.
     *
     * @param key the key for which to find a translated String
     * @return the key's respective translated String
     */
    public String translate(String key) {
        if (!bundle.containsKey(key)) throw new IllegalArgumentException("Key not found: " + key);
        return bundle.getString(key);
    }

    /**
     * Returns the manager's locale.
     *
     * @return the manager's locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Sets the manager's locale and updates the resource bundle accordingly.
     *
     * @param locale the manager's locale
     */
    public void setLocale(Locale locale) {
        updateBundle(locale);
    }

    /**
     * Returns the base name of the ResourceBundle to use.
     *
     * @return the base name of the ResourceBundle to use
     */
    public static String getBase() {
        return base;
    }

    /**
     * Sets the new base name of the ResourceBundle to use.
     *
     * @param base the new base name of the ResourceBundle to use
     */
    public static void setBase(String base) {
        LanguageManager.base = base;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException();
    }
}
