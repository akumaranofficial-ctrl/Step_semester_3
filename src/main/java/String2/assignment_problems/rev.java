package String2.assignment_problems;
public class rev {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder sb = new StringBuilder(word);

            sb.reverse();

            result.append(sb);
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}