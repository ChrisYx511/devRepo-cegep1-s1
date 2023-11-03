package dev.chrisyx511.cs1.finalProject;

import java.util.ArrayList;

/**
 * Class containing basic data structures and methods used to store products for the session, Storage for the Products
 */
public class ProductStores {
    /** Inventory <code>ArrayList</code>*/
    ArrayList<Product> availableInventory = new ArrayList<>();
    /** Cart <code>ArrayList</code>*/
    ArrayList<Product> cart = new ArrayList<>();
    /**
     * Get a product from a given ID, return NULL if nothing is found
     * @param id <code>productID</code> of the product
     * @param arrayOfProducts <code>ArrayList</code>
     * @return <code>Product</code> if found, <code>null</code> if not found
     */
    // This will allow one to associate products in the cart with the products in inventory
    public static Product getProductFromID(int id, ArrayList<Product> arrayOfProducts) {
        for (Product product : arrayOfProducts) {
            if (product.productID == id) {
                return product;
            }
        }
        return null;
    }

    /**
     * Add to inventory store, mapping the productID to the index of the inventory array
     * @param itemToAdd <code>Product</code> to add
     */
    public void addInventoryItem(Product itemToAdd) {
        itemToAdd.productID = availableInventory.size();
        availableInventory.add(itemToAdd);
    }

    /**
     * Update the product IDs of the inventory to match the index
     */
    // Used when an item is deleted from inventory
    public void updateProductIDs() {
        for (int i = 0; i < availableInventory.size(); i++) {
            availableInventory.get(i).productID = i;
        }
    }

}
