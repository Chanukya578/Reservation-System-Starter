package flight.reservation.plane;

import flight.reservation.Aircraft;

public class PassengerDrone implements Aircraft {
    private String model;

    public PassengerDrone(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return 4; // Example capacity
    }

    @Override
    public int getCrewCapacity() {
        return 0; // Drones do not have crew
    }
}

// public class PassengerDrone {
//     private final String model;

//     public PassengerDrone(String model) {
//         if (model.equals("HypaHype")) {
//             this.model = model;
//         } else {
//             throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
//         }
//     }
// }