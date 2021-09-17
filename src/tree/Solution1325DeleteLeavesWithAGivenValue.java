package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你一棵以root为根的二叉树和一个整数target，请你删除所有值为target 的叶子节点 。
 * 注意，一旦删除值为target的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是target ，那么这个节点也应该被删除。
 * 也就是说，你需要重复此过程直到不能继续删除。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-leaves-with-a-given-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/9/17 9:48
 */
public class Solution1325DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        // 根节点可能会被删除，因此需要创建虚拟节点指向根节点
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left = root;
        dfs(root, dummyNode, true, target);
        return dummyNode.left;
    }

    // 根据左右子树是否为空，删除自己，后序（自底向上）+参数扩展
    // 二叉树有两个指针 left 和 right，因此要记录一下当前节点是其父节点的哪个孩子
    public void dfs(TreeNode node, TreeNode parent, boolean isLeft, int target) {
        if (node == null) {
            return;
        }
        dfs(node.left, node, true, target);
        dfs(node.right, node, false, target);
        if (node.val == target && parent != null && node.left == null && node.right == null) {
            if (isLeft) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
    }
}
