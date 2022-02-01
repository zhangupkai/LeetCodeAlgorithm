package linkedList;

import dataStruct.ListNode;

/**
 * @Description
 * @Author Kai
 * @Date 2021/3/30 21:17
 */
public class Solution0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 反转后子链表的头结点
        ListNode newHead = reverseList(head.next);

        // 递归 向上归的过程
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
