package problem1129;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem1129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[][] redEdges = new int[num][];
        for (int i = 0; i < num; i++) {
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            redEdges[i] = temp;
        }
        num = scanner.nextInt();
        int[][] bludEdges = new int[num][];
        for (int i = 0; i < num; i++) {
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            bludEdges[i] = temp;
        }

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(n, redEdges, bludEdges)));
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        // 预处理边，后面方便根据0、1下标切换颜色
        List<int[][]> edge = new ArrayList<>();
        edge.add(redEdges);
        edge.add(blueEdges);

        // 存储当前边和颜色
        Queue<Edge> queue = new LinkedList<>();
        Set<Edge> visited = new HashSet<>();
        // 起点既可以是蓝色也可以是红色
        queue.offer(new Edge(0, 0));
        queue.offer(new Edge(0, 1));
        visited.add(new Edge(0, 0));
        visited.add(new Edge(0, 1));
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Edge cur = queue.poll();
                // 对color取反
                int color = cur.color ^ 1;
                for (int j = 0; j < edge.get(color).length; j++) {
                    // 找到当前节点的一条边
                    if (cur.n == edge.get(color)[j][0]) {
                        Edge nextEdge = new Edge(edge.get(color)[j][1], color);
                        // 如果这条边没有走过，则入队
                        if (!visited.contains(nextEdge)) {
                            queue.offer(nextEdge);
                            visited.add(nextEdge);
                            if (result[nextEdge.n] == -1) {
                                result[nextEdge.n] = step;
                            }
                        }
                    }
                }
            }
            step++;
        }

        return result;
    }

    class Edge {
        public int n;
        public int color;

        public Edge(int n, int color) {
            this.n = n;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return n == edge.n && color == edge.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, color);
        }
    }
}
