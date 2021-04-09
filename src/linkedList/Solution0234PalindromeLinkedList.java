package linkedList;

import dataStruct.ListNode;

/**
 * @Description 请判断一个链表是否为回文链表。
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Author Kai
 * @Date 2021/4/6 11:13
 */
public class Solution0234PalindromeLinkedList {
    /**
     * 1.快慢指针找到链表中点，如果链表节点个数为奇数，则中间节点应为前半段
     * 2.将链表后半段反转
     * 3.遍历前半段链表和反转后的后半段的链表，比较
     * 4.将链表还原
     * @param head 头结点
     * @return T or F
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 为中点（左半段的尾结点）
        ListNode right = slow.next;
        right = reverseList(right);
        slow.next = null;
        ListNode left = head;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        // TODO 链表还原

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
