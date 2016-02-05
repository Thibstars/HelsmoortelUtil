/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.economy;

/**
 * @author Thibault Helsmoortel
 */

import java.text.DecimalFormat;

/**
 * Class for representation of a sales line.
 */
public class SalesLine {
    private SalesLineItem item;
    private int quantity;

    /**
     * Constructor.
     * @param item SalesLineItem for the SalesLine
     * @param quantity amount of SalesLineItems in the SalesLine
     */
    public SalesLine(SalesLineItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Adds an amount of the line's item.
     * @param quantity amount of the line's item to add
     */
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Removes an amount of the line's item.
     * @param quantity amount of the line's item to remove
     */
    public void removeItem(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Returns the SalesLineItem of the SalesLine.
     * @return the SalesLineItem of the SalesLine
     */
    public SalesLineItem getItem() {
        return item;
    }

    /**
     * Sets the SalesLineItem of the SalesLine.
     * @param item the SalesLineItem of the SalesLine.
     */
    public void setItem(SalesLineItem item) {
        this.item = item;
    }

    /**
     * Returns the amount of items in the sales line.
     * @return the amount of items in the sales line.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the amount of items in the sales line.
     * @param quantity the new amount of items in the sales line.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the total sum of the sales line, before VAT.
     * @return the total sum of the sales line, before VAT
     */
    public double getSubTotal() {
        return item.getPrice() * quantity;
    }

    /**
     * Returns the total amount of VAT of the sales line.
     * @return the total amount of VAT of the sales line
     */
    public double getTotalVAT() {
        return item.getVAT() * quantity;
    }

    /**
     * Returns the VAT percentage of the sales line
     * @return the VAT percentage of the sales line
     */
    public double getVATPercentage() {
        return item.getVATPercentage();
    }

    /**
     * Returns the total sum of the sales line, after VAT.
     * @return the total sum of the sales line, after VAT
     */
    public double getTotal() {
        return getSubTotal() + getTotalVAT();
    }

    /**
     * Returns a String representation of the sales line.
     * @return a String representation of the sales line
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String totalVAT = df.format(getTotalVAT());
        String VATPercentage = df.format(getVATPercentage() * 100);
        return String.format("%-67s%-10d%-20.2f%-22s%-20.2f",
                item.toString(), quantity, getSubTotal(),
                (totalVAT + " (%" + VATPercentage  + ")"), getTotal());
    }
}
