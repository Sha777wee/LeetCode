package problem117;

import java.util.*;

/**
 * @Author Shawee
 * @Date 2023/5/7
 */
public class Problem117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] nums = new String[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.next();
        }
        Node root = buildTree(nums);

        Solution solution = new Solution();
        root = solution.connect(root);
        List<Node> list = convertList(root);
        for (Node node : list) {
            if (node == null) continue;
            System.out.println(node.next == null ? null : node.next.val);
        }
    }

    private static Node buildTree(String[] nums) {
        if (nums.length == 0 || nums[0].equals("null")) {
            return null;
        }
        Node root = new Node(Integer.valueOf(nums[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nums.length; i++) {
            Node node = queue.peek();
            if (!nums[i].equals("null")) {
                // 左节点
                if (i % 2 != 0) {
                    node.left = new Node(Integer.valueOf(nums[i]));
                    queue.offer(node.left);
                } else {
                    node.right = new Node(Integer.valueOf(nums[i]));
                    queue.offer(node.right);
                    // 添加完右节点后可以取出父节点
                    queue.poll();
                }
            } else {
                // 左节点
                if (i % 2 != 0) {
                    queue.offer(null);
                } else {
                    queue.offer(null);
                    // 添加完右节点后可以取出父节点
                    queue.poll();
                }
            }
        }
        return root;
    }

    private static List<Node> convertList(Node root) {
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

class Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (pre != null) pre.next = cur;
                pre = cur;
            }
        }
        return root;
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
}
