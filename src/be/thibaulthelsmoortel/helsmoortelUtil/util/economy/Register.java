/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.economy;

import java.util.Date;

/**
 * Class representing a register.
 *
 * @author Thibault Helsmoortel
 */
public class Register {
    private int registerID;
    private ProductCatalog catalog;
    private Cashier cashier;
    private Sale currentSale;

    /**
     * Constructor setting the id and ProductCatalog.
     *
     * @param registerID the register's id
     * @param catalog    the ProductCatalog the register will use
     */
    public Register(int registerID, ProductCatalog catalog) {
        this.registerID = registerID;
        this.catalog = catalog;
    }

    /**
     * Logs a cashier into the register, if possible.
     *
     * @param cashier the cashier to login
     */
    public void logIn(Cashier cashier) {
        if (this.cashier == null) this.cashier = cashier;
        else throw new RuntimeException("A cashier is already logged in. Log out first.");
    }

    /**
     * Logs out the cashier.
     */
    public void logOut() {
        this.cashier = null;
    }

    /**
     * Returns true if a cashier is logged in, false if otherwise.
     *
     * @return true if a cashier is logged in, false if otherwise
     */
    public boolean isLoggedIn() {
        return cashier != null;
    }

    /**
     * Creates a new sale (with the current date).
     *
     * @param saleID the id for the new sale
     */
    public void makeNewSale(int saleID) {
        if (isLoggedIn()) this.currentSale = new Sale(saleID);
    }

    /**
     * Creates a new sale.
     *
     * @param saleID       the id for the new sale
     * @param creationDate the date of creation
     */
    public void makeNewSale(int saleID, Date creationDate) {
        if (isLoggedIn()) this.currentSale = new Sale(saleID, creationDate);
    }

    /**
     * Adds an amount of a SalesLineItem to the sale.
     *
     * @param item     the SalesLineItem to add
     * @param quantity the amount of items to add
     */
    public void enterItem(SalesLineItem item, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.addItem(item, quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds an amount of ProductDescription to the sale.
     *
     * @param item     the ProductDescription to add
     * @param quantity the amount of items to add
     */
    public void enterItem(ProductDescription item, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.addItem(catalog.getProductDescription(item.getItemId()).getItemId(), quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds an amount of items based on id.
     *
     * @param itemID   the item's id of the item to add
     * @param quantity the amount of items to add
     */
    public void enterItem(int itemID, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.addItem(itemID, quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Removes an amount of items from the sale.
     *
     * @param item     the SalesLineItem to remove
     * @param quantity the amount of items to remove
     */
    public void removeItem(SalesLineItem item, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.removeItem(item, quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Removes an amount of items from the sale.
     *
     * @param item     the ProductDescription to remove
     * @param quantity the amount of items to remove
     */
    public void removeItem(ProductDescription item, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.removeItem(catalog.getProductDescription(item.getItemId()).getItemId(), quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Removes an amount of items from the sale.
     *
     * @param itemID   the item's id of the item to remove
     * @param quantity the amount of items to remove
     */
    public void removeItem(int itemID, int quantity) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.removeItem(itemID, quantity);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a Payment to the sale.
     *
     * @param payment the payment to add
     */
    public void makePayment(Payment payment) {
        if (isLoggedIn() && currentSale != null) {
            try {
                currentSale.makePayment(payment);
            } catch (Sale.SaleAlreadyCompletedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Completes and returns the Sale if successful.
     *
     * @return the sale if completed
     */
    public Sale endSale() {
        if (isLoggedIn() && currentSale != null) {
            currentSale.complete();
            if (currentSale.isComplete()) return currentSale;
            return null;
        }
        return null;
    }

    /**
     * Returns the register's id
     *
     * @return the register's id
     */
    public int getRegisterID() {
        return registerID;
    }

    /**
     * Returns the Productcatalog.
     *
     * @return the ProductCatalog
     */
    public ProductCatalog getCatalog() {
        if (isLoggedIn()) return catalog;
        return null;
    }

    /**
     * Sets the ProductCatalog.
     *
     * @param catalog the ProductCatalog to set
     */
    public void setCatalog(ProductCatalog catalog) {
        if (isLoggedIn()) this.catalog = catalog;
    }

    /**
     * Returns the current sale.
     *
     * @return the current sale
     */
    public Sale getCurrentSale() {
        if (isLoggedIn()) return currentSale;
        return null;
    }
}
