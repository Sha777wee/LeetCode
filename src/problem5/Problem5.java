package problem5;

import java.util.Scanner;

/**
 * Created by shawee on 2018/7/29
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input =sc.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(input));
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int startIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            //1、回文串长度为单数的情况
            int step = 1;
            int length = 1;
            while ((i - step) >= 0 && (i + step) < s.length() && s.charAt(i - step) == s.charAt(i + step)) {
                step++;
                length = length + 2;
            }
            if (length > maxLength) {
                startIndex = i - step + 1;
                maxLength = length;
            }

            //2、回文串长度为双数的情况
            step = 1;
            length = 0;
            while ((i - step + 1) >= 0 && (i + step) < s.length() && s.charAt(i - step + 1) == s.charAt(i + step)) {
                step++;
                length = length + 2;
            }
            if (length > maxLength) {
                startIndex = i - step + 2;
                maxLength = length;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
