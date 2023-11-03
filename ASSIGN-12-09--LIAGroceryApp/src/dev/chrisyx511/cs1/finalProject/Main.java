package dev.chrisyx511.cs1.finalProject;

public class Main {
    public static void main(String[] args) {
        // Initialize ProductStores
        ProductStores session = new ProductStores();

        // Render the main menu //
        Menu mainMenu = new Menu(MenuItems.menuTitle("Main Menu"), "Welcome to xyz shopping software!", MenuItems.listOfOptions(new String[]{
                "Add / Remove Items",
                "Buy Items",
                "View Cart & Checkout",
                "Exit"
        }));
        // Add the menu actions to the main menu, in order of the list.
        // Notice the use of lambda functions, passed to MenuAction as method MenuAction.action()
        mainMenu.menuActions.add(() -> System.out.println("This is where Add/Remove Items would run"));
        mainMenu.menuActions.add(() -> ProductPurchase.openBuyPage(session));
        mainMenu.menuActions.add(() -> ProductPurchase.openCartPage(session));
        // Draw and handle the actions of the main menu
        mainMenu.handleMenuOption(4);

    }
}
