package problem1091;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem1091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] grid = new int[num][];
        for (int i = 0; i < num; i++) {
            int[] temp = new int[num];
            for (int j = 0; j < num; j++) {
                temp[j] = scanner.nextInt();
            }
            grid[i] = temp;
        }

        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        Queue<Point> queue = new LinkedList();
        Set<Point> visited = new HashSet<>();

        Point start = new Point(0, 0);
        Point target = new Point(grid.length - 1, grid.length - 1);
        queue.offer(start);
        visited.add(start);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.equals(target)) return step;

                for (int operatorX = -1; operatorX <= 1; operatorX++) {
                    for (int operatorY = -1; operatorY <= 1; operatorY++) {
                        int nextX = point.x + operatorX;
                        int nextY = point.y + operatorY;
                        Point nextPoint = new Point(nextX, nextY);
                        if (isValidPoint(nextX, nextY, grid) && !visited.contains(nextPoint)) {
                            queue.offer(nextPoint);
                            visited.add(nextPoint);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isValidPoint(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 0;
    }

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
