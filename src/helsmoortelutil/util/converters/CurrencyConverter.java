/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.converters;


import helsmoortelutil.util.economy.Currency;
import helsmoortelutil.util.economy.Currency.CurrencyCode;
import helsmoortelutil.util.economy.CurrencyFactory;

import java.math.BigDecimal;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting currency values with Euro (EUR) as base currency.
 */

public class CurrencyConverter {

    /**
     * Principal method of the conversion class.
     * Converts and returns a BigDecimal value based on source and target currencies.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @param target the ISO code of the target currency
     * @return the converted value from the source currency to the target currency
     */
    public static BigDecimal convert(BigDecimal value, CurrencyCode source, CurrencyCode target) {
        double srcRate = CurrencyFactory.getCurrencyByCode(source).getRate();
        double trgtRate = CurrencyFactory.getCurrencyByCode(target).getRate();

        return value.divide(BigDecimal.valueOf(srcRate), 10, BigDecimal.ROUND_CEILING)
                .multiply(BigDecimal.valueOf(trgtRate));
    }

    /**
     * Overload conversion method to support custom currencies.
     * Converts and returns a BigDecimal value based on source and target currencies.
     * @param value the value of the source currency
     * @param source the source currency
     * @param target the target currency
     * @return the converted value from the source currency to the target currency
     */
    public static BigDecimal convert(BigDecimal value, Currency source, Currency target){
        return value.divide(BigDecimal.valueOf(source.getRate()), 10, BigDecimal.ROUND_CEILING)
                .multiply(BigDecimal.valueOf(target.getRate()));
    }

    //region Currency specific converters

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to AUD
     */
    public static BigDecimal toAUD(BigDecimal value, CurrencyCode source){
        return convert(value, source, CurrencyCode.AUD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to AUD
     */
    public static BigDecimal toAUD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.AUD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to BGN
     */
    public static BigDecimal toBGN(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.BGN);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to BGN
     */
    public static BigDecimal toBGN(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.BGN));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to BRL
     */
    public static BigDecimal toBRL(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.BRL);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to BRL
     */
    public static BigDecimal toBRL(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.BRL));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to CAD
     */
    public static BigDecimal toCAD(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.CAD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to CAD
     */
    public static BigDecimal toCAD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.CAD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to CHF
     */
    public static BigDecimal toCHF(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.CHF);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to CHF
     */
    public static BigDecimal toCHF(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.CHF));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to CNY
     */
    public static BigDecimal toCNY(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.CNY);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to CNY
     */
    public static BigDecimal toCNY(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.CNY));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to CZK
     */
    public static BigDecimal toCZK(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.CZK);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to CZK
     */
    public static BigDecimal toCZK(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.CZK));
    }
    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to DKK
     */
    public static BigDecimal toDKK(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.DKK);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to DKK
     */
    public static BigDecimal toDKK(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.DKK));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to EUR
     */
    public static BigDecimal toEUR(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.EUR);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to EUR
     */
    public static BigDecimal toEUR(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.EUR));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to GBP
     */
    public static BigDecimal toGBP(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.GBP);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to GBP
     */
    public static BigDecimal toGBP(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.GBP));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to HKD
     */
    public static BigDecimal toHKD(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.HKD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to HKD
     */
    public static BigDecimal toHKD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.HKD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to HRK
     */
    public static BigDecimal toHRK(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.HRK);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to HRK
     */
    public static BigDecimal toHRK(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.HRK));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to HUF
     */
    public static BigDecimal toHUF(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.HUF);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to HUF
     */
    public static BigDecimal toHUF(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.HUF));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to IDR
     */
    public static BigDecimal toIDR(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.IDR);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to IDR
     */
    public static BigDecimal toIDR(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.IDR));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to ILS
     */
    public static BigDecimal toILS(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.ILS);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to ILS
     */
    public static BigDecimal toILS(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.ILS));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to INR
     */
    public static BigDecimal toINR(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.INR);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to INR
     */
    public static BigDecimal toINR(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.INR));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to JPY
     */
    public static BigDecimal toJPY(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.JPY);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to JPY
     */
    public static BigDecimal toJPY(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.JPY));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to KRW
     */
    public static BigDecimal toKRW(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.KRW);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to KRW
     */
    public static BigDecimal toKRW(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.KRW));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to MXN
     */
    public static BigDecimal toMXN(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.MXN);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to MXN
     */
    public static BigDecimal toMXN(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.MXN));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to MYR
     */
    public static BigDecimal toMYR(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.MYR);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to MYR
     */
    public static BigDecimal toMYR(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.MYR));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to NOK
     */
    public static BigDecimal toNOK(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.NOK);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to NOK
     */
    public static BigDecimal toNOK(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.NOK));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to NZD
     */
    private static BigDecimal toNZD(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.NZD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to NZD
     */
    public static BigDecimal toNZD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.NZD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to PHP
     */
    public static BigDecimal toPHP(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.PHP);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to PHP
     */
    public static BigDecimal toPHP(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.PHP));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to PLN
     */
    public static BigDecimal toPLN(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.PLN);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to PLN
     */
    public static BigDecimal toPLN(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.PLN));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to RON
     */
    public static BigDecimal toRON(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.RON);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to RON
     */
    public static BigDecimal toRON(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.RON));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to RUB
     */
    public static BigDecimal toRUB(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.RUB);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to RUB
     */
    public static BigDecimal toRUB(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.RUB));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to SEK
     */
    public static BigDecimal toSEK(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.SEK);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to SEK
     */
    public static BigDecimal toSEK(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.SEK));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to SGD
     */
    public static BigDecimal toSGD(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.SGD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to SGD
     */
    public static BigDecimal toSGD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.SGD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to THB
     */
    public static BigDecimal toTHB(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.THB);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to THB
     */
    public static BigDecimal toTHB(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.THB));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to TRY
     */
    public static BigDecimal toTRY(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.TRY);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to TRY
     */
    public static BigDecimal toTRY(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.TRY));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to USD
     */
    public static BigDecimal toUSD(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.USD);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to USD
     */
    public static BigDecimal toUSD(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.USD));
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @return the converted value from the source currency to ZAR
     */
    public static BigDecimal toZAR(BigDecimal value, CurrencyCode source) {
        return convert(value, source, CurrencyCode.ZAR);
    }

    /**
     * Converts and returns a BigDecimal value based on source currency.
     * @param value the value of the source currency
     * @param source the source currency
     * @return the converted value from the source currency to ZAR
     */
    public static BigDecimal toZAR(BigDecimal value, Currency source) {
        return convert(value, source, CurrencyFactory.getCurrencyByCode(CurrencyCode.ZAR));
    }

    //endregion
}
