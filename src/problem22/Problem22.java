package problem22;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(n));
    }
}

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder cur, int n, int lefNum, int rightNum) {
        if (cur.length() == 2 * n) {
            result.add(cur.toString());
            return;
        }
        if (lefNum < n) {
            cur.append("(");
            dfs(result, cur, n, lefNum + 1, rightNum);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (rightNum < lefNum) {
            cur.append(")");
            dfs(result, cur, n, lefNum, rightNum + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}