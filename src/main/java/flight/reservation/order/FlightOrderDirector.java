package flight.reservation.order;

import flight.reservation.Customer;

import java.util.List;

public class FlightOrderDirector {
    private FlightOrderBuilder builder;

    public FlightOrderDirector(FlightOrderBuilder builder) {
        this.builder = builder;
    }

    public void construct(Customer customer, List<String> passengers, double price) {
        builder.setCustomer(customer);
        builder.setPrice(price);
        builder.setPassengers(passengers);
    }
}
