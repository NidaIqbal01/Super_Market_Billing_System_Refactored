public class Customer {
    private final String customerId;
    private String name;
    private String address;
    private String email;

    public Customer(String customerId, String name, String address, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void displayInfo() {
        System.out.println("\t\tID: " + customerId + " | Name: " + name + " | Address: " + address + " | Email: " + email);
    }
}
