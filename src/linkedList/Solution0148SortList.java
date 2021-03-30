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

    /**
     * 归并排序 自底向上
     * @param head 头结点
     * @return 排序完成后的头结点
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = listLength(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
        for (int subLen = 1; subLen < length; subLen *= 2) {
            ListNode pre = dummy;
            // cur 记录拆分链表的位置
            ListNode cur = dummy.next;

            // 如果链表没有被拆完
            while (cur != null) {
                // 3.1 拆分subLen长度的链表1
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur != null && cur.next != null; ++i) {
                    cur = cur.next;
                }

                // 3.2 拆分subLen长度的链表2
                // 链表2的头 即 链表1尾部的下一个位置
                ListNode head2 = cur.next;
                // 断开第一个链表和第二个链表的链接
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; ++i) {
                    cur = cur.next;
                }

                // 3.3 再次断开 第二个链表最后的next的链接
                ListNode next = null;
                if (cur != null) {
                    // next用于记录 拆分完两个链表的结束位置
                    next = cur.next;
                    cur.next = null;
                }

                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoSortedList(head1, head2);
                pre.next = merged;

                // 将prev移动到 subLen*2 的位置（合并后的最后一个节点）
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }

        return dummy.next;
    }

    /**
     * 合并有序链表
     * @param l1 有序链表1
     * @param l2 有序链表2
     * @return 返回链表
     */
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;

        return dummyHead.next;
    }

    public int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
