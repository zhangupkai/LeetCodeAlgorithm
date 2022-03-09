package codetop;

import dataStruct.TreeNode;

/**
 * @Description 二叉树中的最大路径和
 * @Author Kai
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022/3/9 14:49
 */
public class _124binary_tree_maximum_path_sum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * 以当前节点为根节点的子树中，返回经过 node 的单边分支最大和
     * @param node 当前根节点
     * @return 返回经过 node 的单边分支最大和
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftSum = Math.max(dfs(node.left), 0);
        // 计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightSum = Math.max(dfs(node.right), 0);

        int curSum = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, curSum);

        // 返回经过 node 单边最大分支给当前root的父节点计算使用
        return node.val + Math.max(leftSum, rightSum);
    }
}
