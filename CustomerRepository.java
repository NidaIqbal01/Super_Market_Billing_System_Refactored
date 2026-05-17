
package com.mycompany.supermarket;
import java.util.ArrayList;
class CustomerRepository {
    private final ArrayList<Customer> customers;

    public CustomerRepository(ArrayList<Customer> customers) { this.customers = customers; }

    public void addCustomer(Customer customer) { customers.add(customer); }
    
    // FIXED: Added missing method that caused Maven build to fail
    public void removeCustomer(Customer customer) { customers.remove(customer); }

    public Customer searchCustomer(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }
}
