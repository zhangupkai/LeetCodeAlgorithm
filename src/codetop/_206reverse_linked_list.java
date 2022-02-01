package codetop;

import dataStruct.ListNode;

/**
 * @Description 单链表反转
 * @Author Kai
 * @Date 2022/2/1 14:57
 */
public class _206reverse_linked_list {
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 子链表反转后的头结点
        ListNode p = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }

    // 迭代
    public ListNode reverseList1(ListNode head) {
        // prev, curr 双指针
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            // 双指针同时向后移动
            prev = curr;
            curr = next;
        }

        // 双指针最后一次移动后，curr指向null，prev指向原链表最后一个节点
        return prev;
    }
}
