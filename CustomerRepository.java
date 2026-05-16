import java.util.ArrayList;
public class CustomerRepository {
    private final ArrayList<Customer> customers;

    public CustomerRepository(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() { return customers; }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer searchCustomer(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}
