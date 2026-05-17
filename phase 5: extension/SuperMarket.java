package com.mycompany.supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarket {

    private final ArrayList<Item> items;
    private final ArrayList<Customer> customers;
    private PaymentMethod paymentMethod;

    public final InventoryRepository inventoryRepo;
    public final CustomerRepository customerRepo;

    public SuperMarket(ArrayList<Item> items, ArrayList<Customer> customers, PaymentMethod paymentMethod) {
        this.items = items;
        this.customers = customers;
        this.paymentMethod = paymentMethod;
        
        this.inventoryRepo = new InventoryRepository(items);
        this.customerRepo = new CustomerRepository(customers);
    }

    public void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        inventoryRepo.addItem(newItem);
        System.out.println("Item added: " + name);
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            System.out.println("Items in the inventory:");
            items.forEach(Item::displayInfo);
        }
    }

    public void updateItem(String name) {
        Item item = inventoryRepo.searchItem(name);
        if (item != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\t\tItem found: ");
            item.displayInfo();
            System.out.println("\t\tWhat would you like to update?");
            System.out.println("\t\t1. Quantity");
            System.out.println("\t\t2. Price");
            System.out.println("\t\t3. All Fields");
            System.out.print("\t\tEnter your choice: ");
            int updateChoice = sc.nextInt();
            sc.nextLine(); 

            switch (updateChoice) {
                case 1 -> {
                    System.out.print("\t\tEnter new quantity: ");
                    int newQuantity = sc.nextInt();
                    item.setQuantity(newQuantity);
                    System.out.println("\t\tItem quantity updated.");
                }
                case 2 -> {
                    System.out.print("\t\tEnter new price: ");
                    double newPrice = sc.nextDouble();
                    item.setPrice(newPrice);
                    System.out.println("\t\tItem price updated.");
                }
                case 3 -> {
                    System.out.print("\t\tEnter new name: ");
                    String updatedName = sc.nextLine();
                    System.out.print("\t\tEnter new price: ");
                    double updatedPrice = sc.nextDouble();
                    System.out.print("\t\tEnter new quantity: ");
                    int updatedQuantity = sc.nextInt();
                    item.setName(updatedName);
                    item.setPrice(updatedPrice);
                    item.setQuantity(updatedQuantity);
                    System.out.println("\t\tAll fields updated.");
                }
                default -> System.out.println("\t\tInvalid choice.");
            }
            return;
        }
        System.out.println("\t\tItem not found: " + name);
    }

    public void deleteItem(String name) {
        Item itemToDelete = inventoryRepo.searchItem(name);
        if (itemToDelete != null) {
            inventoryRepo.removeItem(itemToDelete);
            System.out.println("Deleted item: " + name);
        } else {
            System.out.println("Item not found inside inventory system.");
        }
    }

    public Item searchItem(String name) {
        return inventoryRepo.searchItem(name);
    }

    public void addCustomer(String customerId, String name, String address, String email) {
        Customer newCust = new Customer(customerId, name, address, email);
        customerRepo.addCustomer(newCust);
        System.out.println("\t\tCustomer added: " + name);
    }

    public void updateCustomer(String customerId) {
        Customer customerToUpdate = customerRepo.searchCustomer(customerId);
        if (customerToUpdate == null) {
            System.out.println("\t\tCustomer ID not found.");
            return;
        }

        System.out.println("\t\tCustomer found: ");
        customerToUpdate.displayInfo();

        Scanner sc = new Scanner(System.in);
        System.out.println("\t\tWhich field would you like to update?");
        System.out.println("\t\t1. Name");
        System.out.println("\t\t2. Address");
        System.out.println("\t\t3. Email");
        System.out.println("\t\t4. All Fields");
        System.out.print("\t\tEnter your choice: ");
        int updateChoice = sc.nextInt();
        sc.nextLine(); 

        switch (updateChoice) {
            case 1 -> {
                System.out.print("\t\tEnter new name: ");
                String newName = sc.nextLine();
                customerToUpdate.setName(newName);
                System.out.println("\t\tCustomer name updated.");
            }
            case 2 -> {
                System.out.print("\t\tEnter new address: ");
                String newAddress = sc.nextLine();
                customerToUpdate.setAddress(newAddress);
                System.out.println("\t\tCustomer address updated.");
            }
            case 3 -> {
                System.out.print("\t\tEnter new email: ");
                String newEmail = sc.nextLine();
                customerToUpdate.setEmail(newEmail);
                System.out.println("\t\tCustomer email updated.");
            }
            case 4 -> {
                System.out.print("\t\tEnter new name: ");
                String updatedName = sc.nextLine();
                System.out.print("\t\tEnter new address: ");
                String updatedAddress = sc.nextLine();
                System.out.print("\t\tEnter new email: ");
                String updatedEmail = sc.nextLine();
                customerToUpdate.setName(updatedName);
                customerToUpdate.setAddress(updatedAddress);
                customerToUpdate.setEmail(updatedEmail);
                System.out.println("\t\tAll fields updated.");
            }
            default -> System.out.println("\t\tInvalid choice.");
        }
    }

    public void viewCustomer(String customerId) {
        Customer customerToView = customerRepo.searchCustomer(customerId);
        if (customerToView == null) {
            System.out.println("\t\tCustomer ID not found.");
        } else {
            customerToView.displayInfo();
        }
    }

    public void deleteCustomer(String customerId) {
        Customer customerToDelete = customerRepo.searchCustomer(customerId);
        if (customerToDelete != null) {
            customerRepo.removeCustomer(customerToDelete);
            System.out.println("\t\tCustomer deleted.");
        } else {
            System.out.println("\t\tCustomer ID not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =========================================================================
        // RESTORED LOGIN VERIFICATION SYSTEMS
        // =========================================================================
        System.out.println("\t\t--------------------------------------------------");
        System.out.println("\t\t      SUPERMARKET MANAGEMENT SYSTEM LOGIN         ");
        System.out.println("\t\t--------------------------------------------------");
        System.out.print("\t\tEnter Username: ");
        String username = sc.nextLine();
        System.out.print("\t\tEnter Password: ");
        String password = sc.nextLine();

        if (!username.equalsIgnoreCase("admin") || !password.equals("admin123")) {
            System.out.println("\t\tAccess Denied! Invalid credentials logic matched.");
            System.exit(0);
        }
        System.out.println("\t\tAccess Granted! Loading system dashboard structures...");

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        PaymentMethod pm = new CashPayment(); 
        SuperMarket supermarket = new SuperMarket(items, customers, pm);
        LowStockService lowStockService = new LowStockService();
        BillingSystem billingSystem = new BillingSystem();

        while (true) {
            System.out.println("\n\t\t* * * * * * * * * * * * * * * * * * * * * * * * * ");
            System.out.println("\t\t* * * * Welcome to the Supermarket Main Menu * * *");
            System.out.println("\t\t* * * * * * * * * * * * * * * * * * * * * * * * * ");
            System.out.println("\t\t| 1) Customer  |\n\t\t| 2) Inventory |\n\t\t| 3) Billing   |\n\t\t| 4) Exit      |\n\t\t| Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    boolean customerMenuActive = true;
                    while (customerMenuActive) {
                        System.out.println("\n\t\tCustomer Management:");
                        System.out.println("\t\t1. Add Customer");
                        System.out.println("\t\t2. Update Customer");
                        System.out.println("\t\t3. View Customer");
                        System.out.println("\t\t4. Delete Customer");
                        System.out.println("\t\t5. Search Customer");
                        System.out.println("\t\t6. Back to Main Menu");
                        System.out.print("\t\tEnter your choice: ");
                        int customerChoice = sc.nextInt();
                        sc.nextLine();

                        switch (customerChoice) {
                            case 1 -> {
                                String customerId = "";
                                while (true) {
                                    try {
                                        System.out.print("\t\tEnter Customer ID (integer): ");
                                        customerId = sc.nextLine();
                                        if (customerId == null || customerId.isEmpty()) {
                                            throw new IllegalArgumentException("Customer ID is required.");
                                        }
                                        Integer.parseInt(customerId);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("\t\tError: Customer ID must be a valid integer.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("\t\tError: " + e.getMessage());
                                    }
                                }
                                System.out.println("\t\tCustomer ID accepted: " + customerId);

                                String name = "";
                                while (true) {
                                    try {
                                        System.out.print("\t\tEnter Customer Name: ");
                                        name = sc.nextLine();
                                        if (name == null || name.isEmpty()) {
                                            throw new IllegalArgumentException("Customer Name is required.");
                                        }
                                        if (name.matches(".*\\d.*")) {
                                            throw new IllegalArgumentException("Customer Name cannot contain numbers.");
                                        }
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("\t\tError: " + e.getMessage());
                                    }
                                }
                                System.out.println("\t\tCustomer Name accepted: " + name);

                                String address = "";
                                while (true) {
                                    try {
                                        System.out.print("\t\tEnter Customer Address: ");
                                        address = sc.nextLine();
                                        if (address == null || address.isEmpty()) {
                                            throw new IllegalArgumentException("Customer Address is required.");
                                        }
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("\t\tError: " + e.getMessage());
                                    }
                                }
                                System.out.println("\t\tCustomer Address accepted: " + address);

                                String email = "";
                                while (true) {
                                    try {
                                        System.out.print("\t\tEnter Customer Email: ");
                                        email = sc.nextLine();
                                        if (email == null || email.isEmpty()) {
                                            throw new IllegalArgumentException("Email is required.");
                                        }
                                        if (!email.contains("@") || !email.contains(".")) {
                                            throw new IllegalArgumentException("Email must contain '@' and '.'.");
                                        }
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("\t\tError: " + e.getMessage());
                                    }
                                }
                                System.out.println("\t\tCustomer Email accepted: " + email);
                                supermarket.addCustomer(customerId, name, address, email);
                            }
                            case 2 -> {
                                System.out.print("\t\tEnter customer ID to update: ");
                                String updateId = sc.nextLine();
                                supermarket.updateCustomer(updateId);
                            }
                            case 3 -> {
                                System.out.print("\t\tEnter customer ID to view: ");
                                String viewId = sc.nextLine();
                                supermarket.viewCustomer(viewId);
                            }
                            case 4 -> {
                                System.out.print("\t\tEnter customer ID to delete: ");
                                String deleteId = sc.nextLine();
                                supermarket.deleteCustomer(deleteId);
                            }
                            case 5 -> {
                                System.out.print("\t\tEnter customer ID to search: ");
                                String searchId = sc.nextLine();
                                supermarket.viewCustomer(searchId);
                            }
                            case 6 -> customerMenuActive = false;
                            default -> System.out.println("\t\tInvalid choice.");
                        }
                    }
                }
                case 2 -> {
                    boolean inventoryMenuActive = true;
                    while (inventoryMenuActive) {
                        System.out.println("\n\t\tInventory Management:");
                        System.out.println("\t\t1. Add Item");
                        System.out.println("\t\t2. View Items");
                        System.out.println("\t\t3. Update Item");
                        System.out.println("\t\t4. Delete Item");
                        System.out.println("\t\t5. Search Item");
                        System.out.println("\t\t6. Check Low Stock Items");
                        System.out.println("\t\t7. Back to Main Menu");
                        System.out.print("\t\tEnter your choice: ");
                        int inventoryChoice = sc.nextInt();
                        sc.nextLine();

                        switch (inventoryChoice) {
                            case 1 -> {
                                System.out.print("\t\tEnter item name: ");
                                String itemName = sc.nextLine();
                                System.out.print("\t\tEnter item price: ");
                                double itemPrice = sc.nextDouble();
                                System.out.print("\t\tEnter item quantity: ");
                                int itemQuantity = sc.nextInt();
                                supermarket.addItem(itemName, itemPrice, itemQuantity);
                            }
                            case 2 -> supermarket.viewItems();
                            case 3 -> {
                                System.out.print("\t\tEnter item name to update: ");
                                String itemToUpdate = sc.nextLine();
                                supermarket.updateItem(itemToUpdate);
                            }
                            case 4 -> {
                                System.out.print("\t\tEnter item name to delete: ");
                                String itemToDelete = sc.nextLine();
                                supermarket.deleteItem(itemToDelete);
                            }
                            case 5 -> {
                                System.out.print("\t\tEnter item name to search: ");
                                String searchItemName = sc.nextLine();
                                Item foundItem = supermarket.searchItem(searchItemName);
                                if (foundItem != null) {
                                    foundItem.displayInfo();
                                } else {
                                    System.out.println("\t\tItem not found.");
                                }
                            }
                            case 6 -> lowStockService.checkLowStock(items);
                            case 7 -> inventoryMenuActive = false;
                            default -> System.out.println("\t\tInvalid choice.");
                        }
                    }
                }
                case 3 -> {
                    // =========================================================================
                    // ASK FOR CUSTOMER ID AS SOON AS USER SELECTS BILLING (OPENS OPTION 3)
                    // =========================================================================
                    System.out.print("\t\tEnter Customer ID to open Billing Session: ");
                    String accessId = sc.nextLine();
                    Customer activeCustomer = supermarket.customerRepo.searchCustomer(accessId);

                    if (activeCustomer == null) {
                        System.out.println("\t\tAccess Denied: Customer ID not found inside database registry!");
                        break; // Immediately drops out of case 3 and heads back to the Main Menu
                    }

                    System.out.println("\t\tAccess Granted: Billing started for " + activeCustomer.getName());
                    // =========================================================================

                    while (true) {
                        System.out.println("\n\t\tBilling System:");
                        System.out.println("\t\t1. Add Item to Cart");
                        System.out.println("\t\t2. View Cart");
                        System.out.println("\t\t3. Update Cart Quantity ");
                        System.out.println("\t\t4. Remove Item from Cart ");
                        System.out.println("\t\t5. Generate Bill & Pay");
                        System.out.println("\t\t6. Back to Main Menu");
                        System.out.print("\t\tEnter your choice: ");
                        int billingChoice = sc.nextInt();
                        sc.nextLine();

                        if (billingChoice == 6) break;

                        switch (billingChoice) {
                            case 1 -> {
                                System.out.print("\t\tEnter Item Name: ");
                                String cartItemName = sc.nextLine();
                                Item cartItem = supermarket.searchItem(cartItemName);
                                if (cartItem != null) {
                                    System.out.print("\t\tEnter Quantity: ");
                                    int cartQuantity = sc.nextInt();
                                    
                                    if (cartQuantity <= cartItem.getQuantity()) {
                                        billingSystem.addItem(cartItem, cartQuantity);
                                    } else {
                                        System.out.println("\t\tError: Insufficient Stock! Only " + cartItem.getQuantity() + " items left.");
                                    }
                                } else {
                                    System.out.println("\t\tItem not found.");
                                }
                            }
                            case 2 -> billingSystem.viewItems();
                            case 3 -> { 
                                System.out.print("\t\tEnter Item Name to alter: ");
                                String targetName = sc.nextLine();
                                Item mainStock = supermarket.searchItem(targetName);
                                if (mainStock != null) {
                                    System.out.print("\t\tEnter New Quantity: ");
                                    int targetQty = sc.nextInt();
                                    if (targetQty <= mainStock.getQuantity()) {
                                        billingSystem.updateCartQuantity(targetName, targetQty);
                                    } else {
                                        System.out.println("\t\tError: Inventory cannot support that level of stock.");
                                    }
                                } else {
                                    System.out.println("\t\tItem not matching system data.");
                                }
                            }
                            case 4 -> { 
                                System.out.print("\t\tEnter Item Name to remove: ");
                                String removeName = sc.nextLine();
                                billingSystem.removeItemFromCart(removeName);
                            }
                            case 5 -> {
                                if(billingSystem.getCartItems().isEmpty()) {
                                    System.out.println("\t\tCannot generate payment totals for empty carts.");
                                    break;
                                }

                                double totalAmount = billingSystem.generateBill();
                                System.out.println("\n\t\tSelect Payment Method:");
                                System.out.println("\t\t1. Cash ");
                                System.out.println("\t\t2. Credit/Debit Card ");
                                System.out.println("\t\t3. Digital Wallet");
                                System.out.print("\t\tEnter your choice: ");
                                int paymentChoice = sc.nextInt();
                                sc.nextLine();

                                if (paymentChoice == 2) {
                                   supermarket.paymentMethod = new CardPayment();
                                }
                                else if (paymentChoice == 3) {
                                    supermarket.paymentMethod = new DigitalWalletPayment();
                                }
                                else {
                                    supermarket.paymentMethod = new CashPayment();
                                }
                                supermarket.paymentMethod.processPayment(totalAmount);
                                
                                billingSystem.deductStock(supermarket.inventoryRepo);
                                System.out.println("\t\tInventory tracking system updated successfully.");
                            }
                            default -> System.out.println("\t\tInvalid choice.");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("\t\tThank you for using the Supermarket Management System!");
                    System.exit(0);
                }
                default -> System.out.println("\t\tInvalid choice.");
            }
        }
    }
}
