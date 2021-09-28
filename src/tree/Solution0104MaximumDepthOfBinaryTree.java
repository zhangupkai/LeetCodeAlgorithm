package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Author Kai
 * @Date 2021/9/26 19:02
 */
public class Solution0104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
