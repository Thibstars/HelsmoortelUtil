/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for creating and getting session identifiers.
 */
public final class SessionIdentifierGenerator {
    private SecureRandom random = new SecureRandom();

    /**
     * Creates a new session identifier and returns it as a String.
     * @return the newly created session identifier
     */
    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}