package supermarket;

import java.util.ArrayList;

// SRP: Handles only low stock checking
public class LowStockService {

    public void checkLowStock(ArrayList<Item> items) {

        boolean found = false;

        System.out.println("\n\t\t===== LOW STOCK ITEMS =====");

        for (Item item : items) {

            if (item.getQuantity() < 5) {
                item.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\t\tNo low stock items found.");
        }
    }
}
