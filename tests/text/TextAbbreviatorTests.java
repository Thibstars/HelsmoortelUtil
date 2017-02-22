/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package text;

import be.thibaulthelsmoortel.helsmoortelUtil.util.text.TextAbbreviator;
import org.apache.log4j.Logger;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Test case for TextAbbreviator.
 *
 * @author Thibault Helsmoortel
 */
@RunWith(Theories.class)
public class TextAbbreviatorTests {

    private static final Logger LOGGER = Logger.getLogger(TextAbbreviatorTests.class);

    @DataPoints("inputs") public static String[] stringInputs = new String[] {
            "Hallo daar, alles goed? | van mij!",
            "Hey | from me",
            "I have a brown car my dear | no one cares", "These flowers are beautiful. | Louis De Funes",
            ".NET sucks | Java rules",
            "1 | 23456789123456789",
            "Ja | En dit stuk is eigenlijk veel te lang dan zou moeten",
            "Dit stuk is lang en zou afgekapt moeten worden | ok keirel, good for you",
            "Hello World!",
            "Hello | World!",
            "| Bananas",
            "| Hello | Hi | Hey | What's up?",
            "Hallo hallo hallo hallo hallo hallo"
    };

    /**
     * Tests whether a String is properly abbreviated.
     *
     * @param s the String to abbreviate
     */
    @Theory
    public void shouldProperlyAbbreviate(@FromDataPoints("inputs") String s) {
        int maxLength = 20;
        String result = TextAbbreviator.abbreviateWithImportantEnding(s, maxLength);
        LOGGER.debug(String.format("%-" + (maxLength + 5) + "s %s", result, "Length: " + result.length()));
        assertTrue("Result must not be shorter than or equal to " + maxLength,result.length() <= maxLength);
    }
}
