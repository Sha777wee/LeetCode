package problem3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by shawee on 2018/7/29
 */
public class Probleam3 {
    public static void main(String [] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] mark = new int[256];
        Arrays.fill(mark, -1);
        int left = -1;
        int length = 0;
        for (int i = 0 ; i < s.length(); i++){
            //若mark[s.charAt(i)]<0,说明该字符未出现过；若0=<mark[s.charAt(i)]<=left,
            //说明该字符出现过，但已经处理过，不在字串内了；若mark[s.charAt(i)]>left,
            //说明该字符在字串内，需要更新子串起始位置left
            left = Math.max(left, mark[s.charAt(i)]);
            mark[s.charAt(i)] = i;
            //为什么不是（i - left）+1？因为left记录的是上一次该字符出现的位置
            length = Math.max(length , i - left);
        }
        return length;
    }
}