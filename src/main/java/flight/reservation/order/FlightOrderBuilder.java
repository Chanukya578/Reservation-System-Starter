package flight.reservation.order;

import java.util.List;

import flight.reservation.Customer;

public interface FlightOrderBuilder {
    void setCustomer(Customer customer);
    void setPassengers(List<String> passengerNames);
    void setPrice(double price);
    FlightOrder build();
}
