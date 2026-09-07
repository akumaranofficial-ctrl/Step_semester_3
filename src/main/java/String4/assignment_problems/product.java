package String4.assignment_problems;
public class product {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        // Forward pass: calculate left products
        int left = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = left;

            left = left * nums[i];
        }

        // Backward pass: multiply by right products
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * right;

            right = right * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
