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
     * Product IDs
     */
    int nextProductID = 0;
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
        throw new RuntimeException("Product not in provided ArrayList");
    }

    public boolean productIsInCart(int id) {
        for (Product product : cart) {
            if (product.productID == id) {
                return true;
            }
        }
        return false;
    }

    public void updateCartQty(int id, int addRemoveQty, boolean isAdd) {
        Product product = ProductStores.getProductFromID(id, cart);
        if (isAdd) {
            product.productQty += addRemoveQty;
            return;
        }
        if (product.productQty - addRemoveQty < 0) {
            throw new RuntimeException("updateCartQty FAILED: QTY CANNOT BE SMALLER THAN 0");
        }
        product.productQty -= addRemoveQty;
    }

    /**
     * Add to inventory store, mapping the productID to the index of the inventory array
     * @param itemToAdd <code>Product</code> to add
     */
    public void addInventoryItem(Product itemToAdd) {
        itemToAdd.productID = nextProductID;
        availableInventory.add(itemToAdd);
        nextProductID++;
    }

    public double getCartCost() {
        double sum = 0;
        for (Product p : cart) {
            sum += p.productPrice * p.productQty;
        }
        return sum;
    }

}
