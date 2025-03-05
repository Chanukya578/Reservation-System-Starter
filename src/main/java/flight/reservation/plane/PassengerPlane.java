package flight.reservation.plane;

import flight.reservation.Aircraft;

public class PassengerPlane implements Aircraft {
    private String model;
    private int passengerCapacity;
    private int crewCapacity;

    public PassengerPlane(String model) {
        this.model = model;
        this.passengerCapacity = determinePassengerCapacity(model);
        this.crewCapacity = determineCrewCapacity(model);
    }

    private int determinePassengerCapacity(String model) {
        switch (model) {
            case "A380":
                return 500;
            case "A350":
                return 320;
            case "Embraer 190":
                return 25;
            case "Antonov AN2":
                return 15;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    private int determineCrewCapacity(String model) {
        switch (model) {
            case "A380":
                return 42;
            case "A350":
                return 40;
            case "Embraer 190":
                return 5;
            case "Antonov AN2":
                return 3;
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

}
