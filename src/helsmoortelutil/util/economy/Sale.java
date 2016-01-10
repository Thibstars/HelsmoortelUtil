/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.economy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for representation of sales.
 */
public class Sale {
    private int saleID;
    private Date creationDate;

    private List<SalesLine> salesLines;

    /**
     * Constructor.
     * @param saleID sales identifier
     */
    public Sale(int saleID) {
        this.saleID = saleID;
        this.creationDate = new Date();
        salesLines = new ArrayList<>();
    }

    /**
     * Constructor.
     * @param saleID sales identifier
     * @param creationDate sales creation date
     */
    public Sale(int saleID, Date creationDate) {
        this.saleID = saleID;
        this.creationDate = creationDate;
        salesLines = new ArrayList<>();
    }

    /**
     * Adds an item to the sale, if there is an active SalesLine for the item.
     * @param itemID item identifier
     * @param quantity amount of items to add
     */
    public void addItem(int itemID, int quantity) {
        for (SalesLine line : salesLines) {
            if (line.getItem().getItemID() == itemID){
                line.addItem(quantity);
                break;
            }
        }
        throw new RuntimeException("No SalesLine for given itemID found.");
    }

    /**
     * Adds an item to the sale.
     * @param item SalesLine item to add
     * @param quantity amount of items to add
     */
    public void addItem(SalesLineItem item, int quantity) {
        try {
            addItem(item.getItemID(), quantity);
        } catch (RuntimeException e) {
            e.getStackTrace();
            salesLines.add(new SalesLine(item, quantity));
        }
    }

    /**
     * Removes an item from the sale, if there is an active SalesLine for the item.
     * @param itemID item identifier
     * @param quantity amount of items to remove
     */
    public void removeItem(int itemID, int quantity) {
        for (SalesLine line : salesLines) {
            if (line.getItem().getItemID() == itemID){
                line.removeItem(quantity);
                if (line.getQuantity() <= 0) removeSalesLine(line);
                break;
            }
        }
        throw new RuntimeException("No SalesLine for given itemID found.");
    }

    /**
     * Removes an item from the sale, if there is an active SalesLine for the item.
     * @param item item to remove
     * @param quantity amount of items to remove
     */
    public void removeItem(SalesLineItem item, int quantity) {
        removeItem(item.getItemID(), quantity);
    }

    /**
     * Adds a SalesLine to the sale if it doesn't yet exists.
     * @param line SalesLine to add
     */
    public void addSalesLine(SalesLine line) {
        if (!salesLines.contains(line)) salesLines.add(line);
        else throw new RuntimeException("SalesLine already in list.");
    }

    /**
     * Removes a SalesLine from the sale if it already exists.
     * @param line SalesLine to remove
     */
    public void removeSalesLine(SalesLine line) {
        if (salesLines.contains(line)) salesLines.remove(line);
        else throw new RuntimeException("SalesLine could not be removed.");
    }

    /**
     * Returns the total amount of SalesLines in the sale.
     * @return the total amount of SalesLines in the sale
     */
    public int getLinesCount() {
        return salesLines.size();
    }

    /**
     * Returns the total amount of items in the sale.
     * @return the total amount of items in the sale
     */
    public int getItemCOunt() {
        int items = 0;
        for (SalesLine line : salesLines) {
            items += line.getQuantity();
        }
        return items;
    }

    /**
     * Returns the total sum of the sale.
     * @return the total sum of the sale
     */
    public double getTotal() {
        double total = 0.0;
        for (SalesLine line : salesLines) {
            total += line.getTotal();
        }
        return total;
    }

    /**
     * Returns the sale's identifier.
     * @return the sale's identifier
     */
    public int getSaleID() {
        return saleID;
    }

    /**
     * Sets the sale's identifier.
     * @param saleID the new sale's identifier
     */
    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    /**
     * Returns the sale's creation date.
     * @return the sale's creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Returns the list of SalesLines.
     * @return the list of SalesLines
     */
    public List<SalesLine> getSalesLines() {
        return salesLines;
    }

    /**
     * Returns a list of all SalesLineItems.
     * @return a list of all SalesLineItems
     */
    public List<SalesLineItem> getSalesLineItems() {
        List<SalesLineItem> items = new ArrayList<>();
        for (SalesLine line : salesLines) {
            items.add(line.getItem());
        }
        return items;
    }

    /**
     * Returns a String representation of the sale.
     * @return a String representation of the sale
     */
    @Override
    public String toString() {
        String out = "Sale: " + saleID + "\t- " + creationDate + "\n";
        out += String.format("%-10s%-10s%-50s%-10s%-22s", "itemID", "Price", "Description", "Quantity", "Total");
        out += "\n";
        out += String.format("%0" + 102 + "d", 0).replace("0", "-");
        out += "\n";
        for (SalesLine line : salesLines) {
            out += line.toString() + "\n";
        }
        out += String.format("%0" + 102 + "d", 0).replace("0", "-");
        out += "\n";
        out += String.format("%-80s%-20.2f", "Total", getTotal());
        return out;
    }
}
