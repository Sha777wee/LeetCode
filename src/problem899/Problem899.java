package problem899;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem899 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.orderlyQueue(s, k));
    }
}

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuilder sb = new StringBuilder(s);
            String smallest = s;
            int len = s.length();
            for (int i = 0; i < len - 1; i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        } else {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }
}