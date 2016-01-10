/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.economy;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class representing an item in a sales line.
 */
public class SalesLineItem {
    private int itemID;
    private double price;
    private String description;

    /**
     * Constructor.
     * @param itemID item identifier
     * @param price item's price
     * @param description item's description
     */
    public SalesLineItem(int itemID, double price, String description) {
        this.itemID = itemID;
        this.price = price;
        this.description = description;
    }

    /**
     * Returns the item identifier.
     * @return the item identifier
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Sets the item identifier.
     * @param itemID the new item identifier
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * Returns the price of the item.
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     * @param price the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the item's description.
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the item's description.
     * @param description the new item description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a String representation of a SalesLineItem.
     * @return a String representation of a SalesLineItem
     */
    @Override
    public String toString() {
        return String.format("%-10d%-10.2f%-50s", itemID, price, description);
    }
}
