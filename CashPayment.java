public class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("\t\tProcessing cash payment of $" + amount);
        System.out.println("\t\tPayment successful via Cash.");
    }
}
