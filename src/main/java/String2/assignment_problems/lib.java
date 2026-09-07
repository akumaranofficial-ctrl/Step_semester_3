package String2.assignment_problems;
public class lib {

    static String normalizeCode(String raw) {

        // Remove leading and trailing spaces
        String code = raw.trim();

        // Uppercase only first 3 characters
        String publisher = code.substring(0, 3).toUpperCase();

        // Keep remaining characters unchanged
        String rest = code.substring(3);

        return publisher + rest;
    }

    static String validateAndFormat(String code) {

        // Check total length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year/catalog must be digits";
            }
        }

        // Format output
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        return "[" + publisher + "] YEAR: " + year +
                " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}
