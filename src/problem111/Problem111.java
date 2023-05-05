package problem111;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/5
 */
public class Problem111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] values = new String[num];
        for (int i = 0; i < num; i++) {
            values[i] = scanner.next();
        }
        TreeNode root = buildTree(0, values);

        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }

    public static TreeNode buildTree(int rootIndex, String[] values) {
        if (rootIndex >= values.length) {
            return null;
        }
        if ("null".equals(values[rootIndex])) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(values[rootIndex]));
        treeNode.left = buildTree(rootIndex * 2 + 1, values);
        treeNode.right = buildTree(rootIndex * 2 + 2, values);
        return treeNode;
    }
}


class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 1;
        while (queue.size() > 0) {
            // 先获取size，不然放到for里size会改变
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (Objects.isNull(node.left) && Objects.isNull(node.right)) return depth;
                if (Objects.nonNull(node.left)) queue.offer(node.left);
                if (Objects.nonNull(node.right)) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
