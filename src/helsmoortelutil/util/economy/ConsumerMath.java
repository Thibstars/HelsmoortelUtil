/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.economy;

/**
 * @author Thibault Helsmoortel
 */

import java.math.BigDecimal;

/**
 * Class for regularly used consumer math methods.
 *
 * Note: We use BigDecimal to represent a currency as suggested by the official data types documentation.
 */

public final class ConsumerMath {

    /**
     * Unavailable constructor
     */
    private ConsumerMath() {
    }

    /**
     * Returns the discount
     * @param listPrice the price to calculate the discount from
     * @param discountRate the discount rate (75% = 0.75)
     * @return the discount
     */
    public static BigDecimal discount(double listPrice, double discountRate) {
        return BigDecimal.valueOf(listPrice * discountRate);
    }

    /**
     * Returns the sale price
     * @param listPrice the price to calculate the sale price from
     * @param discount the discount
     * @return the sale price
     */
    public static BigDecimal salePrice(double listPrice, double discount) {
        return BigDecimal.valueOf(listPrice - discount);
    }

    /**
     * Returns the discount rate
     * @param discount the discount
     * @param listPrice the price to calculate the discount rate from
     * @return the discount rate
     */
    public static double discountRate(double discount, double listPrice) {
        return discount / listPrice;
    }

    /**
     * Returns the sales tax
     * @param itemPrice the price of an item
     * @param taxRate the tax rate
     * @return the sales tax (75% = 0.75)
     */
    public static double salesTax(double itemPrice, double taxRate) {
        return itemPrice * taxRate;
    }

    /**
     * Returns the interest
     * @param principal the principal
     * @param interestRate the interest rate (75% = 0.75)
     * @param time the time to calculate the interest over
     * @return the interest
     */
    public static BigDecimal interest(double principal, double interestRate, double time) {
        return BigDecimal.valueOf(principal * interestRate * time);
    }

    /**
     * Returns the amount of tips
     * @param baseCost the base cost
     * @param tipRate the tip rate (75% = 0.75)
     * @return the amount of tips
     */
    public static BigDecimal tips(double baseCost, double tipRate) {
        return BigDecimal.valueOf(baseCost * tipRate);
    }

    /**
     * Returns the commission
     * @param baseCost the base cost
     * @param commissionRate the commission rate (75% = 0.75)
     * @return the commission
     */
    public static BigDecimal commission(double baseCost, double commissionRate) {
        return BigDecimal.valueOf(baseCost * commissionRate);
    }
}
