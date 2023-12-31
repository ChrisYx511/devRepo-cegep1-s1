package dev.chrisyx511.cs1.finalProject;

import java.util.ArrayList;
import java.util.Scanner;

/** Manages Buying, Show Cart, and Purchase Functions
 */
public class ProductPurchase {
    final static Scanner in = new Scanner(System.in);
    /**
     * Open the page to buy items, get user options and run <code>addItemToCart</code>
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void openBuyPage(ProductStores currentSession){
        Menu buyPage = new Menu(MenuItems.menuTitle("Purchase Items"), MenuItems.productList(currentSession.availableInventory, true),
                    MenuItems.listOfOptions(new String[] {
                            "Add an item to cart",
                            "Exit Purchase Items page"
                    })
                );
        buyPage.menuActions.add(() -> ProductPurchase.addItemToCart(currentSession));
        buyPage.handleMenuOption(2);
    }

    /**
     * Add a selected index to cart from the inventory
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void addItemToCart(ProductStores currentSession) {
        System.out.print("Select an item: ");
        // this will accept the user choice
        int chosenIndex = in.nextInt();
        in.nextLine();
        if (chosenIndex > currentSession.availableInventory.size() - 1) {
            System.out.println(MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        System.out.print("How many: ");
        // how many the user adds to the cart
        int qty = in.nextInt();
        in.nextLine();

        Product selectedProduct = currentSession.availableInventory.get(chosenIndex);
        // Place the selected product in a variable
        if (currentSession.productIsInCart(selectedProduct.productID)) {
            if (qty + ProductStores.getProductFromID(selectedProduct.productID, currentSession.cart).productQty > selectedProduct.productQty) {
                System.out.println(MenuItems.returnColorString("Not enough product to fulfill request, try again (" + qty + " selected, " + ProductStores.getProductFromID(selectedProduct.productID, currentSession.cart).productQty + " already in cart)", MenuItems.Colors.YELLOW, true));
                return;
            }
            currentSession.updateCartQty(selectedProduct.productID, qty, true);
        } else {
            if (qty > selectedProduct.productQty) {
                System.out.println(MenuItems.returnColorString("Not enough product to fulfill request, try again", MenuItems.Colors.YELLOW, true));
                return;
            }
            Product p = new Product(selectedProduct.productName, selectedProduct.productPrice, qty, selectedProduct.productID);
            currentSession.cart.add(p);
        }

    }

    /**
     * Remove an item from the cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void removeItemFromCart(ProductStores currentSession) {
        System.out.print("Select index of item to remove from cart: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        // Make sure the item selected is in array
        if (itemIndex > currentSession.cart.size() - 1|| itemIndex < 0) {
            System.out.println(MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        System.out.print("Are you sure (y/n)?");
        String confirm = in.nextLine();
        if (!confirm.equalsIgnoreCase( "y")) {
            System.out.println(MenuItems.returnColorString("Aborted.", MenuItems.Colors.RED, false));
            return;
        }
        currentSession.cart.remove(itemIndex);
    }

    /**
     * Open the cart menu page
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void openCartPage(ProductStores currentSession) {
        // Cart menu generation
        Menu cartPage = new Menu(MenuItems.menuTitle("Cart"), MenuItems.productList(currentSession.cart, false)
                + "\nTotal: $" + Product.formatPrice(currentSession.getCartCost()) + "\n",
                MenuItems.listOfOptions(new String[]{
                        "Remove Item from Cart",
                        "Edit qty of item",
                        "Checkout",
                        "Exit cart",
                }));
        cartPage.menuActions.add(() -> removeItemFromCart(currentSession));
        cartPage.menuActions.add(() -> editCartQty(currentSession));
        cartPage.menuActions.add(() -> processPurchase(currentSession));
        cartPage.handleMenuOption(4, () -> cartPage.body = MenuItems.productList(currentSession.cart, false) + "\nTotal: $" + Product.formatPrice(currentSession.getCartCost()) + "\n");
    }

    /**
     * Process the purchase and clear the cart, remove corresponding inventory quantities
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void processPurchase(ProductStores currentSession) {
        ArrayList<Product> toRemove = new ArrayList<>();
        for (Product p : currentSession.cart) {
            // Add each item to be removed from cart to the toRemove ArrayList, catching any missing items
            // Also removes the required quantity
            try {
                Product invProd = ProductStores.getProductFromID(p.productID, currentSession.availableInventory);
                if (invProd.productQty - p.productQty < 0) {
                    System.out.println(MenuItems.returnColorString("Error: Invalid Cart Qty on Product " + p.productName, MenuItems.Colors.RED, false));
                    continue;
                }
                invProd.productQty -= p.productQty;
                toRemove.add(p);
            } catch (RuntimeException err) {
                System.out.println("Product " + p.productName + " is no longer available, skipping");
                toRemove.add(p);
            }
        }
        // Remove from cart
        currentSession.cart.removeAll(toRemove);
        System.out.println("Thank you!" + "\n");
    }

    /**
     * Edit the qty of an item in the cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void editCartQty(ProductStores currentSession) {
        // Same Logic as ProductManagement
        System.out.print("Select index of item to edit from cart: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        if (itemIndex > currentSession.cart.size() - 1 || itemIndex < 0) {
            System.out.println(MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false) + "\n");
            return;
        }
        Product selectedProduct = currentSession.cart.get(itemIndex);
        System.out.print("Add or Remove? (A/R) ");
        String addOrRemoveStr = in.nextLine();
        if (addOrRemoveStr.equalsIgnoreCase("A")) {
            System.out.print("Enter the amount to add to inventory: ");
            int addQty = in.nextInt();
            in.nextLine();
            // Make sure that adding in the cart also respects inventory values
            if (selectedProduct.productQty + addQty > ProductStores.getProductFromID(selectedProduct.productID, currentSession.availableInventory).productQty) {
                System.out.println(MenuItems.returnColorString("Not enough inventory to fulfill request, please try again!", MenuItems.Colors.YELLOW, true) + "\n");
                return;
            }
            selectedProduct.productQty += addQty;
            System.out.println(MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false) + "\n");

        } else if (addOrRemoveStr.equalsIgnoreCase("R")) {
            System.out.print("Enter the amount to remove from cart: ");
            int removeQty = in.nextInt();
            in.nextLine();
            if (selectedProduct.productQty - removeQty < 0) {
                System.out.println(MenuItems.returnColorString("Invalid QTY!", MenuItems.Colors.YELLOW, false) + "\n");
            } else if (selectedProduct.productQty - removeQty == 0) {
                currentSession.cart.remove(itemIndex);
                System.out.println(MenuItems.returnColorString("Successfully Removed!", MenuItems.Colors.GREEN, false) + "\n");

            } else {
                selectedProduct.productQty -= removeQty;
                System.out.println(MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false) + "\n");
            }
        }



    }

}
