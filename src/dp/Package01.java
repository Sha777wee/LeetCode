package dp;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */

// 01背包问题
public class Package01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.function(m, weights, values, n));
    }
}

class Solution {

    public int function(int m, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < weights[i - 1]) {       // 当前背包容量小于第i个物品的重量，无法装第i个物品，注意下标，第i个物品的下标是i-1
                    dp[i][j] = dp[i - 1][j];
                } else {                        // 当前背包容量大于第i个物品的重量，可以选择装或不装
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
