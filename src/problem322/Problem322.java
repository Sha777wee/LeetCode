package problem322;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] coins = new int[num];
        for (int i = 0; i < num; i++) {
            coins[i] = scanner.nextInt();
        }
        int amount = scanner.nextInt();

        Solution solution = new Solution();
//        System.out.println(solution.coinChange(coins, amount));
        int[] memo = new int[amount + 1];
        // 填充一个不可能达到的数值
        Arrays.fill(memo, Integer.MIN_VALUE);
        System.out.println(solution.coinChange2(coins, amount, memo));
        System.out.println(solution.coinChange3(coins, amount));
    }
}

class Solution {

    // 穷举算法
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subResult = coinChange(coins, amount - coin);
            if (subResult == -1) continue;
            min = Math.min(min, subResult + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // 备忘录算法
    public int coinChange2(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != Integer.MIN_VALUE) return memo[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subResult = coinChange2(coins, amount - coin, memo);
            if (subResult == -1) continue;
            min = Math.min(min, subResult + 1);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    // 动态规划算法
    public int coinChange3(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable, Integer.MAX_VALUE);
        dpTable[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (dpTable[i - coin] == Integer.MAX_VALUE) continue;

                dpTable[i] = Math.min(dpTable[i], dpTable[i - coin] + 1);
            }
        }
        return dpTable[amount] == Integer.MAX_VALUE ? -1 : dpTable[amount];
    }
}