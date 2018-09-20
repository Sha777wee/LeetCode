package problem7;

import java.util.Scanner;

public class Problem7 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }
}
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            //数值溢出，直接返回0
            if (Math.abs(result) > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
