package codetop;

import dataStruct.TreeNode;

/**
 * @Description 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/10 15:50
 */
public class _106construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    // 起始和终止索引都是闭区间
    private TreeNode dfs(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (!(postEnd - postStart >= 0)) {
            return null;
        }
        // 后序序列的最后一个元素是树的根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 找到根节点在中序序列中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        // 左子树中元素个数
        int leftNum = index - inStart;
        root.left = dfs(inorder, postorder, inStart, index - 1, postStart, postStart + leftNum - 1);
        // Note: 右子树的 postEnd 应该是 postEnd - 1（而不是 postEnd）, 因为后序序列最后一个节点是根节点
        root.right = dfs(inorder, postorder, index + 1, inEnd, postStart + leftNum, postEnd - 1);

        return root;
    }
}
