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
