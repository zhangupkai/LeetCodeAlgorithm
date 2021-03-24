package linkedList;

import dataStruct.ListNode;

/**
 * @Description
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @Author Kai
 * @Date 2021/3/24 11:07
 */
public class Solution0082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // 指向头结点的虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            // diffNode 记录与当前节点不同的节点的位置
            ListNode diffNode = cur;
            // curRepeat 记录与 cur 所指向节点重复的个数，这个变量很关键，后面判断时用得到
            int curRepeat = 0;

            while (diffNode != null && diffNode.val == cur.val) {
                diffNode = diffNode.next;
                ++curRepeat;
            }

            if (curRepeat > 1) {
                pre.next = diffNode;
                cur = diffNode;
            }
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
