package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你二叉树的根结点root，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/9/17 9:25
 */
public class Solution0814BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        // 根节点可能会被修改，因为创建一个虚拟节点指向根节点
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left = root;
        dfs(dummyNode);
        return dummyNode.left;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 可以根据子节点的答案计算当前节点的答案 --> 后序遍历
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0) {
            node.left = null;
        }
        if (right == 0) {
            node.right = null;
        }
        return left + right + node.val;
    }

}
