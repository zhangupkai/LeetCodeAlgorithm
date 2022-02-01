package codetop;

import dataStruct.ListNode;

/**
 * @Description
 * @Author Kai
 * @Date 2022/2/1 15:54
 */
public class _92reverse_linked_list_ii {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 使用虚拟头结点，避免因头结点变化导致的分类讨论
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 反转子链表头结点的前驱节点
        ListNode prev = dummyHead;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // 反转子链表头结点
        ListNode subHead = prev.next;

        // 反转子链表尾结点
        ListNode subTail = subHead;
        for (int i = left; i < right; i++) {
            subTail = subTail.next;
        }
        // 反转链表尾结点的后继节点
        ListNode post = subTail.next;

        // 切断主链表与需要反转的子链表
        prev.next = null;
        subTail.next = null;

        // 反转子链表
        reverseList(subHead);

        // 子链表反转后，subTail变为头结点，subHead变为尾结点
        // 连接主链表与反转后的子链表
        prev.next = subTail;
        subHead.next = post;

        return dummyHead.next;
    }

    // 反转单链表
    public ListNode reverseList(ListNode head) {
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
