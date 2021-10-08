package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 翻转一棵二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @Author Kai
 * @Date 2021/10/4 14:09
 */
public class Solution0226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
