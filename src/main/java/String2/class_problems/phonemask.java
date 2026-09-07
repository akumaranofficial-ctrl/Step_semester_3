package String2.class_problems;
public class phonemask {

    static String maskPhoneNumber(String phone) {

        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String lastFour = phone.substring(6);

        // Create masked number
        StringBuilder result = new StringBuilder("XXXXXX");

        result.append("-");
        result.append(lastFour);

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(
                maskPhoneNumber("9876543210")
        );

        System.out.println(
                maskPhoneNumber("98765")
        );
    }
}