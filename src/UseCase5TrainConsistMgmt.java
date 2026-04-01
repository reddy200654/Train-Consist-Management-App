import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ============================================================
 * MAIN CLASS - UseCase5TrainConsistMgmt
 * ============================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while also preventing duplicate entries using LinkedHashSet.
 *
 * At this stage, the application:
 * - Attaches bogies in order
 * - Preserves insertion sequence
 * - Avoids duplicate bogies
 * - Displays final train formation
 */
public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies in sequence
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Intentional duplicate attachment (ignored automatically)
        formation.add("Sleeper");

        System.out.println("Final Train Formation (Ordered + Unique):");
        System.out.println(formation + "\n");

        System.out.println("Note:");
        System.out.println("Duplicate bogies are ignored by LinkedHashSet.");
        System.out.println("Insertion order is preserved in output.\n");

        System.out.println("UC5 ordered uniqueness validation completed...");
    }
}
