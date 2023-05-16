package problem416;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/16
 */
public class Problem416 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 如果和为奇数时，不可能划分两个相等的集合
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 1; i <= nums.length; i++) dp[i][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}