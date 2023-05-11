package problem150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem150 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] tokens = new String[num];
        for (int i = 0; i < num; i++) {
            tokens[i] = scanner.next();
        }

        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            int sum = 0;
            if (tokens[i].equals("+")) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(a + b);
            } else if (tokens[i].equals("-")) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(b - a);
            } else if (tokens[i].equals("*")) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(a * b);
            } else if (tokens[i].equals("/")) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(b / a);
            } else {
                deque.push(Integer.valueOf(tokens[i]));
            }

        }
        return deque.poll();
    }
}