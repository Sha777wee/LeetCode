package problem86;

import java.util.Scanner;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < num; i++) {
            int val = scanner.nextInt();
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        int x = scanner.nextInt();

        Solution solution = new Solution();
        ListNode result = solution.partition(head.next, x);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode curSmallHead = smallHead;
        ListNode largeHead = new ListNode();
        ListNode curLargeHead = largeHead;
        while (head != null) {
            if (head.val < x) {
                curSmallHead.next = head;
                curSmallHead = curSmallHead.next;
            } else {
                curLargeHead.next = head;
                curLargeHead = curLargeHead.next;
            }
            head = head.next;
        }
        // 因为复用原来的节点，可能next不为null，所以要进行清理
        curLargeHead.next = null;
        curSmallHead.next = largeHead.next;
        return smallHead.next;
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

