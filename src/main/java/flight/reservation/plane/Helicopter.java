package flight.reservation.plane;

import flight.reservation.Aircraft;

public class Helicopter implements Aircraft {
    private String model;
    private int passengerCapacity;

    public Helicopter(String model) {
        this.model = model;
        this.passengerCapacity = determinePassengerCapacity(model);
    }

    private int determinePassengerCapacity(String model) {
        switch (model) {
            case "H1":
                return 4;
            case "H2":
                return 6;
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
        return passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return 2; // Assuming a standard crew capacity for helicopters
    }
}

// public class Helicopter {
//     private final String model;
//     private final int passengerCapacity;

//     public Helicopter(String model) {
//         this.model = model;
//         if (model.equals("H1")) {
//             passengerCapacity = 4;
//         } else if (model.equals("H2")) {
//             passengerCapacity = 6;
//         } else {
//             throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
//         }
//     }

//     public String getModel() {
//         return model;
//     }

//     public int getPassengerCapacity() {
//         return passengerCapacity;
//     }
// }