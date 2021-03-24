package linkedList;

import dataStruct.ListNode;

/**
 * @Description
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Author Kai
 * @Date 2021/3/24 11:07
 */
public class Solution0083RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return head;
    }
}
