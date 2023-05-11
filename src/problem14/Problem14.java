package problem14;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = scanner.next();
        }

        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}