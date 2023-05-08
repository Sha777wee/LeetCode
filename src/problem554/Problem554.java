package problem554;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem554 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        List<List<Integer>> wall = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            int y = scanner.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                temp.add(scanner.nextInt());
            }
            wall.add(temp);
        }

        Solution solution = new Solution();
        System.out.println(solution.leastBricks(wall));
    }
}

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int length = 0;
            List<Integer> temp = wall.get(i);
            for (int j = 0; j < temp.size() - 1; j++) {
                length += temp.get(j);
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
        }
        int max = 0;
        for (Integer sum : map.values()) {
            max = Math.max(max, sum);
        }
        return wall.size() - max;
    }
}