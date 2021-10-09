package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @Author Kai
 * @Date 2021/10/9 10:57
 */
public class Solution0543DiameterOfBinaryTree {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        // 当前节点为起点的路径（包括左右子树）经过的节点数目为 leftDepth + rightDepth + 1，直径为 leftDepth + rightDepth
        ans = Math.max(ans, leftDepth + rightDepth);
        // 节点深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
