package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.Passenger;

import java.util.ArrayList;
import java.util.List;


public class ConcreteFlightOrderBuilder implements FlightOrderBuilder {

    private FlightOrder order;

    public ConcreteFlightOrderBuilder(List<ScheduledFlight> flights) {
        this.order = new FlightOrder(flights);
    }

    @Override
    public void setCustomer(Customer customer) {
        order.setCustomer(customer);
    }

    @Override
    public void setPassengers(List<String> passengerNames) {
        List<Passenger> passengers = new ArrayList<>();
        passengerNames.forEach(name -> passengers.add(new Passenger(name)));
        order.setPassengers(passengers);
        order.getScheduledFlights().forEach(scheduledFlight -> scheduledFlight.addPassengers(passengers));
    }

    @Override
    public void setPrice(double price) {
        order.setPrice(price);
    }

    @Override
    public FlightOrder build() {
        return order;
    }
    
}
