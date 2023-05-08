package problem105;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] preOrder = new int[num];
        for (int i = 0; i < num; i++) {
            preOrder[i] = scanner.nextInt();
        }
        int[] inOrder = new int[num];
        for (int i = 0; i < num; i++) {
            inOrder[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        print(treeNode);
    }

    private static void print(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                System.out.println(treeNode.val);
            } else {
                System.out.println("null");
                continue;
            }
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }
    }
}

class Solution {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        // 前序遍历的第一个元素为根节点
        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
            }
        }
        return root;
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