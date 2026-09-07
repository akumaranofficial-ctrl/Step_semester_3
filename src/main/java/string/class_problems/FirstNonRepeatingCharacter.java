package string.class_problems;
public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // ASCII frequency array (covers standard 256 ASCII characters)
        int[] freq = new int[256];

        // Pass 1: Compute the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Pass 2: Find the first character with a frequency of exactly 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch; // Early exit on the first unique character
            }
        }

        // No non-repeating character found
        return '\0';
    }

    public static void checkAndPrint(String text) {
        char result = findFirstNonRepeatingChar(text);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        // Test cases from the sample
        checkAndPrint("swiss");
        checkAndPrint("aabbcc");
    }
}
