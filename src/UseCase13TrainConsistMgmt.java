import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ============================================================
 * MAIN CLASS - UseCase13TrainConsistMgmt
 * ============================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 */
public class UseCase13TrainConsistMgmt {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    static long measureLoopExecutionNanos(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterUsingLoop(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    static long measureStreamExecutionNanos(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterUsingStream(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("========================================\n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            int capacity = (i % 100) + 1; // 1..100
            String type = (i % 2 == 0) ? "Passenger" : "Goods";
            bogies.add(new Bogie(type, capacity));
        }

        int threshold = 60;

        // Measure loop-based filtering
        long loopTime = measureLoopExecutionNanos(bogies, threshold);

        // Measure stream-based filtering
        long streamTime = measureStreamExecutionNanos(bogies, threshold);

        // Verify consistency between both approaches
        List<Bogie> loopResult = filterUsingLoop(bogies, threshold);
        List<Bogie> streamResult = filterUsingStream(bogies, threshold);
        boolean sameSize = loopResult.size() == streamResult.size();

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        System.out.println("Results Match (size): " + sameSize);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}
