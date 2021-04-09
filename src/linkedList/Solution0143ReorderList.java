package linkedList;

import dataStruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/3/27 11:56
 */
public class Solution0143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 用线性表存储链表，使其能够通过下标随机访问
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i >= j) {
                break;
            }
            list.get(j).next = list.get(i);
            --j;
        }
        list.get(i).next = null;
    }

//-----------------------------------------------------------------------------\\

    public void reOrderList2(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        middle.next = null;
        l2 = reverseList(l2);

        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
//        while (fast != null && fast.next != null) {
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            ListNode cur1Next = cur1.next;
            cur1.next = cur2;
            ListNode cur2Next = cur2.next;
            cur2.next = cur1Next;

            cur1 = cur1Next;
            cur2 = cur2Next;
        }

        return l1;
    }
}
