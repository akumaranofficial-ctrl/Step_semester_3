package string.class_problems;
import java.util.Random;

public class CorporateWellnessProgram {

    // Classify health status based on BMI value
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Generate and print the wellness report table
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid data: Array lengths must match.");
            return;
        }

        System.out.println("==========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-12.2f | %-12.2f | %-10.2f | %-12s%n",
                    "Person " + (i + 1), h, w, bmi, status);
        }

        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        // 1. Verification with sample inputs from the slide
        System.out.println("--- Sample Inputs Verification ---");
        double[] sampleHeights = {1.75, 1.60};
        double[] sampleWeights = {70.0, 90.0};
        printWellnessReport(sampleHeights, sampleWeights);

        // 2. Demo with a team of 10 people using random values
        System.out.println("\n--- Live Demo: Team of 10 ---");
        int teamSize = 10;
        double[] teamHeights = new double[teamSize];
        double[] teamWeights = new double[teamSize];

        Random rand = new Random();
        for (int i = 0; i < teamSize; i++) {
            // Height between 1.50 m and 1.95 m
            teamHeights[i] = 1.50 + (rand.nextDouble() * 0.45);
            // Weight between 45.0 kg and 110.0 kg
            teamWeights[i] = 45.0 + (rand.nextDouble() * 65.0);
        }

        printWellnessReport(teamHeights, teamWeights);
    }
}
