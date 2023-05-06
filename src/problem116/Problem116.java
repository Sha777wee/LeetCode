package problem116;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/7
 */
public class Problem116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        Node root = buildTree(nums);

        Solution solution = new Solution();
        root = solution.connect(root);
        List<Node> list = solution.convertList(root);
        for (Node node : list) {
            System.out.println(node.next == null ? null : node.next.val);
        }
    }

    private static Node buildTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nums.length; i++) {
            Node node = queue.peek();
            // 左节点
            if (i % 2 != 0) {
                node.left = new Node(nums[i]);
                queue.offer(node.left);
            } else {
                node.right = new Node(nums[i]);
                queue.offer(node.right);
                // 添加完右节点后可以取出父节点
                queue.poll();
            }
        }
        return root;
    }
}


class Solution {
    int height = 1;

    public Node connect(Node root) {
        if (root == null) return null;
        List<Node> list = convertList(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (i == Math.pow(2, height) - 2) {
                height++;
                continue;
            }
            list.get(i).next = list.get(i + 1);
        }
        return root;
    }

    public List<Node> convertList(Node root) {
        List<Node> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root);
        int index = 0;
        while (list.get(index).left != null || list.get(index).right != null) {
            list.add(list.get(index).left);
            list.add(list.get(index).right);
            index++;
        }
        return list;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
