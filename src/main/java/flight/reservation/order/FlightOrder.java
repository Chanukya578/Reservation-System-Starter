package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.CreditCard;
import flight.reservation.payment.Paypal;
import flight.reservation.payment.PaymentContext;
import flight.reservation.payment.PaymentStrategy;
import flight.reservation.payment.CreditCardPayment;
import flight.reservation.payment.PayPalPayment;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    static List<String> noFlyList = Arrays.asList("Peter", "Johannes");

    public FlightOrder(List<ScheduledFlight> flights) {
        this.flights = flights;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    private boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        boolean valid = true;
        valid = valid && !noFlyList.contains(customer.getName());
        valid = valid && passengerNames.stream().noneMatch(passenger -> noFlyList.contains(passenger));
        valid = valid && flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        return valid;
    }
    
    public boolean payOrder(String paymentMethod, Object... args) {
        if (isClosed()) {
            return true;
        }

        PaymentStrategy paymentStrategy;
        if (paymentMethod.equals("creditCard")) {
            if(args.length == 1 && args[0] instanceof CreditCard){
                CreditCard card = (CreditCard) args[0];
                paymentStrategy = new CreditCardPayment(card);
            } else {
                throw new IllegalArgumentException("Invalid credit card details.");
            }
        } else if (paymentMethod.equals("paypal")) { 
            if(args.length == 2 && args[0] instanceof String && args[1] instanceof String){
                String email = (String) args[0];
                String password = (String) args[1];
                paymentStrategy = new PayPalPayment(email, password);
            } else {
                throw new IllegalArgumentException("Invalid PayPal credentials.");
            }
        } else {
            throw new IllegalArgumentException("Invalid payment method.");
        }

        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(paymentStrategy);
        boolean isPaid = paymentContext.executePayment(this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

}
