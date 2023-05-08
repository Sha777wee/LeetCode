package problem494;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        return findTargetSumWays(Arrays.copyOfRange(nums, 1, nums.length), target - nums[0]) +
                findTargetSumWays(Arrays.copyOfRange(nums, 1, nums.length), target + nums[0]);

    }
}