/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util.economy;

import java.util.HashSet;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class representing a product catalog.
 */
public class ProductCatalog {
    private HashSet<ProductDescription> catalog;

    /**
     * Default constructor.
     */
    public ProductCatalog() {
        this.catalog = new HashSet<>();
    }

    /**
     * Returns the catalog.
     * @return the catalog
     */
    public HashSet<ProductDescription> getCatalog() {
        return catalog;
    }

    /**
     * Sets the catalog.
     * @param catalog the new catalog
     */
    public void setCatalog(HashSet<ProductDescription> catalog) {
        this.catalog = catalog;
    }

    /**
     * Adds a product to the catalog, if it does not exist.
     * @param description the ProductDescription to add
     */
    public void addProductDescription(ProductDescription description) {
        if (!catalog.contains(description)) catalog.add(description);
        else throw new RuntimeException("ProductDescription already in list.");
    }

    /**
     * Removes a product from the catalog, if it exists.
     * @param description the ProductDescription to remove
     */
    public void removeProductDescription(ProductDescription description) {
        if (catalog.contains(description)) catalog.remove(description);
        else throw new RuntimeException("ProductDescription could not be removed");
    }

    /**
     * Removes a product from the catalog, if it exists, based on the item's id.
     * @param itemID the id of the ProductDescription to remove
     */
    public void removeProductDescription(int itemID) {
        for (ProductDescription description : catalog) {
            if (description.getItemId() == itemID) catalog.remove(description);
        }
    }

    /**
     * Returns the ProductDescription with the given id.
     * @param itemID the ProductDescription's id
     * @return the ProductDescription with the given id
     */
    public ProductDescription getProductDescription(int itemID) {
        for (ProductDescription description : catalog) {
            if (description.getItemId() == itemID) return description;
        }
        return null;
    }
}
