package flight.reservation.payment;

public class CreditCardPayment implements PaymentStrategy {
    private CreditCard card;

    public CreditCardPayment(CreditCard card) {
        this.card = card;
    }

    @Override
    public boolean pay(double amount) {
        if (card.isValid()) {
            System.out.println("Paying " + amount + " using Credit Card.");
            double remainingAmount = card.getAmount() - amount;
            if (card.getAmount() >= amount) {
                card.setAmount(remainingAmount);
                return true;
            } else {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
        } else {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
    }
}
