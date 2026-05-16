public class StandardTaxCalculator implements TaxCalculator {
    private final double taxRate = 0.05; // 5% base fee

    @Override
    public double calculateTax(double subtotal) {
        return subtotal * taxRate;
    }
}
