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
//TODO add discount support
public class Sale {
    private int saleID;
    private Date creationDate;
    private boolean isComplete;
    private Payment payment;

    private List<SalesLine> salesLines;

    /**
     * Constructor.
     * @param saleID sales identifier
     */
    public Sale(int saleID) {
        this.saleID = saleID;
        this.creationDate = new Date();
        this.isComplete = false;
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
        this.isComplete = false;
        salesLines = new ArrayList<>();
    }

    /**
     * Adds an item to the sale, if there is an active SalesLine for the item.
     * @param itemID item identifier
     * @param quantity amount of items to add
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void addItem(int itemID, int quantity) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            for (SalesLine line : salesLines) {
                if (line.getItem().getItemID() == itemID) {
                    line.addItem(quantity);
                    break;
                }
            }
            throw new RuntimeException("No SalesLine for given itemID found.");
        }
    }

    /**
     * Adds an item to the sale.
     * @param item SalesLine item to add
     * @param quantity amount of items to add
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void addItem(SalesLineItem item, int quantity) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            try {
                addItem(item.getItemID(), quantity);
            } catch (RuntimeException e) {
                e.getStackTrace();
                salesLines.add(new SalesLine(item, quantity));
            }
        }
    }

    /**
     * Removes an item from the sale, if there is an active SalesLine for the item.
     * @param itemID item identifier
     * @param quantity amount of items to remove
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void removeItem(int itemID, int quantity) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            for (SalesLine line : salesLines) {
                if (line.getItem().getItemID() == itemID) {
                    line.removeItem(quantity);
                    if (line.getQuantity() <= 0) removeSalesLine(line);
                    break;
                }
            }
            throw new RuntimeException("No SalesLine for given itemID found.");
        }
    }

    /**
     * Removes an item from the sale, if there is an active SalesLine for the item.
     * @param item item to remove
     * @param quantity amount of items to remove
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void removeItem(SalesLineItem item, int quantity) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else removeItem(item.getItemID(), quantity);
    }

    /**
     * Adds a SalesLine to the sale if it doesn't yet exists.
     * @param line SalesLine to add
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void addSalesLine(SalesLine line) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            if (!salesLines.contains(line)) salesLines.add(line);
            else throw new RuntimeException("SalesLine already in list.");
        }
    }

    /**
     * Removes a SalesLine from the sale if it already exists.
     * @param line SalesLine to remove
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void removeSalesLine(SalesLine line) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            if (salesLines.contains(line)) salesLines.remove(line);
            else throw new RuntimeException("SalesLine could not be removed.");
        }
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
    public int getItemCount() {
        int items = 0;
        for (SalesLine line : salesLines) {
            items += line.getQuantity();
        }
        return items;
    }

    /**
     * Returns the total sum of the sale, before VAT.
     * @return the total sum of the sale, before VAT
     */
    public double getSubTotal() {
        double total = 0.0;
        for (SalesLine line : salesLines) total += line.getSubTotal();
        return total;
    }

    /**
     * Returns to total amount of VAT of the sale.
     * @return the total amount of VAT of the sale
     */
    public double getTotalVAT() {
        double total = 0.0;
        for (SalesLine line : salesLines) total += line.getTotalVAT();
        return total;
    }

    /**
     * Returns the total sum of the sale, after VAT
     * @return the total sum of the sale, after VAT
     */
    public double getTotal() {
        return getSubTotal() + getTotalVAT();
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
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void setSaleID(int saleID) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else this.saleID = saleID;
    }

    /**
     * Returns the sale's creation date.
     * @return the sale's creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Returns true if the sale is complete.
     * @return true if the sale is complete
     */
    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Completes the sale, if possible.
     * @return true if sale completed, false if otherwise
     */
    public boolean complete() {
        if (salesLines.size() <= 0 && getItemCount() <= 0 && payment == null) return false;
        else {
            this.isComplete = true;
            return isComplete;
        }
    }

    /**
     * Make a payment for the sale.
     * @param payment the payment to make
     * @throws SaleAlreadyCompletedException exception thrown when the sale was already completed
     */
    public void makePayment(Payment payment) throws SaleAlreadyCompletedException {
        if (isComplete) throw new SaleAlreadyCompletedException();
        else {
            if (this.payment == null) this.payment = payment;
            else throw new RuntimeException("Payment cannot be overridden.");
        }
    }

    /**
     * Returns the sale's payment.
     * @return the sale's payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Returns the list of SalesLines.
     * @return the list of SalesLines
     */
    public List<SalesLine> getSalesLines() {
    return new ArrayList<>(salesLines);
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
        out += String.format("%-10s%-10s%-50s%-10s%-22s%-22s%-22s",
                "itemID", "Price", "Description", "Quantity", "Price", "VAT", "Total");
        out += "\n";
        out += String.format("%0" + 135 + "d", 0).replace("0", "-");
        out += "\n";
        for (SalesLine line : salesLines) {
            out += line.toString() + "\n";
        }
        out += String.format("%0" + 135 + "d", 0).replace("0", "-");
        out += "\n";
        out += String.format("%-80s%-20.2f%-22.2f%-20.2f", "Total", getSubTotal(), getTotalVAT(), getTotal());
        return out;
    }

    /**
     * Inner class used to throw Exceptions when the sale has already been completed.
     */
    protected class SaleAlreadyCompletedException extends Exception {
        /**
         * Default constructor. Adds an Exception message.
         */
        public SaleAlreadyCompletedException() {
            super("The sale is already completed.");
        }
    }
}
