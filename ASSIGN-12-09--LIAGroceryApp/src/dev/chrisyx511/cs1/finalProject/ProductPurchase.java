package dev.chrisyx511.cs1.finalProject;

/** Manages Buying, Show Cart, and Purchase Functions
 */
public class ProductPurchase {
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
        System.out.println("This would ask an item to add to the list!");
        // this will accept the user choice
        int chosenIndex = 1;
        // how many the user adds to the cart
        int qty = 1;
        // Place the selected product in a variable
        if (currentSession.cart.contains(ProductStores.getProductFromID(chosenIndex, currentSession.cart))) {

        }
        Product selectedProduct = currentSession.availableInventory.get(chosenIndex);
        // Change the quantity to the amount to be added to the cart
        selectedProduct.productQty = qty;
        currentSession.cart.add(selectedProduct);
    }

    /**
     * Remove an item from the cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void removeItemFromCart(ProductStores currentSession) {

    }

    /**
     * Open the cart menu page
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void openCartPage(ProductStores currentSession) {
        Menu cartPage = new Menu(MenuItems.menuTitle("Cart"), MenuItems.productList(currentSession.cart, false), MenuItems.listOfOptions(new String[]{
                "Remove Item from Cart",
                "Checkout",
                "Exit",
        }));
        cartPage.menuActions.add(() -> removeItemFromCart(currentSession));
        cartPage.menuActions.add(() -> processPurchase(currentSession));
        cartPage.handleMenuOption(3);
    }

    /**
     * Process the purchase and clear the cart, remove corresponding inventory quantities
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void processPurchase(ProductStores currentSession) {

    }

    /**
     * Edit the qty of an item in the cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void editCartQty(ProductStores currentSession) {

    }

}
