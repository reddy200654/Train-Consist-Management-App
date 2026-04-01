import java.util.LinkedList;

/**
 * ============================================================
 * MAIN CLASS - UseCase4TrainConsistMgmt
 * ============================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models physical train chaining using LinkedList
 * for ordered insertion and removal operations.
 *
 * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 */
public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("========================================\n");

        // Create a LinkedList to represent ordered train chaining
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("After Initial Addition:");
        System.out.println("Train Consist : " + trainConsist + "\n");

        // Insert Pantry Car at position 2 (0-based index)
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println("Train Consist : " + trainConsist + "\n");

        // Remove first and last bogies
        String removedFirst = trainConsist.removeFirst();
        String removedLast = trainConsist.removeLast();

        System.out.println("Removed First Bogie : " + removedFirst);
        System.out.println("Removed Last Bogie  : " + removedLast + "\n");

        System.out.println("Final Ordered Train Consist:");
        System.out.println(trainConsist + "\n");

        System.out.println("UC4 linked-list operations completed successfully...");
    }
}
