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

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return determinePassengerCapacity(this.model);
    }

    @Override
    public int getCrewCapacity() {
        return determineCrewCapacity(this.model);
    }
}

// public class PassengerPlane {

//     public String model;
//     public int passengerCapacity;
//     public int crewCapacity;

//     public PassengerPlane(String model) {
//         this.model = model;
//         switch (model) {
//             case "A380":
//                 passengerCapacity = 500;
//                 crewCapacity = 42;
//                 break;
//             case "A350":
//                 passengerCapacity = 320;
//                 crewCapacity = 40;
//                 break;
//             case "Embraer 190":
//                 passengerCapacity = 25;
//                 crewCapacity = 5;
//                 break;
//             case "Antonov AN2":
//                 passengerCapacity = 15;
//                 crewCapacity = 3;
//                 break;
//             default:
//                 throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
//         }
//     }
// }
