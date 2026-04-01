import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * ============================================================
 *
 * Use Case 10: Count Total Seats in Train
 *
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 */
public class UseCase10TrainConsistMgmt {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // Reusable aggregation logic for testability
    static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("========================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Aggregate using map + reduce
        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("\nUC10 aggregation completed...");
    }
}
