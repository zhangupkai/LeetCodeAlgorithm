package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/8/27 10:34
 */
public class Solution0124BinaryTreeMaximumPathSum {
    public int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxGain(root);
        return ans;
    }

    // 计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 最大贡献值。只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftMaxPath = Math.max(maxGain(node.left), 0);
        int rightMaxPath = Math.max(maxGain(node.right), 0);
        // 最大路径和
        ans = Math.max(ans, leftMaxPath + rightMaxPath + node.val);
        // 返回最大贡献值
        return Math.max(leftMaxPath, rightMaxPath) + node.val;
    }
}
