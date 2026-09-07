package String4.assignment_problems;
import java.util.*;

public class threesum {

    static int[][] threeSum(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        ArrayList<int[]> result = new ArrayList<>();

        // Step 2: Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    // Found a valid triplet
                    result.add(new int[]{
                            nums[i],
                            nums[left],
                            nums[right]
                    });

                    // Skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                }
                else if (sum < 0) {

                    // Need a bigger sum
                    left++;

                }
                else {

                    // Need a smaller sum
                    right--;
                }
            }
        }

        // Convert ArrayList<int[]> to int[][]
        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        System.out.println(Arrays.deepToString(result));
    }
}

