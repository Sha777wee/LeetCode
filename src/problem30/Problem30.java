package problem30;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int num = scanner.nextInt();
        String[] words = new String[num];
        for (int i = 0; i < num; i++) {
            words[i] = scanner.next();
        }

        Solution solution = new Solution();
        System.out.println(solution.findSubstring(str, words));
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;
        int wordLength = words[0].length();
        int num = words.length;
        int matchLength = wordLength * num;

        for (int i = 0; i <= s.length() - matchLength; i++) {
            // 定义map记录words以及出现次数
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            for (int j = 0; j < matchLength; j += wordLength) {
                String str = s.substring(i + j, i + j + wordLength);
                // 如果匹配到word，则次数-1，直到次数为0移出map
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) - 1);
                    if (map.get(str) == 0) {
                        map.remove(str);
                    }
                } else break;
            }
            // map为空，说明word全部匹配到了
            if (map.size() == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
