package problem752;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem752 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] deadEnds = new String[num];
        for (int i = 0; i < num; i++) {
            deadEnds[i] = scanner.next();
        }
        String target = scanner.next();

        Solution solution = new Solution();
        System.out.println(solution.openLock2(deadEnds, target));
    }
}

class Solution {

    // 单向BFS解法
    public int openLock(String[] deadEnds, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        // 使用set记录死亡密码，方便查询
        Set<String> deadEndSet = new HashSet<>();
        for (int i = 0; i < deadEnds.length; i++) {
            deadEndSet.add(deadEnds[i]);
        }

        // 使用set记录已走过的路径，避免循环
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;

        while (queue.size() > 0) {
            // 先记录size，如果放在for里面，size会改变
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 取出队首元素
                String cur = queue.poll();
                if (deadEndSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        // 穷举完后还是找不到就是不存在，返回-1
        return -1;
    }

    // 双向BFS解法,必须知道起点和终点
    public int openLock2(String[] deadEnds, String target) {
        // 使用set记录扩散结果，而不使用queue，方便查找
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("0000");
        set2.add(target);

        // 使用set记录死亡密码，方便查询
        Set<String> deadEndSet = new HashSet<>();
        for (int i = 0; i < deadEnds.length; i++) {
            deadEndSet.add(deadEnds[i]);
        }

        // 使用set记录已走过的路径，避免循环
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;

        while (set1.size() > 0 || set2.size() > 0) {
            // 哈希集合在遍历的过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<>();
            for (String cur : set1) {
                if (deadEndSet.contains(cur)) {
                    continue;
                }
                if (set2.contains(cur)) {
                    return step;
                }

                // 已走过的路径需要在这里记录，不能在下面记录，否则的话set1和set2永远没有相同的元素
                // 而set1和set2拥有相同的元素代表找到一条路径
                visited.add(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);

                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            // temp相当于set1扩散结果
            // 这里交换set1、set2，下一轮就是扩散set2
            set1 = set2;
            set2 = temp;
        }
        // 穷举完后还是找不到就是不存在，返回-1
        return -1;
    }

    // 向上拨动一次
    private String plusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    // 向下拨动一次
    private String minusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }
}