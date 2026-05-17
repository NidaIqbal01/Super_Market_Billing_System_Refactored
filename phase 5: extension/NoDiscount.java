package supermarket;

// Default behavior when no discount is applied
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double subtotal) {
        return 0;
    }
}
