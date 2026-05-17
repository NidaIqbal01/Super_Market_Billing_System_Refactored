/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;


import java.util.ArrayList;

// SRP & DIP: Manages customer carts without mixing print design layouts or handling warehouse arrays directly
class BillingSystem {
    private final ArrayList<Cartable> cartItems = new ArrayList<>();
    private final TaxCalculator taxCalculator = new StandardTaxCalculator();

    // FIXED: Added missing getter method
    public ArrayList<Cartable> getCartItems() { return cartItems; }

    public void addItem(Cartable catalogItem, int quantity) {
        Cartable cartEntry = new CartItemWrapper(catalogItem.getName(), catalogItem.getPrice(), quantity);
        cartItems.add(cartEntry);
        System.out.println("\t\tAdded " + quantity + " x " + catalogItem.getName() + " to the cart.");
    }

    public void viewItems() {
        if (cartItems.isEmpty()) {
            System.out.println("\t\tYour shopping cart is empty.");
        } else {
            System.out.println("\t\t--- Items currently in your Cart ---");
            cartItems.forEach(Cartable::displayInfo);
        }
    }

    // FIXED: Added missing method
    public void updateCartQuantity(String itemName, int newQuantity) {
        for (Cartable item : cartItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                System.out.println("\t\tUpdated " + itemName + " quantity to " + newQuantity + " in cart.");
                return;
            }
        }
        System.out.println("\t\tItem not found in cart.");
    }

    // FIXED: Added missing method
    public void removeItemFromCart(String itemName) {
        boolean removed = cartItems.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println("\t\tRemoved " + itemName + " from cart.");
        } else {
            System.out.println("\t\tItem not found in cart.");
        }
    }

    public double generateBill() {
        double subtotal = cartItems.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
        double tax = taxCalculator.calculateTax(subtotal);
        double total = subtotal + tax;

        System.out.println("\n\t\t================================");
        System.out.println("\t\t         RECEIPT TOTALS           ");
        System.out.println("\t\t================================");
        System.out.printf("\t\tSubtotal: $%.2f\n", subtotal);
        System.out.printf("\t\tTax (5%%): $%.2f\n", tax);
        System.out.printf("\t\tTotal Due: $%.2f\n", total);
        System.out.println("\t\t================================");

        return total;
    }

    // FIXED: Added missing method
    public void deductStock(InventoryRepository inventoryRepo) {
        for (Cartable cartItem : cartItems) {
            Item realStockItem = inventoryRepo.searchItem(cartItem.getName());
            if (realStockItem != null) {
                int leftover = realStockItem.getQuantity() - cartItem.getQuantity();
                realStockItem.setQuantity(leftover);
            }
        }
        cartItems.clear(); 
    }
}
