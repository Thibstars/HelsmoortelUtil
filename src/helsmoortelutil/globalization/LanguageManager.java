/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.globalization;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Singleton class managing languages.
 */
public class LanguageManager {
    private static LanguageManager LanguageManager = new LanguageManager();
    private static Locale locale;
    private static String resourceBundleBaseName;
    private static HashMap<String, String> textMap;

    /**
     * Publicly unavailable constructor.
     */
    private LanguageManager() {
        resourceBundleBaseName = "LanguageBundle";
        locale = new Locale(System.getProperty("user.language"));
        textMap = new HashMap<>();
        setTextAccordingToLanguage();
    }

    /**
     * Method to set the current language to.
     * @param locale language to set.
     */
    public static void setLanguage(Locale locale) {
        LanguageManager.locale = locale;
        setTextAccordingToLanguage();
    }

    /**
     * Method to set the ResourceBundle's base name.
     * This is an essential method since all drawText is fetched from files with this base name.
     * @param baseName the ResourceBundle's base name.
     */
    public static void setResourceBundleBaseName(String baseName) {
        resourceBundleBaseName = baseName;
        setTextAccordingToLanguage();
    }

    /**
     * Method initialising the HashMap containing all keys and values of the ResourceBundle.
     */
    private static void setTextAccordingToLanguage() {
        //Get the right bundle and place all the drawText in the HashMap
        ResourceBundle language = ResourceBundle.getBundle(resourceBundleBaseName, locale);
        Enumeration bundleKeys = language.getKeys();

        while (bundleKeys.hasMoreElements()) {
            String key = (String)bundleKeys.nextElement();
            String value = language.getString(key);
            textMap.put(key, value);
        }
    }

    /**
     * Main method of this class. Fetches the correct String from the HashMap using a key.
     * @param key the key String to find the value of.
     * @return the String that has been searched for, fetched from the HashMap.
     */
    public static String getString(String key) {
        return textMap.get(key);
    }

    public synchronized static LanguageManager getInstance() {
        return LanguageManager;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException();
    }
}
