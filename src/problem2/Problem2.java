package problem2;


/**
 * Created by shawee on 2018/7/29
 */
public class Problem2 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(head1, head2);
        System.out.println(" " + result.val + result.next.val +result.next.next.val);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置为-1，不会和数据中的非负整数重合
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        //由于这里只要一个成立就可以加，所以下面操作前也要判断是否为空
        while (l1!=null || l2!=null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 +carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
