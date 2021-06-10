package tree;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @Author Kai
 * @Date 2021/6/10 15:38
 */
public class Solution0099RecoverBinarySearchTree {

    private List<Integer> inorderSeq;

    public void recoverTree(TreeNode root) {
        inorderSeq = new ArrayList<>();
        inorder(root);
        int[] swagIndex = findTwoSwaggedElement();
        recover(root, swagIndex[0], swagIndex[1], 2);
    }

    // 第三步：重新遍历BST，修改对应位置的节点值
    // count 用来计数修改了几次节点值，修改完毕提前结束递归
    public void recover(TreeNode root, int x, int y, int count) {
        if (root == null) {
            return;
        }
        recover(root.left, x, y, count);
        if (root.val == x) {
            root.val = y;
            --count;
        }
        else if (root.val == y) {
            root.val = x;
            --count;
        }
        if (count == 0) {
            return;
        }
        recover(root.right, x, y, count);
    }

    // 第二步：找到序列中被交换的两个元素
    public int[] findTwoSwaggedElement() {
        // x,y 分别为交换位置的两个元素在list中的下标
        // case1: 两个元素不相邻，会有两对相邻的逆序数，x为第一对第一个数，y为第二对第二个数
        // case2: 两个元素相邻，只有一对相邻的逆序数，x y分别是这两个数
        int x = -1, y = -1;
        for (int i = 0; i < inorderSeq.size() - 1; i++) {
            if (inorderSeq.get(i + 1) < inorderSeq.get(i)) {
                // x为第一对第一个数，后续不再更新
                if (x == -1){
                    x = inorderSeq.get(i);
                }
                y = inorderSeq.get(i + 1);
            }
        }
        return new int[] {x, y};
    }

    // 第一步：中序遍历序列存入list
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderSeq.add(root.val);
        inorder(root.right);
    }
}
