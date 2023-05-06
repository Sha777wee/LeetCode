package problem16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, target));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int distance = Math.abs(sum - target);
                if (distance < min) {
                    min = distance;
                    result = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}