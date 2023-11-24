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
        //TODO: IMPLEMENT ProductManagement.addProduct(), last method (mostly)
    }

    /**
     * Remove a product from the inventory, also removes it from user cart and reset product IDs for inventory and cart
     * @param currentSession the ProductStore currently used so method can get cart and inventory
     */
    public static void removeProduct(ProductStores currentSession) {
        System.out.print("Select index of item to remove from inventory: ");
        int itemIndex = in.nextInt();
        in.nextLine();
        if (itemIndex > currentSession.availableInventory.size() - 1|| itemIndex < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        System.out.print("Are you sure (y/n)?");
        String confirm = in.nextLine();
        if (!confirm.equalsIgnoreCase( "y")) {
            System.out.println("\n" + MenuItems.returnColorString("Aborted.", MenuItems.Colors.RED, false));
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
        if (itemIndex > currentSession.availableInventory.size() - 1 || itemIndex < 0) {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!", MenuItems.Colors.YELLOW, false));
            return;
        }
        Product selectedProduct = currentSession.availableInventory.get(itemIndex);
        System.out.print("Add or Remove inventory? (A/R) ");
        String addOrRemoveStr = in.nextLine();
        if (addOrRemoveStr.equalsIgnoreCase("A")) {
            System.out.print("Enter the amount to add to inventory: ");
            int addQty = in.nextInt();
            in.nextLine();
            selectedProduct.productQty += addQty;
            System.out.println("\n" + MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false));
        } else if (addOrRemoveStr.equalsIgnoreCase("R")) {
            System.out.print("Enter the amount to remove from inventory: ");
            int removeQty = in.nextInt();
            in.nextLine();
            if (selectedProduct.productQty - removeQty < 0) {
                System.out.println("\n" + MenuItems.returnColorString("Invalid QTY!", MenuItems.Colors.YELLOW, false));
            } else if (selectedProduct.productQty - removeQty == 0) {
                currentSession.availableInventory.remove(itemIndex);
                System.out.println("\n" + MenuItems.returnColorString("Successfully Removed!", MenuItems.Colors.GREEN, false));

            } else {
                selectedProduct.productQty -= removeQty;
                System.out.println("\n" + MenuItems.returnColorString("Item Updated!", MenuItems.Colors.GREEN, false));
            }
        } else {
            System.out.println("\n" + MenuItems.returnColorString("Invalid Selection!\n", MenuItems.Colors.YELLOW, false));
        }
    }
}
