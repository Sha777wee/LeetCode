package problem55;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前下标大于之前所能跳到的最大小标，说明无法到达当前下标
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
