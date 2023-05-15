package problem792;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/15
 */
public class Problem792 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        Solution solution = new Solution();
        System.out.println(solution.numMatchingSubseq(s, words));
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] list = new ArrayList[256];
        for (int i = 0; i < s.length(); i++) {
            if (list[s.charAt(i)] == null) {
                list[s.charAt(i)] = new ArrayList<>();
            }
            list[s.charAt(i)].add(i);
        }

        int res = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (i < word.length()) {
                char c = word.charAt(i);
                if (list[c] == null) {
                    break;
                }
                int pos = search(list[c], j);
                if (pos == -1) {
                    break;
                }
                j = list[c].get(pos) + 1;
                i++;
            }
            if (i == word.length()) {
                res++;
            }
        }
        return res;
    }

    // 二分查找
    private int search(List<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > arr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == arr.size()) {
            return -1;
        }
        return left;
    }
}