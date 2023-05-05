package problem2;


import java.util.Objects;
import java.util.Scanner;

/**
 * Created by shawee on 2018/7/29
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] arr1 = new int[num1];
        ListNode head1 = new ListNode(-1);
        ListNode cur = head1;
        for (int i = 0; i < num1; i++) {
            if (i > 0) cur = cur.next;
            cur.next = new ListNode(scanner.nextInt());
        }

        int num2 = scanner.nextInt();
        ListNode head2 = new ListNode(-1);
        cur = head2;
        for (int i = 0; i < num2; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }

        ListNode result = Solution.addTwoNumbers(head1.next, head2.next);
        System.out.println("result:");
        while (Objects.nonNull(result)) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置为-1，不会和数据中的非负整数重合
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        //由于这里只要一个成立就可以加，所以下面操作前也要判断是否为空
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
