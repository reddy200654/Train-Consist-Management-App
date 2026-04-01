import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * MAIN CLASS - UseCase6TrainConsistMgmt
 * ============================================================
 *
 * Use Case 6: Map Bogie to Capacity
 *
 * Description:
 * This class associates each bogie with its seating or load
 * capacity using a key-value mapping structure.
 *
 * At this stage, the application:
 * - Creates a HashMap for bogie-capacity mapping
 * - Inserts capacity values for each bogie
 * - Iterates through map entries
 * - Displays bogie and capacity information
 */
public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("========================================\n");

        // HashMap stores data in key -> value format
        Map<String, Integer> capacityMap = new HashMap<>();

        // Insert bogie capacities
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 78);
        capacityMap.put("First Class", 24);

        System.out.println("Bogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        System.out.println("\nUC6 mapping operations completed successfully...");
    }
}
