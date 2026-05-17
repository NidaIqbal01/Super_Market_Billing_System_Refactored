package supermarket;

// new feature: digital payment
public class DigitalWalletPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("\t\tProcessing Digital Wallet payment of $" + amount);
        System.out.println("\t\tPayment successful via EasyPaisa/JazzCash.");
    }
}
