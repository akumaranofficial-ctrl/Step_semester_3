package String4.assignment_problems;
import java.util.HashMap;

public class subarray{

    static int subarraySum(int[] nums, int k) {

        int currentSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // Add current element
            currentSum += nums[i];

            // Check whether an earlier prefix exists
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // Store current prefix sum
            map.put(currentSum,
                    map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}
