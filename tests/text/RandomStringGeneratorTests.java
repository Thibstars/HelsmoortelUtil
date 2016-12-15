/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package text;

import be.thibaulthelsmoortel.helsmoortelUtil.util.text.RandomStringGenerator;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for LanguageManager.
 *
 * @author Thibault Helsmoortel
 */
public class RandomStringGeneratorTests {

    private static final Logger LOGGER = Logger.getLogger(RandomStringGeneratorTests.class);

    /**
     * Tests whether a random String is properly returned.
     */
    @Test
    public void shouldReturnRandomString() {
        String random = RandomStringGenerator.randomString(75);
        assertEquals(75, random.length());
        assertFalse(random.isEmpty());
        logString(random);
    }

    /**
     * Tests whether a random alphanumeric String is properly returned.
     */
    @Test
    public void shouldReturnAlphaNumericString() {
        String pattern = "^[\\p{L}0-9]*$";
        String random = RandomStringGenerator.randomAlphaNumericString(50);
        assertTrue(random.matches(pattern));
        logString(random);
    }

    /**
     * Tests whether a random numeric String is properly returned.
     */
    @Test
    public void shouldReturnNumericString() {
        String pattern = "\\d+";
        String random = RandomStringGenerator.randomNumericString(25);
        assertTrue(random.matches(pattern));
        logString(random);
    }

    private void logString(String random) {
        LOGGER.debug("Generated String: \n" + random);
    }
}
