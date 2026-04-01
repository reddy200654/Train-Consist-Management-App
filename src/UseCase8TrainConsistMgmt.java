import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ============================================================
 * MAIN CLASS - UseCase8TrainConsistMgmt
 * ============================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating capacity
 * using Java Stream API.
 */
public class UseCase8TrainConsistMgmt {

    // Reusing Bogie model style from UC7
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    // Reusable filter logic for testability and clarity
    static List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("========================================\n");

        // Create list of passenger bogies (same style as UC7)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Premium AC", 80));

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // Filter bogies with capacity > 60
        List<Bogie> filteredBogies = filterByCapacity(bogies, 60);

        System.out.println("\nFiltered Bogies (capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // Demonstrate original list integrity
        System.out.println("\nOriginal list size after filtering: " + bogies.size());
        System.out.println("Filtered list size: " + filteredBogies.size());

        System.out.println("\nUC8 stream filtering completed successfully...");
    }
}
