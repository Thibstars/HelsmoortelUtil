/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.converters.helpers;

/**
 * Class used to represent currencies
 *
 * @author Thibault Helsmoortel
 */
public class Currency {

    private final String name;
    private final double rate;

    /**
     * Default constructor
     *
     * @param name the name of the currency
     * @param rate the rate of the currency
     */
    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    /**
     * Returns the name of the currency.
     *
     * @return the name of the currency
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the rate of the currency.
     *
     * @return the rate of the currency
     */
    public double getRate() {
        return rate;
    }

    /**
     * Returns a representation of the currency.
     *
     * @return a representation of the currency
     */
    @Override
    public String toString() {
        return "Currency: " + name + " - Rate: " + rate;
    }

    //ISO codes of supported currencies
    public enum CurrencyCode {
        AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, JPY, KRW, MXN, MYR, NOK, NZD,
        PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR
    }

}