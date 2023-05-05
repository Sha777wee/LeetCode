package problem6;

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numRows = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int row = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            stringBuilders[row].append(s.charAt(i));
            if (flag) row++;
            else row--;
            if (row == 0) flag = true;
            else if (row == numRows - 1) flag = false;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            result.append(stringBuilders[i]);
        }
        return result.toString();
    }
}