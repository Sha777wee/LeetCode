package problem518;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/16
 */
public class Problem518 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int num = scanner.nextInt();
        int[] coins = new int[num];
        for (int i = 0; i < num; i++) {
            coins[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.change(amount, coins));
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        // dp[i][j]代表使用前i个硬币，组成金额j的方法数
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) dp[i][0] = 1;
        for (int i = 0; i <= amount; i++) dp[0][i] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}