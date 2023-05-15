package problem392;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/15
 */
public class Problem392 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s, t));
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (j < t.length()) {
            if (i == s.length()) return true;
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        if (i == s.length()) return true;
        return false;
    }
}