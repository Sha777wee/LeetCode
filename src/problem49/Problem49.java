package problem49;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/5
 */
public class Problem49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = scanner.next();
        }
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(new String(chars), new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
