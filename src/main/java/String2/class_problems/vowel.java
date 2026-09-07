package String2.class_problems;
public class vowel {

    static void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Convert uppercase to lowercase
            ch = Character.toLowerCase(ch);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {

                vowels++;
            }
            else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels +
                " | Consonants: " + consonants);
    }

    public static void main(String[] args) {

        countVowelsAndConsonants("Java Programming");
    }
}
