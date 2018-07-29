package problem1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by shawee on 2018/7/29
 */
public class Problem1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
//利用HashMap查找效率是常数级的特性,能很快的找到对应的数
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] rtn = new int[2];
        for (int i = 0 ; i < nums.length ; i++ ) {
            if (map.containsKey(target-nums[i])) {
                rtn[0] = map.get(target-nums[i]);
                rtn[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return rtn;
    }
}
