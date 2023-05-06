package problem27;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, val));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}