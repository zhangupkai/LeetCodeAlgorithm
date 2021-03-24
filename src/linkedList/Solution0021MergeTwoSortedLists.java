package linkedList;

import dataStruct.ListNode;

/**
 * @Description
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author Kai
 * @Date 2021/3/24 10:33
 */
public class Solution0021MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
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
        if (l1 == null) {
            cur.next = l2;
        }
        else {
            cur.next = l1;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{1, 3, 4};
        ListNode l1 = null, tail = null;
        for (int j : arr1) {
            if (l1 == null) {
                l1 = tail = new ListNode(j);
            } else {
                tail.next = new ListNode(j);
                tail = tail.next;
            }
        }

        ListNode l2 = null;
        tail = null;
        for (int j : arr2) {
            if (l2 == null) {
                l2 = tail = new ListNode(j);
            } else {
                tail.next = new ListNode(j);
                tail = tail.next;
            }
        }
        System.out.println(mergeTwoLists(l1, l2));
    }
}
