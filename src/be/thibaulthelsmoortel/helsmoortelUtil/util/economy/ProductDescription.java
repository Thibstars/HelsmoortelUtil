/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

/**
 * Class to represent a product (, the description, not the actual product instance).
 *
 * @author Thibault Helsmoortel
 */
public class ProductDescription {
    private int itemId;
    private double price;
    private double VATPercentage;
    private String description;

    /**
     * Constructor initializing id, price and description.
     *
     * @param itemId        the ProductDescription's id
     * @param price         the ProductDescription's price
     * @param VATPercentage the ProductDescription's VAT percentage
     * @param description   the ProductDescription's description
     */
    public ProductDescription(int itemId, double price, double VATPercentage, String description) {
        this.itemId = itemId;
        this.price = price;
        this.VATPercentage = VATPercentage;
        this.description = description;
    }

    /**
     * Returns the ProductDescription's id.
     *
     * @return the id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the ProductDescription's id.
     *
     * @param itemId the new id
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Returns the ProductDescription's price, before VAT.
     *
     * @return the price before VAT
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the ProductDescription's price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the ProductDescription's price after VAT.
     *
     * @return the ProductDescription's price after VAT
     */
    public double getPriceAfterVAT() {
        return price + getVAT();
    }

    /**
     * Returns the ProductDescription's VAT percentage.
     *
     * @return the ProductDescription's VAT percentage
     */
    public double getVATPercentage() {
        return VATPercentage;
    }

    /**
     * Sets the ProductDescription's VAT percentage.
     *
     * @param VATPercentage the new VAT percentage
     */
    public void setVATPercentage(double VATPercentage) {
        this.VATPercentage = VATPercentage;
    }

    /**
     * Returns the ProductDescription's VAT.
     *
     * @return the ProductDescription's VAT
     */
    public double getVAT() {
        return price * VATPercentage;
    }

    /**
     * Returns the ProductDescription's description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the ProductDescription's description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
