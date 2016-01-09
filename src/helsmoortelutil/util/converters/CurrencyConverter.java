/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.converters;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting currency values with Euro (EUR) as base currency.
 */

public class CurrencyConverter {
    //ISO codes of supported currencies
    public enum CurrencyCode {
        AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EUR, GBP, HKD, HRK, HUF, IDR, ILS, INR, JPY, KRW, MXN, MYR, NOK, NZD,
        PHP, PLN, RON, RUB, SEK, SGD, THB, TRY, USD, ZAR
    }

    private static List<Currency> currencies;

    /**
     * Fetches currencies and their respective rates from the ECB.
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    private static void fetchCurrencies() throws IOException, ParserConfigurationException, SAXException {
        //Get xml file with currencies and rates from ECB
        URL xmlURL = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        InputStream xml = xmlURL.openStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);

        currencies = new ArrayList<>();

        NodeList list = doc.getElementsByTagName("Cube");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            String name;
            double rate;

            if (node.hasAttributes() && node.getAttributes().getNamedItem("currency") != null
                    && node.getAttributes().getNamedItem("rate") != null) {
                name = node.getAttributes().getNamedItem("currency").getTextContent();
                rate = Double.parseDouble(node.getAttributes().getNamedItem("rate").getTextContent());
                currencies.add(new Currency(name, rate));
            }

            //Add the base currency, being euro
            currencies.add(new Currency("EUR", 1));

            //Sort currencies list alphabetically on name
            Collections.sort(currencies, (o1, o2) -> o1.name.compareToIgnoreCase(o2.name));
        }
    }

    /**
     * Returns the currency corresponding to the given ISO code.
     * @param code the ISO code of the currency
     * @return the currency corresponding to the given ISO code
     */
    public static Currency getCurrencyByCode(CurrencyCode code) {
        try {
            fetchCurrencies();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        for (Currency currency : currencies) if (currency.name.equalsIgnoreCase(code.toString())) return currency;

        return null;
        }

    /**
     * Principal method of the conversion class.
     * Converts and returns a BigDecimal value based on source and target currencies.
     * @param value the value of the source currency
     * @param source the ISO code of the source currency
     * @param target the ISO code of the target currency
     * @return the converted value from the source currency to the target currency
     */
    public static BigDecimal convert(BigDecimal value, CurrencyCode source, CurrencyCode target) {
        try {
            fetchCurrencies();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        double srcRate = getCurrencyByCode(source).rate;
        double trgtRate = getCurrencyByCode(target).rate;

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
        return value.divide(BigDecimal.valueOf(source.rate), 10, BigDecimal.ROUND_CEILING)
                .multiply(BigDecimal.valueOf(target.rate));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.AUD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.BGN));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.BRL));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.CAD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.CHF));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.CNY));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.CZK));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.DKK));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.EUR));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.GBP));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.HKD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.HRK));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.HUF));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.IDR));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.ILS));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.INR));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.JPY));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.KRW));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.MXN));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.MYR));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.NOK));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.NZD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.PHP));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.PLN));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.RON));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.RUB));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.SEK));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.SGD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.THB));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.TRY));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.USD));
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
        return convert(value, source, getCurrencyByCode(CurrencyCode.ZAR));
    }

    //endregion

    /**
     * Inner Class used to represent currencies.
     */
    public static class Currency {
        private final String name;
        private final double rate;

        public Currency(String name, double rate) {
            this.name = name;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Currency: " + name + " - Rate: " + rate;
        }
    }
}
