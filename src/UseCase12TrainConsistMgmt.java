import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * ============================================================
 * MAIN CLASS - UseCase12TrainConsistMgmt
 * ============================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces domain safety rules on goods bogies.
 */
public class UseCase12TrainConsistMgmt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    // Reusable safety validation method for testability
    static boolean isSafetyCompliant(List<GoodsBogie> goodsBogies) {
        // Cylindrical bogies must carry only Petroleum; other types are allowed any cargo.
        Predicate<GoodsBogie> safetyRule = b ->
                !"Cylindrical".equalsIgnoreCase(b.type) || "Petroleum".equalsIgnoreCase(b.cargo);

        return goodsBogies.stream().allMatch(safetyRule);
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("========================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b);
        }

        boolean isSafe = isSafetyCompliant(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}
