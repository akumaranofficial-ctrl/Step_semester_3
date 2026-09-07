package string.class_problems;
import java.util.Arrays;

public class PalindromeChecker {

    // 1. Iterative Approach: Two-pointer comparison moving towards the center
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Recursive Approach: Recursively check edge characters and shrink substring
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;

        // Base case: 0 or 1 character left
        if (text.length() <= 1) {
            return true;
        }

        // Check first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recurse on the inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array Reversal Approach: Convert to char array, reverse it, and compare
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return Arrays.equals(original, reversed);
    }

    // Helper method to format the output matching the problem statement
    public static void verifyPalindrome(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        String iterRes = iter ? "Palindrome" : "Not Palindrome";
        String recRes = rec ? "Palindrome" : "Not Palindrome";
        String revRes = rev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                iterRes, recRes, revRes);
    }

    public static void main(String[] args) {
        // Test with sample inputs
        verifyPalindrome("madam");
        verifyPalindrome("hello");
    }
}
