package problem6;

import java.util.Scanner;

public class Problem6 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numRows = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }
}
class Solution {
    public String convert(String s, int numRows) {
        //如果只有一行直接返回原字符串
        if (numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        //相邻竖之间，同一行的字母相隔split个位置
        int split = (numRows - 1) * 2;
        //i代表行
        for (int i = 0; i < numRows && i < s.length(); i++) {
            //先添加第一竖上的字母，第一竖上的字母的位置和行数一样
            stringBuilder.append(s.charAt(i));
            int increase = 0;
            //如果这一行后面还有字母，继续添加。先加两竖中间的字母，再加后一竖上的字母。
            while (true) {
                increase = increase + split - 2 * i;
                //如果是最后一行，split-2*i=0，位置没有改变，该位置上的字母已经添加过了。
                if (i != numRows - 1) {
                    if ((i + increase) < s.length()) {
                        stringBuilder.append(s.charAt(i + increase));
                    } else break;
                }

                increase = increase + 2 * i;
                //如果是第一行，2*i=0，位置没有改变，该位置上的字母已经添加过了。
                if (i != 0) {
                    if ((i + increase) < s.length()) {
                        stringBuilder.append(s.charAt(i + increase));
                    } else break;
                }
            }
        }
        return stringBuilder.toString();
    }
}