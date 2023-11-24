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
        System.out.print("How many: ");
        // how many the user adds to the cart
        int qty = in.nextInt();
        in.nextLine();
        if (chosenIndex > currentSession.availableInventory.size() - 1) {
            System.out.println("Invalid Selection!");
            return;
        }
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
        if (itemIndex > currentSession.cart.size() - 1|| itemIndex < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        System.out.print("Are you sure (y/n)?");
        String confirm = in.nextLine();
        if (!confirm.equalsIgnoreCase( "y")) {
            System.out.println("\n" + MenuItems.returnColorString("Aborted.", MenuItems.Colors.RED, false));
            return;
        }
        currentSession.cart.remove(itemIndex);
    }

    /**
     * Open the cart menu page
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void openCartPage(ProductStores currentSession) {
        Menu cartPage = new Menu(MenuItems.menuTitle("Cart"), MenuItems.productList(currentSession.cart, false), MenuItems.listOfOptions(new String[]{
                "Remove Item from Cart",
                "Edit qty of item",
                "Checkout",
                "Exit cart",
        }));
        cartPage.menuActions.add(() -> removeItemFromCart(currentSession));
        cartPage.menuActions.add(() -> editCartQty(currentSession));
        cartPage.menuActions.add(() -> processPurchase(currentSession));
        cartPage.handleMenuOption(4, () -> cartPage.body = MenuItems.productList(currentSession.cart, false));
    }

    /**
     * Process the purchase and clear the cart, remove corresponding inventory quantities
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void processPurchase(ProductStores currentSession) {
        ArrayList<Product> toRemove = new ArrayList<>();
        for (Product p : currentSession.cart) {
            try {
                Product invProd = ProductStores.getProductFromID(p.productID, currentSession.availableInventory);
                if (invProd.productQty - p.productQty < 0) {
                    System.out.println(MenuItems.returnColorString("Error: Invalid Cart Qty on Product " + p.productName, MenuItems.Colors.RED, false));
                    continue;
                }
                if (invProd.productQty - p.productQty == 0) {
                    currentSession.availableInventory.remove(invProd);
                }
                invProd.productQty -= p.productQty;
                toRemove.add(p);
            } catch (RuntimeException err) {
                System.out.println("Product " + p.productName + " is no longer available, skipping");
                toRemove.add(p);
            }
        }
        currentSession.cart.removeAll(toRemove);
        System.out.println("Thank you!");
    }

    /**
     * Edit the qty of an item in the cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void editCartQty(ProductStores currentSession) {
        //TODO : Possibly add qty from cart
        System.out.print("Select index of item to edit from cart: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        if (itemIndex > currentSession.cart.size() - 1 || itemIndex < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        Product selectedProduct = currentSession.cart.get(itemIndex);
        System.out.print("Enter the amount to remove from cart: ");
        int removeQty = in.nextInt();
        in.nextLine();
        if (selectedProduct.productQty - removeQty < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid QTY!", MenuItems.Colors.YELLOW, false));
        } else if (selectedProduct.productQty - removeQty == 0) {
            currentSession.cart.remove(itemIndex);
            System.out.println("\n" + MenuItems.returnColorString("Successfully Removed!", MenuItems.Colors.GREEN, false));

        } else {
            selectedProduct.productQty -= removeQty;
            System.out.println("\n" + MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false));
        }


    }

}
