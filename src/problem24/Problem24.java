package problem24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cards = new int[4];
        for (int i = 0; i < 4; i++) {
            cards[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.judgePoint24(cards));
    }
}

class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            nums.add((double) cards[i]);
        }
        return solution(nums);
    }

    private boolean solution(List<Double> nums) {
        if (nums.size() == 1) {
            // Double可能会有精度丢失
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                boolean isValid = false;
                List<Double> copy = new ArrayList<>(nums);
                // 需要先移除后面的元素，再移除前面的元素，否则可能数组越界
                double b = copy.remove(j);
                double a = copy.remove(i);


                // 加,第一次先add，扩充位置，后面的直接修改这个位置上面的值就行了
                copy.add(a + b);
                isValid = isValid || solution(copy);
                // 减
                copy.set(copy.size() - 1, a - b);
                isValid = isValid || solution(copy);

                copy.set(copy.size() - 1, b - a);
                isValid = isValid || solution(copy);
                // 乘
                copy.set(copy.size() - 1, a * b);
                isValid = isValid || solution(copy);
                // 除
                copy.set(copy.size() - 1, a / b);
                isValid = isValid || solution(copy);

                copy.set(copy.size() - 1, b / a);
                isValid = isValid || solution(copy);
                if (isValid) return true;
            }
        }
        return false;
    }

}