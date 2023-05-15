package problem292;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/15
 */
public class Problem292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.canWinNim(n));
    }
}

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}