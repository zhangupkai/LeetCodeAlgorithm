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
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
