package dev.chrisyx511.cs1.finalProject;

import java.text.DecimalFormat;
/** Defines the basic layout of an item in the store */
public class Product {
    //Key properties
    String productName;
    double productPrice;
    int productQty;
    // ID used to map between different lists
    int productID;
    // Initializing a product
    Product(String name, double price, int qty) {
        this.productName = name;
        this.productPrice = price;
        this.productQty = qty;
    }
    Product(String name, double price, int qty, int id) {
        this.productName = name;
        this.productPrice = price;
        this.productQty = qty;
        this.productID = id;
    }

    /**
     * Return price always with 2 decimal positions
     * @return <code>String</code> containing the price formatted to 2 decimals
     */
    public String getFormattedPrice() {
        final DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(this.productPrice);
    }
}
