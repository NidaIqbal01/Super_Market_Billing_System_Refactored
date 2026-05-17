
package com.mycompany.supermarket;

import java.util.ArrayList;

// SRP: Explicitly dedicated to storing and querying catalog stock datasets
class InventoryRepository {
    private final ArrayList<Item> items;

    public InventoryRepository(ArrayList<Item> items) { 
        this.items = items; 
    }

    public void addItem(Item newItem) { 
        items.add(newItem); 
    }
    
    // Feature 9 Fix: Added to allow complete item removal from the central list
    public void removeItem(Item item) { 
        items.remove(item); 
    }

    public Item searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }
}
