package problem144;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/5
 */
public class Problem144 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] values = new String[num];
        for (int i = 0; i < num; i++) {
            values[i] = scanner.next();
        }
        TreeNode root = buildTree(0, values);

        Solution solution = new Solution();
        System.out.println(solution.preOrderTraversal(root));
    }

    // 该构造方法需要把所有层节点存入values，包括null
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
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
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
