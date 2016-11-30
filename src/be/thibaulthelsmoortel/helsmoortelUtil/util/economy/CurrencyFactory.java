/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

import be.thibaulthelsmoortel.helsmoortelUtil.util.economy.Currency.CurrencyCode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Factory class for managing currencies.
 *
 * @author Thibault Helsmoortel
 */
public final class CurrencyFactory {
    private static CurrencyFactory classInstance = new CurrencyFactory();

    private static List<Currency> currencies;

    /**
     * Publicly unavailable constructor.
     */
    private CurrencyFactory() {
        //Constructor not publicly available
        currencies = new ArrayList<>();
        try {
            fetchCurrencies();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetches currencies and their respective rates from the ECB.
     *
     * @throws IOException                  an IOException
     * @throws ParserConfigurationException a ParserConfigurationException
     * @throws SAXException                 a SAXException
     */
    public static void fetchCurrencies() throws IOException, ParserConfigurationException, SAXException {
        //Get xml file with currencies and rates from ECB
        URL xmlURL = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        InputStream xml = xmlURL.openStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);

        NodeList list = doc.getElementsByTagName("Cube");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            String name;
            double rate;

            if (node.hasAttributes() && node.getAttributes().getNamedItem("currency") != null
                    && node.getAttributes().getNamedItem("rate") != null) {
                name = node.getAttributes().getNamedItem("currency").getTextContent();
                rate = Double.parseDouble(node.getAttributes().getNamedItem("rate").getTextContent());
                addCurrency(new Currency(name, rate));
            }

            //Add the base currency, being euro
            addCurrency(new Currency("EUR", 1));

            //Sort currencies list alphabetically on name
            Collections.sort(currencies, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        }
    }

    /**
     * Adds a currency to the list if it doesn't yet exist.
     *
     * @param currency the currency to add
     */
    public static void addCurrency(Currency currency) {
        if (!currencies.contains(currency)) currencies.add(currency);
        else throw new RuntimeException("Currency already in list");
    }

    /**
     * Returns the currencies list.
     *
     * @return the currencies list
     */
    public static List<Currency> getCurrencies() {
        return new ArrayList<>(currencies); //Return a new ArrayList to protect the factory's list
    }

    /**
     * Returns the currency corresponding to the given ISO code.
     *
     * @param code the ISO code of the currency
     * @return the currency corresponding to the given ISO code
     */
    public static Currency getCurrencyByCode(CurrencyCode code) {
        try {
            fetchCurrencies();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        for (Currency currency : currencies) if (currency.getName().equalsIgnoreCase(code.toString())) return currency;

        return null;
    }

    /**
     * Returns the currency corresponding to the given name.
     *
     * @param name the name of the currency
     * @return the currency corresponding to the given name
     */
    public static Currency getCurrencyByName(String name) {
        try {
            fetchCurrencies();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        for (Currency currency : currencies) if (currency.getName().equalsIgnoreCase(name)) return currency;

        return null;
    }

    /**
     * Returns an instance of CurrencyFactory.
     *
     * @return an instance of CurrencyFactory
     */
    public static synchronized CurrencyFactory getInstance() {
        return classInstance;
    }

    /**
     * Blocks the cloning of CurrencyFactory.
     *
     * @return nothing
     * @throws CloneNotSupportedException cloning not supported
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }
}