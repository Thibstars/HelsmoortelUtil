/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

import be.thibaulthelsmoortel.helsmoortelUtil.util.validation.Validator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Class representing a cashier.
 *
 * @author Thibault Helsmoortel
 */
public class Cashier {
    private UUID cashierUUID;
    private String name;
    private String passwordHash;

    /**
     * Constructor setting the cashier's name and password.
     *
     * @param name     the cashier's name
     * @param password the cashier's password
     */
    public Cashier(String name, String password) {
        this.cashierUUID = UUID.randomUUID();
        this.name = (String) Validator.validateNotNull(name, "Name can't be null");

        try {
            this.passwordHash = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Encrypts a password with MD5 and transforms it to a String hash of the password.
     *
     * @param password the password to hash
     * @return the hash value in the form of a String
     * @throws NoSuchAlgorithmException
     */
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        String pass = (String) Validator.validateNotNull(password, "Password can't be null.");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] data = pass.getBytes();
        md.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, md.digest());
        return i.toString(16);
    }

    /**
     * Returns the chashier's UUID.
     *
     * @return the cashier's UUID
     */
    public UUID getCashierUUID() {
        return cashierUUID;
    }

    /**
     * Returns the cashier's name.
     *
     * @return the cashier's name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cashier)) return false;

        Cashier cashier = (Cashier) o;

        if (!cashierUUID.equals(cashier.cashierUUID)) return false;
        if (!name.equals(cashier.name)) return false;
        return passwordHash.equals(cashier.passwordHash);

    }

    @Override
    public int hashCode() {
        int result = cashierUUID.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + passwordHash.hashCode();
        return result;
    }
}
