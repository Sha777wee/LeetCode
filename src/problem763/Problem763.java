package problem763;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem763 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(s));
    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int index = 0;
        while (index < s.length()) {
            int max = s.lastIndexOf(s.charAt(index));
            // 只有一个字母，直接分割
            if (max == index) {
                result.add(1);
                index++;
                continue;
            }
            int temp = index + 1;
            while (temp < max) {
                max = Math.max(max, s.lastIndexOf(s.charAt(temp)));
                temp++;
            }
            result.add(temp - index + 1);
            index = temp + 1;
        }

        return result;
    }
}