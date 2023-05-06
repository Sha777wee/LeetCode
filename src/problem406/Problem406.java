package problem406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem406 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] people = new int[num][2];
        for (int i = 0; i < num; i++) {
            people[i][0] = scanner.nextInt();
            people[i][1] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int[][] result = solution.reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            // 先根据hi倒序排列
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            }
            // 再根据ki正序排列
            return p1[1] - p2[1];
        });
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] pi = people[i];
            // 根据ki进行插入
            result.add(pi[1], pi);
        }
        return result.toArray(new int[people.length][]);
    }
}
