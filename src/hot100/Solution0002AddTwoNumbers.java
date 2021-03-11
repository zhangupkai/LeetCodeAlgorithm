package hot100;
import dataStruct.ListNode;

/**
 * @Description
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Kai
 * @Date 2021/3/9 20:06
 */

public class Solution0002AddTwoNumbers {
    public ListNode addTowNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2 ;
        // 链表题：定义头结点head和尾结点cur
        ListNode head = null, cur = null;
        int carry = 0; // 进位值
        while (p != null || q != null) {
            if (p == null) {
                p = new ListNode(0);
            }
            if (q == null) {
                q = new ListNode(0);
            }
            int curSum = p.val + q.val + carry;

            if (head == null) {
                head = cur = new ListNode(curSum % 10);
            }
            else {
                cur.next = new ListNode(curSum % 10);
                cur = cur.next;
            }

            carry = curSum / 10;

            p = p.next;
            q = q.next;

        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return head;
    }

}
