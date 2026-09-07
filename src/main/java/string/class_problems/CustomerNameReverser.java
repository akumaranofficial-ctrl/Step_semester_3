package string.class_problems;
public class CustomerNameReverser {

    // Method to reverse the customer name without modifying the original
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // Two-pointer swap to reverse characters in an array
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";

        // Call method to get the reversed string
        String reversedName = reverseCustomerName(customerName);

        // Display both original and reversed names
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
