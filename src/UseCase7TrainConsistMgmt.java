import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - UseCase7TrainConsistMgmt
 * ============================================================
 *
 * Use Case 7: Sort Bogies by Capacity
 *
 * Description:
 * This class sorts passenger bogies based on seating capacity
 * using a custom Comparator.
 */
public class UseCase7TrainConsistMgmt {

    // Bogie class to model passenger bogies
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

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("========================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        // Sort by capacity in ascending order using Comparator
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        System.out.println("\nUC7 sorting operations completed successfully...");
    }
}
