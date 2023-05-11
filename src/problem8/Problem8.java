package problem8;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Solution solution = new Solution();
        System.out.println(solution.myAtoi(s));
    }
}

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        int index = 0;
        // 去除前缀空格
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if (index == s.length()) return 0;
        // 判断符号
        int sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long sum = 0;
        while (index < s.length() && isNumber(s.charAt(index))) {
            int number = s.charAt(index) - '0';
            if ((sum * 10 + number) * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if ((sum * 10 + number) * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + number;
            index++;
        }

        return (int) sum * sign;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}