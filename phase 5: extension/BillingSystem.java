package supermarket;

import java.util.ArrayList;

// SRP & DIP: Manages customer carts without mixing print design layouts or handling warehouse arrays directly
public class BillingSystem {

    private final ArrayList<Cartable> cartItems = new ArrayList<>();

    private final TaxCalculator taxCalculator = new StandardTaxCalculator();

    // NEW FEATURE: Discount Strategy
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addItem(Cartable catalogItem, int quantity) {

        // FEATURE F-20: Stock Availability Check
        if (quantity > catalogItem.getQuantity()) {
            System.out.println("\t\tNot enough stock available.");
            return;
        }

        Cartable cartEntry = new CartItemWrapper(
                catalogItem.getName(),
                catalogItem.getPrice(),
                quantity
        );

        cartItems.add(cartEntry);

        // FEATURE F-19: Inventory Stock Update After Purchase
        catalogItem.setQuantity(catalogItem.getQuantity() - quantity);

        System.out.println("\t\tAdded " + quantity + " x " + catalogItem.getName() + " to the cart.");
    }

    public void viewItems() {

        if (cartItems.isEmpty()) {
            System.out.println("\t\tYour shopping cart is empty.");
        }
        else {
            System.out.println("\t\t--- Items currently in your Cart ---");
            cartItems.forEach(Cartable::displayInfo);
        }
    }

   public double generateBill() {

        double subtotal = cartItems.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();

        // NEW FEATURE: Discount System
        double discount = discountStrategy.applyDiscount(subtotal);

        double discountedSubtotal = subtotal - discount;

        double tax = taxCalculator.calculateTax(discountedSubtotal);

        double total = discountedSubtotal + tax;

        System.out.println("\n\t\t================================");
        System.out.println("\t\t       RECEIPT TOTALS           ");
        System.out.println("\t\t================================");
        System.out.printf("\t\tSubtotal: $%.2f\n", subtotal);
        System.out.printf("\t\tDiscount: -$%.2f\n", discount);
        System.out.printf("\t\tTax (5%%): $%.2f\n", tax);
        System.out.printf("\t\tTotal Due: $%.2f\n", total);
        System.out.println("\t\t================================");

        return total;
    }
}
