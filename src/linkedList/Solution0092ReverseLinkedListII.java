package linkedList;

import dataStruct.ListNode;

/**
 * @Description
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/3/24 19:32
 */
public class Solution0092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 反转链表头结点的前驱结点，反转链表头结点，反转链表尾结点，反转链表尾结点的后继节点
        ListNode pre = dummyHead;
        for (int i = 1; i < left; ++i) {
            pre = pre.next;
        }
        ListNode leftN = pre.next;
        ListNode rightN = leftN;
        for (int i = left; i < right; ++i) {
            rightN = rightN.next;
        }
        ListNode post = rightN.next;

        // 切断连接
        pre.next = null;
        rightN.next = null;

        // 反转子链表
        reverseLinkedList(leftN);

        // 接回原来的链表
        pre.next = rightN;
        leftN.next = post;

        return dummyHead.next;
    }

    /**
     * 反转一个完整的链表
     * @param head 头结点
     */
    public void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
