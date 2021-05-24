package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你一棵以root为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/5/24 19:02
 */
public class Solution1372LongestZigzagPathInABinaryTree {

    private int ans;
    private final boolean LEFT = false;
    private final boolean RIGHT = true;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        // root节点没有父节点，所以当前已走过的路径长度为0
        dfs(root, LEFT, 0);
        dfs(root, RIGHT, 0);
        return ans;
    }

    /**
     * dfs
     * @param node 节点
     * @param direction 前进方向 LEFT RIGHT
     * @param len 从当前节点node开始的最长交错路径的长度
     */
    public void dfs(TreeNode node, boolean direction, int len) {
        ans = Math.max(ans, len);

        // 当前前进方向为LEFT
        if (direction == LEFT) {
            if (node.left != null) {
                // 当前节点应该向左且可以向左：向左走一步，新的方向为RIGHT，新的len = len + 1
                dfs(node.left, RIGHT, len + 1);
            }
            if (node.right != null) {
                // 当前节点应该向左走但没有左子树：向右走一步，len重置为1，当前节点下传到它的子节点时已经走了一条长度为1的边
                dfs(node.right, LEFT, 1);
            }
        }
        // 当前前进方向为RIGHT
        else {
            if (node.right != null) {
                dfs(node.right, LEFT, len + 1);
            }
            if (node.left != null){
                dfs(node.left, RIGHT, 1);
            }
        }
    }

}
