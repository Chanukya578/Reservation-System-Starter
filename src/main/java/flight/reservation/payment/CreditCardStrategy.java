package flight.reservation.payment;

public class CreditCardStrategy implements PaymentInterface{
    private CreditCard card;

    CreditCardStrategy(CreditCard card) {
        this.card = card;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
        double remainingAmount = card.getAmount() - amount;
        if (remainingAmount < 0) {
            System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
            throw new IllegalStateException("Card limit reached");
        }
        card.setAmount(remainingAmount);
        return true;
    }

}