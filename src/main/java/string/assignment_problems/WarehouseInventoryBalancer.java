package string.assignment_problems;
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Edge case: if arrays are empty
        if (sectionA == null || sectionB == null || sectionA.length == 0) {
            System.out.println("No inventory data provided.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        // Initialize tracking for the maximum value
        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        // Traverse Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
        }

        // Traverse Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            // Uses strict '>' so Section A keeps priority in case of ties
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        // Determine balance status
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Display results (Item number is 1-based index: maxIndex + 1)
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxIndex + 1);
    }

    public static void main(String[] args) {
        // Test case from sample
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}