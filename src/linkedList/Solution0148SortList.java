package linkedList;

import dataStruct.ListNode;

import java.util.*;

/**
 * @Description
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * https://leetcode-cn.com/problems/sort-list/
 * @Author Kai
 * @Date 2021/3/27 16:28
 */
public class Solution0148SortList {
    /**
     * 放入集合排序
     * @param head 头结点
     * @return 排序后的头结点
     */
    public ListNode sortList0(ListNode head) {
        List<Integer> valList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            valList.add(cur.val);
            cur = cur.next;
        }
        valList.sort(Comparator.naturalOrder());
        cur = head;
        for (Integer integer : valList) {
            cur.val = integer;
            cur = cur.next;
        }

        return head;
    }

    /**
     * 归并排序 递归解法
     * @param head 头结点
     * @return 排序完成的子段的头结点
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        // fast起点不能是head
        // 否则，链表节点为偶数时，中点为中间偏右节点，slow.next = null 断开后左右子链表节点数不同
        // 拆分到只剩两个节点时，这两个节点永远分不开，从而导致递归栈溢出
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        // slow为中点，分成两段
        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // 返回链表的哑结点
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left != null) ? left : right;

        return dummyHead.next;
    }
}
