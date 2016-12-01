/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package globalization;

import be.thibaulthelsmoortel.helsmoortelUtil.globalization.LanguageManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test case for LanguageManager.
 *
 * @author Thibault Helsmoortel
 */

public class LanguageManagerTests {

    private static final Logger LOGGER = Logger.getLogger(LanguageManagerTests.class);
    private static LanguageManager languageManager;
    private static List<String> stringKeys;

    @BeforeClass
    public static void init() {
        languageManager = LanguageManager.getInstance();
        stringKeys = new ArrayList<>();
        stringKeys.add("test");
        stringKeys.add("yes");
        stringKeys.add("no");
    }

    /**
     * Tests whether all translations exist.
     *
     * @throws IllegalAccessException when a key could not be accessed
     */
    @Test
    public void shouldGetStringForStringKey() throws IllegalAccessException {
        checkAllTranslations();
    }

    private void checkAllTranslations() throws IllegalAccessException {
        //Test every StringKey using reflection:
        //get all the StringKey fields, test their respective values
        for (String key : stringKeys) {
            LOGGER.debug("Testing string key: " + key);
            assertNotNull(languageManager.translate(key));
        }
    }

    /**
     * Tests whether the language is properly changed.
     *
     * @throws IllegalAccessException when a key could not be accessed
     */
    @Test
    public void shouldChangeLanguage() throws IllegalAccessException {
        //Set a language first, so we are sure that we have actually changed it
        //(by default the user's system language is set)
        languageManager.setLocale(new Locale("nl"));
        languageManager.setLocale(Locale.ENGLISH);
        checkAllTranslations();
        assertEquals(Locale.ENGLISH, languageManager.getLocale());
    }
}
