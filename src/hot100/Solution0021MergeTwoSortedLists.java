package hot100;

import dataStruct.ListNode;

/**
 * @Description
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author Kai
 * @Date 2021/3/12 8:53
 */
public class Solution0021MergeTwoSortedLists {
    // 迭代解法：自己写的，各种冗余
    public static ListNode mergeTwoListsOld(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            if (l2 == null) {
                if (head == null) {
                    head = tail = new ListNode(l1.val);
                }
                else {
                    tail.next = new ListNode(l1.val);
                    tail = tail.next;
                }
                l1 = l1.next;
            }
            else if (l1 == null) {
                if (head == null) {
                    head = tail = new ListNode(l2.val);
                }
                else {
                    tail.next = new ListNode(l2.val);
                    tail = tail.next;
                }
                l2 = l2.next;
            }
            else {
                if (l1.val <= l2.val) {
                    if (head == null) {
                        head = tail = new ListNode(l1.val);
                    }
                    else {
                        tail.next = new ListNode(l1.val);
                        tail = tail.next;
                    }
                    l1 = l1.next;
                }
                else {
                    if (head == null) {
                        head = tail = new ListNode(l2.val);
                    }
                    else {
                        tail.next = new ListNode(l2.val);
                        tail = tail.next;
                    }
                    l2 = l2.next;
                }
            }
        }

        return head;
    }

    // 迭代解法，优化
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        if (l1 == null) {
            prev.next = l2;
        }
        else {
            prev.next = l1;
        }

        return preHead.next;
    }

    // 递归解法
    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsRecursion(l2.next, l1);
            return l2;
        }

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

        System.out.println(mergeTwoListsRecursion(l1, l2));
    }
}
