/**
 * ============================================================
 * MAIN CLASS - UseCase14TrainConsistMgmt
 * ============================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This class prevents creation of passenger bogies with
 * invalid seating capacity using a custom exception.
 */
public class UseCase14TrainConsistMgmt {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("========================================\n");

        try {
            PassengerBogie valid = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + valid);

            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}
