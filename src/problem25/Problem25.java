package problem25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/8
 */
public class Problem25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ListNode pre = new ListNode();
        ListNode cur = pre;
        for (int i = 0; i < num; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }
        int k = scanner.nextInt();

        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup(pre.next, k);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}


class Solution {

    List<ListNode> list = new ArrayList<>();

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        for (int i = 0; i < list.size(); i += k) {
            if (i + k > list.size()) break;
            for (int j = i + k - 1; j > i; j--) {
                list.get(j).next = list.get(j - 1);
            }


            if (i + k == list.size()) {
                //  当前是最后一次反转且正好使用完所有节点
                list.get(i).next = null;
            } else if (i + 2 * (k - 1) + 1 < list.size()) {
                // 下一次循环还需要反转
                list.get(i).next = list.get(i + 2 * (k - 1) + 1);
            } else {
                // 下一次循环不需要反转了
                list.get(i).next = list.get(i + k);
            }

        }
        return k > list.size() ? head : list.get(k - 1);
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        pre.next = head;
        ListNode end = pre;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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