package dev.chrisyx511.cs1.finalProject;

import java.util.ArrayList;
/** Reusable Text Elements that can be used throughout the application's menus */
public class MenuItems {
    /**
     * Return a formatted title
     * @param title title of the menu
     * @return formatted text
     */
    public static String menuTitle(String title) {
        return "------  " + title + "  ------";
    }

    /**
     * Create a list of menu options from a String[]
     * @param options <code>String[]</code> list of menu options
     * @return String containing each option on a separate line, with the number in front
     */
    public static String listOfOptions(String[] options) {
        StringBuilder optionStrings = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            optionStrings.append(i + 1).append("- ").append(options[i]).append('\n');
        }
        return optionStrings.toString();
    }

    /**
     * Create a table of products, used in many menu pages
     * @param listOfProducts list of products to be displayed
     * @param useInventory display as Qty or as Inv (remaining inventory)
     * @return String containing a formatted table of products
     */
    public static String productList(ArrayList<Product> listOfProducts, boolean useInventory) {
        StringBuilder returnString;
        // Change display if it's an inventory vs. a cart
        if (useInventory) {
            returnString = new StringBuilder("""
                -- LIST OF ITEMS --
                Index   Name                Inv     Price ($)
                """);
        } else {
            returnString = new StringBuilder("""
                -- LIST OF ITEMS --
                Index   Name                Qty     Price ($)
                """);
        }

        // Create lines to add to the table, padding the strings to be properly formatted with spaces
        for (int i = 0; i < listOfProducts.size(); i++) {
            StringBuilder productNameExpanded = new StringBuilder(listOfProducts.get(i).productName);
            // Product name should be 20 characters
            if (productNameExpanded.length() < 20) {
                productNameExpanded.append(" ".repeat(Math.max(0, 20 - listOfProducts.get(i).productName.length())));
            } else {
                productNameExpanded = new StringBuilder(productNameExpanded.substring(0, 20));
            }
            // Index should be 8 characters
            String indexString = Integer.toString(i);
            indexString += (" ".repeat(Math.max(0, 8 - Integer.toString(i).length())));
            // Append all content as a row of the table
            returnString.append(indexString).append(productNameExpanded).append(listOfProducts.get(i).productQty).append("       ").append(listOfProducts.get(i).getFormattedPrice());
            returnString.append('\n');
        }
        // Return the string
        return returnString.toString();
    }

    public enum Colors {
        BLACK,
        RED,
        GREEN,
        YELLOW,
        BLUE,
        PURPLE,
        CYAN
    }



    public static String returnColorString(String str, Colors clr, boolean highlight) {
        int highlightDigit = 3;
        if (highlight) {
            highlightDigit = 4;
        }
        switch (clr) {
            case RED -> {return "\u001B["+ highlightDigit +"1m" + str + "\u001B[0m";}
            case BLACK -> {return "\u001B[" + highlightDigit + "0m" + str + "\u001B[0m";}
            case GREEN -> {return "\u001B[" + highlightDigit + "2m" + str + "\u001B[0m";}
            case YELLOW -> {return "\u001B[" + highlightDigit + "3m" + str + "\u001B[0m";}
            case BLUE -> {return "\u001B[" + highlightDigit + "4m" + str + "\u001B[0m";}
            case PURPLE -> {return "\u001B[" + highlightDigit + "5m" + str + "\u001B[0m";}
            case CYAN -> {return "\u001B[" + highlightDigit + "6m" + str + "\u001B[0m";}
        }
        throw new RuntimeException("INVALID COLOR");
    }

}
