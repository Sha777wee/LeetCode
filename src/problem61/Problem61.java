package problem61;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/7
 */
public class Problem61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ListNode pre = new ListNode();
        ListNode cur = pre;
        for (int i = 0; i < num; i++) {
            int val = scanner.nextInt();
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        int k = scanner.nextInt();

        Solution solution = new Solution();
        ListNode result = solution.rotateRight(pre.next, k);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        k = k % list.size();
        if (k == 0) return head;
        ListNode result = list.get(list.size() - k);
        cur = result;
        for (int i = list.size() - k + 1; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        for (int i = 0; i < list.size() - k; i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}