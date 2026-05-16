import java.util.ArrayList;

// SRP: Explicitly dedicated to storing and querying catalog stock datasets
public class InventoryRepository {
    private final ArrayList<Item> items;

    public InventoryRepository(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() { return items; }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public Item searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
