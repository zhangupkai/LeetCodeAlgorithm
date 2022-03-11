package codetop;

import dataStruct.TreeNode;

/**
 * @Description 根据前序和后序遍历构造二叉树
 * 给定两个整数数组，preorder和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *
 * 如果存在多个答案，您可以返回其中 任何 一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/10 15:02
 */
public class _889construct_binary_tree_from_preorder_and_postorder_traversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        // 在后序序列中找到左子树根节点 preorder[preStart+1]的索引
        int index = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                index = i;
                break;
            }
        }
        // 左子树节点数量
        int leftSum = index - postStart + 1;
        // index 指向后序序列 左子树根节点（左子树序列最后一个节点），index + 1 指向后序序列右子树序列第一个节点
        root.left = dfs(preorder, postorder, preStart + 1, preStart + leftSum, postStart, index);
        root.right = dfs(preorder, postorder, preStart + leftSum + 1, preEnd, index + 1, postEnd);

        return root;
    }
}
