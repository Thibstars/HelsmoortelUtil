/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class representing an item in a sales line.
 */
public class SalesLineItem {
    private ProductDescription description;

    /**
     * Constructor.
     * @param description product description for the line item.
     */
    public SalesLineItem(ProductDescription description) {
        this.description = description;
    }

    /**
     * Returns the item identifier.
     * @return the item identifier
     */
    public int getItemID() {
        return description.getItemId();
    }

    /**
     * Returns the price of the item.
     * @return the price of the item
     */
    public double getPrice() {
        return description.getPrice();
    }

    /**
     * Returns to VAT of the item.
     * @return the VAT of the item
     */
    public double getVAT() {
        return description.getVAT();
    }

    /**
     * Returns the VAT percentage of the item.
     * @return the VAT percentage of the item
     */
    public double getVATPercentage() {
        return description.getVATPercentage();
    }

    /**
     * Returns the item's description.
     * @return the item's description
     */
    public String getDescription() {
        return description.getDescription();
    }

    /**
     * Returns a String representation of a SalesLineItem.
     * @return a String representation of a SalesLineItem
     */
    @Override
    public String toString() {
        return String.format("%-10d%-10.2f%-50s", getItemID(), getPrice(), getDescription());
    }
}
