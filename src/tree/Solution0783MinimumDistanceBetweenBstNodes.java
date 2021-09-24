package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @Author Kai
 * @Date 2021/9/23 10:24
 */
public class Solution0783MinimumDistanceBetweenBstNodes {

    // 中序遍历序列的上一节点值
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    // 二叉搜索树中序遍历 结果是 有序数组
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
            if (ans == 1) {
                return;
            }
        }
        pre = root.val;
        dfs(root.right);
    }
}
