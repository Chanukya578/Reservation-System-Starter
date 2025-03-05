package flight.reservation.planeFactory;

import flight.reservation.Aircraft;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

public class AircraftFactory {
    public static Aircraft createAircraft(String type, String model) {
        switch (type) {
            case "Helicopter":
                return new Helicopter(model);
            case "PassengerDrone":
                return new PassengerDrone(model);
            case "PassengerPlane":
                return new PassengerPlane(model);
            default:
                throw new IllegalArgumentException("Unknown aircraft type");
        }
    }
}