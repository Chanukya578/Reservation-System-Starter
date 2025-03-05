package flight.reservation.payment;

public class PaypalStrategy implements PaymentInterface{
    private final String email;
    private final String password;

    PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        if (email.equals(Paypal.DATA_BASE.get(password))) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }
}