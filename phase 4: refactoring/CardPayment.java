public class CardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("\t\tProcessing Credit/Debit card transaction for $" + amount);
        System.out.println("\t\tPayment authorized successfully via Card.");
    }
}
