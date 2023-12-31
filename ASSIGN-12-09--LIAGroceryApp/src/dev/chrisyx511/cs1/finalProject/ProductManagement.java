package dev.chrisyx511.cs1.finalProject;

import java.util.Scanner;

/** Used to add/remove inventory to the store */
public class ProductManagement {
    static Scanner in = new Scanner(System.in);
    /**
     * Open menu Add/Remove Products
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void openMgmtMenu(ProductStores currentSession) {
        // Create Menu to manage product inventory
        Menu mgmtPage = new Menu(MenuItems.menuTitle("Manage Inventory"), MenuItems.productList(currentSession.availableInventory, true),
                MenuItems.listOfOptions(new String[]{
                        "Add an item to inventory",
                        "Remove an item from inventory",
                        "Edit qty of item in inventory",
                        "Exit Product Management page"
                })
        );
        mgmtPage.menuActions.add(() -> ProductManagement.addProduct(currentSession));
        mgmtPage.menuActions.add(() -> ProductManagement.removeProduct(currentSession));
        mgmtPage.menuActions.add(() -> ProductManagement.editInv(currentSession));
        mgmtPage.handleMenuOption(4, () -> mgmtPage.body = MenuItems.productList(currentSession.availableInventory, true));

    }

    /**
     * Add a product to the inventory
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void addProduct(ProductStores currentSession) {
        // Get user input for product details
        System.out.print("Enter product name: ");
        String name = in.nextLine();
        System.out.print("Enter product qty: ");
        int qty = in.nextInt();
        in.nextLine();
        System.out.println("Enter product unit price ($): ");
        double price = in.nextDouble();
        in.nextLine();
        // Add product to currentSession Inventory ArrayList, giving it an id through addInventoryItem method
        currentSession.addInventoryItem(new Product(name, price, qty));
        System.out.println(MenuItems.returnColorString("Item successfully added!", MenuItems.Colors.GREEN, false));
    }

    /**
     * Remove a product from the inventory, also removes it from user cart and reset product IDs for inventory and cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void removeProduct(ProductStores currentSession) {
        System.out.print("Select index of item to remove from inventory: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        // Check for selection, if it is in the array
        if (itemIndex > currentSession.availableInventory.size() - 1|| itemIndex < 0) {
            System.out.println(MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false) + "\n");
            return;
        }
        // confirm deletion
        System.out.print("Are you sure (y/n)?");
        String confirm = in.nextLine();
        if (!confirm.equalsIgnoreCase( "y")) {
            System.out.println("\n" + MenuItems.returnColorString("Aborted.", MenuItems.Colors.RED, false) + "\n");
            return;
        }
        currentSession.availableInventory.remove(itemIndex);

    }

    /**
     * Select a product and edit the inventory information
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void editInv(ProductStores currentSession) {
        System.out.print("Select index of item to edit from inventory: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        // Check selection
        if (itemIndex > currentSession.availableInventory.size() - 1 || itemIndex < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        Product selectedProduct = currentSession.availableInventory.get(itemIndex);
        System.out.print("Add or Remove? (A/R) ");
        String addOrRemoveStr = in.nextLine();
        // Logic depending on add or remove
        if (addOrRemoveStr.equalsIgnoreCase("A")) {
            System.out.print("Enter the amount to add to inventory: ");
            int addQty = in.nextInt();
            in.nextLine();
            selectedProduct.productQty += addQty;
            System.out.println(MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false) + "\n");
        } else if (addOrRemoveStr.equalsIgnoreCase("R")) {
            System.out.print("Enter the amount to remove from inventory: ");
            int removeQty = in.nextInt();
            in.nextLine();
            // Making sure that the item count isn't negative
            if (selectedProduct.productQty - removeQty < 0) {
                System.out.println(MenuItems.returnColorString("Invalid QTY!", MenuItems.Colors.YELLOW, false) + "\n");
            } else {
                selectedProduct.productQty -= removeQty;
                System.out.println(MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false) + "\n");
            }
        } else {
            System.out.println(MenuItems.returnColorString("Invalid Selection!\n", MenuItems.Colors.YELLOW, false) + "\n");
        }
    }
}
