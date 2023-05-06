package problem946;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem946 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] pushed = new int[num];
        int[] popped = new int[num];
        for (int i = 0; i < num; i++) {
            pushed[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            popped[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushed.length || stack.size() > 0 && stack.peek() == popped[popIndex]) {
            if (stack.size() > 0 && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
                continue;
            }
            stack.push(pushed[pushIndex]);
            pushIndex++;
        }
        if (popIndex == popped.length) {
            return true;
        }
        return false;
    }
}